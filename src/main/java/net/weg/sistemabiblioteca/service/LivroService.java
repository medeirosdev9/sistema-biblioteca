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

    public LivroService(LivroRepository repository, AutorService autorService) {
        this.repository = repository;
        this.autorService = autorService;
    }

    public LivroResponseDTO create(LivroRequestDTO livroRequestDTO) {
        Livro livro = repository.save(toEntity(livroRequestDTO));
        return livro.toDto();
    }

    public Livro update(Livro livro, Integer id) {
        livro.setId(id);
        return repository.save(livro);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public LivroResponseDTO findById(Integer id) {
        Livro livro = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return livro.toDto();
    }

    public Livro findEntityById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Livro não encontrado!"));
    }


    public List<LivroResponseDTO> findAll() {
        return repository.findAll().stream().map(Livro::toDto).collect(Collectors.toList());
    }

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
