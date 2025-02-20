package net.weg.sistemabiblioteca.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(
        /**
         * Nome do usuario
         */
        @NotBlank String nome,
        /**
         * CPF do usuario
         */
        @NotBlank  String cpf,
        /**
         * Cargo do usuario
         */
        @NotBlank String cargo
) {}