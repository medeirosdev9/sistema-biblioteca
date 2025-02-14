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

    private LivroRepository repository;
    private AutorService autorService;

    /**
     * Cria um novo livro no sistema.
     *
     * @param livroRequestDTO Objeto contendo as informações do livro a ser criado.
     * @return DTO de resposta contendo os dados do livro criado.
     */
    public LivroResponseDTO create(LivroRequestDTO livroRequestDTO) {
        Livro livro = repository.save(toEntity(livroRequestDTO));
        return livro.toDto();
    }

    /**
     * Atualiza os dados de um livro existente.
     *
     * @param livro Objeto contendo os novos dados do livro.
     * @param id    Identificador do livro a ser atualizado.
     * @return O livro atualizado.
     */
    public Livro update(Livro livro, Integer id) {
        livro.setId(id);
        return repository.save(livro);
    }

    /**
     * Exclui um livro do sistema com base no seu ID.
     *
     * @param id Identificador do livro a ser excluído.
     */
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Busca um livro pelo seu ID.
     *
     * @param id Identificador do livro a ser buscado.
     * @return DTO de resposta contendo os dados do livro encontrado.
     * @throws NoSuchElementException Se o livro não for encontrado.
     */
    public LivroResponseDTO findById(Integer id) {
        Livro livro = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return livro.toDto();
    }

    /**
     * Retorna uma lista de todos os livros cadastrados no sistema.
     *
     * @return Lista de DTOs de resposta contendo os dados dos livros.
     */
    public List<LivroResponseDTO> findAll() {
        return repository.findAll().stream().map(Livro::toDto).collect(Collectors.toList());
    }

    /**
     * Converte um DTO de requisição de livro para uma entidade Livro.
     *
     * @param livro DTO contendo os dados do livro.
     * @return Entidade Livro correspondente.
     */
    public Livro toEntity(LivroRequestDTO livro) {
        return Livro.builder()
                .autor(autorService.buscarAutor(livro.autor_id()))
                .titulo(livro.titulo())
                .sinopse(livro.sinopse())
                .genero(livro.genero())
                .build();
    }
}
