package net.weg.sistemabiblioteca.controller.dto.response;

public record UsuarioResponseDTO(
        Integer id,
        String nome,
        String cpf
) {}