package net.weg.sistemabiblioteca.service;

import net.weg.sistemabiblioteca.controller.dto.request.UsuarioRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.LivroResponseDTO;
import net.weg.sistemabiblioteca.controller.dto.response.UsuarioResponseDTO;
import net.weg.sistemabiblioteca.entity.Livro;
import net.weg.sistemabiblioteca.entity.Usuario;
import net.weg.sistemabiblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioResponseDTO create(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = repository.save(toEntity(usuarioRequestDTO));
        return usuario.toDto();
    }

    public Usuario update(Usuario usuario, Integer id) {
        usuario.setId(id);
        return repository.save(usuario);
    }

    public void delete (Integer id) {
        repository.deleteById(id);
    }

    public UsuarioResponseDTO findById(Integer id) {
        Usuario usuario = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return usuario.toDto();
    }

    public List<UsuarioResponseDTO> findAll() {
        return repository.findAll().stream().map(Usuario::toDto).collect(Collectors.toList());
    }

    public Usuario toEntity(UsuarioRequestDTO usuario) {
        return Usuario.builder()
                .nome(usuario.nome())
                .cpf(usuario.cpf())
                .build();
    }
}