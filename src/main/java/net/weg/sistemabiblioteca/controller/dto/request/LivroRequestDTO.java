package net.weg.sistemabiblioteca.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO para requisição de criação ou atualização de um Livro.
 */
public record LivroRequestDTO(

        /**
         * Título do livro.
         */
        @NotBlank String titulo,

        /**
         * Quantidade disponível do livro.
         */
        @NotNull Integer quantidade,

        /**
         * Sinopse do livro.
         */
        @NotBlank String sinopse,

        /**
         * Gênero do livro.
         */
        @NotBlank String genero,

        /**
         * ID do autor do livro.
         */
        @NotNull Integer autor_id
) {}
