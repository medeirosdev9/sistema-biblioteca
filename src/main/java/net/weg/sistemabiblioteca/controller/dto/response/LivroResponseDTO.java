package net.weg.sistemabiblioteca.controller.dto.response;

/**
 * DTO de resposta para representar os detalhes de um livro.
 */
public record LivroResponseDTO(

        /**
         * Identificador único do livro.
         */
        Integer id,

        /**
         * Título do livro.
         */
        String titulo,

        /**
         * Gênero do livro.
         */
        String genero,

        /**
         * Identificador do autor do livro.
         */
        Integer autor_id
) {}
