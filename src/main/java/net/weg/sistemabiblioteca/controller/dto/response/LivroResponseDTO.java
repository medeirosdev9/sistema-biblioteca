package net.weg.sistemabiblioteca.controller.dto.response;

public record LivroResponseDTO(
        Integer id,
        String titulo,
        String genero,
        Integer autor_id
) {}
