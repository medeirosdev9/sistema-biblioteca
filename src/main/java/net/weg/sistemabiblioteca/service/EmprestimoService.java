package net.weg.sistemabiblioteca.service;

import net.weg.sistemabiblioteca.controller.dto.request.EmprestimoRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.EmprestimoResponseDTO;
import net.weg.sistemabiblioteca.entity.Emprestimo;
import net.weg.sistemabiblioteca.repository.EmprestimoRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Serviço responsável pelo gerenciamento de empréstimos.
 */
public class EmprestimoService {

    private EmprestimoRepository repository;

    /**
     * Cria um novo empréstimo.
     * @param emprestimoRequestDTO Dados do empréstimo a ser criado.
     * @return Empréstimo criado convertido em DTO.
     */
    public EmprestimoResponseDTO create(EmprestimoRequestDTO emprestimoRequestDTO) {
        Emprestimo emprestimo = repository.save(toEntity(emprestimoRequestDTO));
        return emprestimo.toDto();
    }

    /**
     * Atualiza um empréstimo existente.
     * @param emprestimo Empréstimo atualizado.
     * @param id Identificador do empréstimo.
     * @return Empréstimo atualizado.
     */
    public Emprestimo update(Emprestimo emprestimo, Integer id) {
        emprestimo.setId(id);
        return repository.save(emprestimo);
    }

    /**
     * Deleta um empréstimo pelo ID.
     * @param id Identificador do empréstimo a ser deletado.
     */
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Busca um empréstimo pelo ID.
     * @param id Identificador do empréstimo.
     * @return Empréstimo encontrado convertido em DTO.
     * @throws NoSuchElementException Se o empréstimo não for encontrado.
     */
    public EmprestimoResponseDTO findById(Integer id) {
        Emprestimo emprestimo = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return emprestimo.toDto();
    }

    /**
     * Retorna a lista de todos os empréstimos.
     * @return Lista de empréstimos convertidos em DTO.
     */
    public List<EmprestimoResponseDTO> findAll() {
        return repository.findAll().stream().map(Emprestimo::toDto).collect(Collectors.toList());
    }

    /**
     * Converte um DTO de empréstimo para entidade.
     * @param emprestimo Dados do empréstimo.
     * @return Entidade de empréstimo.
     */
    private Emprestimo toEntity(EmprestimoRequestDTO emprestimo) {
        return Emprestimo.builder()
                .usuario(emprestimo.usuario())
                .livro(emprestimo.livro())
                .build();
    }
}