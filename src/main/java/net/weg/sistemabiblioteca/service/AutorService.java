package net.weg.sistemabiblioteca.service;

import net.weg.sistemabiblioteca.controller.dto.request.AutorRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.AutorResponseDTO;
import net.weg.sistemabiblioteca.entity.Autor;
import net.weg.sistemabiblioteca.entity.Livro;
import net.weg.sistemabiblioteca.repository.AutorRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class AutorService {
    private AutorRepository repository;

    public AutorResponseDTO create(AutorRequestDTO autorRequestDTO) {
        Autor autor = repository.save(autorRequestDTO.toEntity());
        return autor.toDto();
    }

    public Autor update(Autor autor, Integer id) {
        autor.setId(id);
        return repository.save(autor);
    }

    public AutorResponseDTO findById(Integer id) {
        Autor autor = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return autor.toDto();
    }

    public List<AutorResponseDTO> findAll() {
        return repository.findAll().stream().map(Autor::toDto).collect(Collectors.toList());
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Autor buscarAutor(Integer id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

}
