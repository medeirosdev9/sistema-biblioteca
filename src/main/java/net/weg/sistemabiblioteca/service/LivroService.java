package net.weg.sistemabiblioteca.service;

import net.weg.sistemabiblioteca.controller.dto.request.LivroRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.LivroResponseDTO;
import net.weg.sistemabiblioteca.entity.Livro;
import net.weg.sistemabiblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Serviço responsável pelo gerenciamento de livros no sistema.
 */
@Service
public class LivroService {

    private final LivroRepository repository;
    private final AutorService autorService;

    /**
     * Construtor da classe LivroService.
     *
     * @param repository   Repositório de livros.
     * @param autorService Serviço responsável pelo gerenciamento de autores.
     */
    public LivroService(LivroRepository repository, AutorService autorService) {
        this.repository = repository;
        this.autorService = autorService;
    }

    /**
     * Cria um novo livro no sistema.
     *
     * @param livroRequestDTO DTO contendo as informações do livro.
     * @return DTO de resposta com os dados do livro criado.
     */
    public LivroResponseDTO create(LivroRequestDTO livroRequestDTO) {
        Livro livro = repository.save(toEntity(livroRequestDTO));
        return livro.toDto();
    }

    /**
     * Atualiza um livro existente.
     *
     * @param livro Livro atualizado.
     * @param id    Identificador do livro a ser atualizado.
     * @return Livro atualizado.
     */
    public Livro update(Livro livro, Integer id) {
        livro.setId(id);
        return repository.save(livro);
    }

    /**
     * Exclui um livro do sistema pelo seu ID.
     *
     * @param id Identificador do livro a ser removido.
     */
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Busca um livro pelo seu ID e retorna como DTO.
     *
     * @param id Identificador do livro.
     * @return DTO de resposta do livro encontrado.
     * @throws NoSuchElementException Se o livro não for encontrado.
     */
    public LivroResponseDTO findById(Integer id) {
        Livro livro = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return livro.toDto();
    }

    /**
     * Busca um livro pelo seu ID e retorna a entidade Livro.
     *
     * @param id Identificador do livro.
     * @return Entidade Livro encontrada.
     * @throws NoSuchElementException Se o livro não for encontrado.
     */
    public Livro findEntityById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Livro não encontrado!"));
    }

    /**
     * Retorna uma lista de todos os livros cadastrados no sistema.
     *
     * @return Lista de DTOs de resposta dos livros.
     */
    public List<LivroResponseDTO> findAll() {
        return repository.findAll().stream().map(Livro::toDto).collect(Collectors.toList());
    }

    /**
     * Converte um DTO de requisição de livro para a entidade Livro.
     *
     * @param livro DTO contendo os dados do livro.
     * @return Entidade Livro.
     */
    public Livro toEntity(LivroRequestDTO livro) {
        return Livro.builder()
                .autor(autorService.buscarAutor(livro.autor_id()))
                .titulo(livro.titulo())
                .sinopse(livro.sinopse())
                .genero(livro.genero())
                .quantidade(livro.quantidade())
                .build();
    }
}
