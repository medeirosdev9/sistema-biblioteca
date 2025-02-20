package net.weg.sistemabiblioteca.controller.dto.response;

/**
 * DTO para respostas relacionadas à entidade Autor.
 */
public record AutorResponseDTO(

        /**
         * Identificador único do autor.
         */
        Integer id,

        /**
         * Nome do autor.
         */
        String nome
) {
}
