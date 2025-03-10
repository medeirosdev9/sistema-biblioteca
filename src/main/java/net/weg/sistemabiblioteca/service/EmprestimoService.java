package net.weg.sistemabiblioteca.service;

import net.weg.sistemabiblioteca.controller.dto.request.EmprestimoRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.EmprestimoResponseDTO;
import net.weg.sistemabiblioteca.entity.Emprestimo;
import net.weg.sistemabiblioteca.entity.Livro;
import net.weg.sistemabiblioteca.entity.Usuario;
import net.weg.sistemabiblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Serviço responsável pelo gerenciamento de empréstimos de livros na biblioteca.
 */
@Service
public class EmprestimoService {

    private final EmprestimoRepository repository;
    private final UsuarioService usuarioService;
    private final LivroService livroService;

    /**
     * Construtor do serviço de empréstimos.
     *
     * @param repository     Repositório de empréstimos.
     * @param usuarioService Serviço para manipulação de usuários.
     * @param livroService   Serviço para manipulação de livros.
     */
    public EmprestimoService(EmprestimoRepository repository, UsuarioService usuarioService, LivroService livroService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
        this.livroService = livroService;
    }

    /**
     * Cria um novo empréstimo.
     *
     * @param emprestimoRequestDTO DTO contendo os dados do empréstimo.
     * @return DTO de resposta representando o empréstimo criado.
     */
    public EmprestimoResponseDTO create(EmprestimoRequestDTO emprestimoRequestDTO) {
        Emprestimo emprestimo = repository.save(toEntity(emprestimoRequestDTO));
        return emprestimo.toDto();
    }

    /**
     * Atualiza um empréstimo existente.
     *
     * @param emprestimo DTO contendo os novos dados do empréstimo.
     * @param id         Identificador do empréstimo a ser atualizado.
     * @return DTO de resposta representando o empréstimo atualizado.
     */
    public EmprestimoResponseDTO update(EmprestimoRequestDTO emprestimo, Integer id) {
        Emprestimo emprestimoNovo = toEntity(emprestimo);
        emprestimoNovo.setId(id);
        repository.save(emprestimoNovo);
        return emprestimoNovo.toDto();
    }

    /**
     * Exclui um empréstimo pelo ID.
     *
     * @param id Identificador do empréstimo a ser excluído.
     */
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Busca um empréstimo pelo ID.
     *
     * @param id Identificador do empréstimo.
     * @return DTO de resposta representando o empréstimo encontrado.
     * @throws NoSuchElementException Se o empréstimo não for encontrado.
     */
    public EmprestimoResponseDTO findById(Integer id) {
        Emprestimo emprestimo = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return emprestimo.toDto();
    }

    /**
     * Lista todos os empréstimos cadastrados.
     *
     * @return Lista de DTOs de resposta representando os empréstimos.
     */
    public List<EmprestimoResponseDTO> findAll() {
        return repository.findAll().stream().map(Emprestimo::toDto).collect(Collectors.toList());
    }

    /**
     * Converte um DTO de requisição de empréstimo para a entidade correspondente.
     * Busca as entidades `Usuario` e `Livro` associadas ao empréstimo.
     *
     * @param emprestimo DTO de requisição do empréstimo.
     * @return Entidade `Emprestimo` criada a partir dos dados do DTO.
     */
    private Emprestimo toEntity(EmprestimoRequestDTO emprestimo) {
        Usuario usuario = usuarioService.findEntityById(emprestimo.usuarioId());
        Livro livro = livroService.findEntityById(emprestimo.livroId());

        return Emprestimo.builder()
                .usuario(usuario)
                .livro(livro)
                .dataEmprestimo(emprestimo.dataEmprestimo())
                .dataDevolucao(emprestimo.dataDevolucao())
                .build();
    }
}
