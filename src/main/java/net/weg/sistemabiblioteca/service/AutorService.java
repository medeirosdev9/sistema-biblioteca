package net.weg.sistemabiblioteca.service;

import jakarta.validation.constraints.NotNull;
import net.weg.sistemabiblioteca.controller.dto.request.AutorRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.AutorResponseDTO;
import net.weg.sistemabiblioteca.entity.Autor;
import net.weg.sistemabiblioteca.repository.AutorRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Serviço responsável pelo gerenciamento de autores.
 */
public class AutorService {
    private AutorRepository repository;

    /**
     * Cria um novo autor.
     * @param autorRequestDTO Dados do autor a ser criado.
     * @return Autor criado convertido em DTO.
     */
    public AutorResponseDTO create(AutorRequestDTO autorRequestDTO) {
        Autor autor = repository.save(autorRequestDTO.toEntity());
        return autor.toDto();
    }

    /**
     * Atualiza um autor existente.
     * @param autor Autor atualizado.
     * @param id Identificador do autor.
     * @return Autor atualizado.
     */
    public Autor update(Autor autor, Integer id) {
        autor.setId(id);
        return repository.save(autor);
    }

    /**
     * Busca um autor pelo ID.
     * @param id Identificador do autor.
     * @return Autor encontrado convertido em DTO.
     * @throws NoSuchElementException Se o autor não for encontrado.
     */
    public AutorResponseDTO findById(Integer id) {
        Autor autor = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return autor.toDto();
    }

    /**
     * Retorna a lista de todos os autores.
     * @return Lista de autores convertidos em DTO.
     */
    public List<AutorResponseDTO> findAll() {
        return repository.findAll().stream().map(Autor::toDto).collect(Collectors.toList());
    }

    /**
     * Deleta um autor pelo ID.
     * @param id Identificador do autor a ser deletado.
     */
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Busca um autor pelo ID retornando a entidade.
     * @param id Identificador do autor.
     * @return Autor encontrado.
     * @throws NoSuchElementException Se o autor não for encontrado.
     */
    public Autor buscarAutor(@NotNull Integer id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}


