package net.weg.sistemabiblioteca.controller.dto.response;

public record UsuarioResponseDTO(
        /**
         * Identificador único do usuario.
         */
        Integer id,
        /**
         * Nome do usuario.
         */
        String nome,
        /**
         * CPF do usuario.
         */
        String cpf
) {}