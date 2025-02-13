package net.weg.sistemabiblioteca.service;

import net.weg.sistemabiblioteca.controller.dto.request.AutorRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.AutorResponseDTO;
import net.weg.sistemabiblioteca.entity.Autor;
import net.weg.sistemabiblioteca.repository.AutorRepository;

import java.util.NoSuchElementException;

public class AutorService {
    private AutorRepository repository;

    public AutorResponseDTO create(AutorRequestDTO autorRequestDTO) {
        Autor autor = repository.save(autorRequestDTO.toEntity());
        return autor.toDto();
    }

    public AutorResponseDTO findById(Integer id) {
        Autor autor = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return autor.toDto();
    }

    public Autor buscarAutor(Integer id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

}
