package net.weg.sistemabiblioteca.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(
        @NotBlank String nome,
        @NotBlank  String cpf,
        @NotBlank String cargo
) {}