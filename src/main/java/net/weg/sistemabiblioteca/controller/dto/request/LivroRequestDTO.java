package net.weg.sistemabiblioteca.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRequestDTO(
        @NotBlank String titulo,
        @NotNull Integer quantidade,
        @NotBlank String sinopse,
        @NotBlank String genero,
        @NotNull Integer autor_id
) {}
