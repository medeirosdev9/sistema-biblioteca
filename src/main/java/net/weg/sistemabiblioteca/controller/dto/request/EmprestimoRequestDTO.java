package net.weg.sistemabiblioteca.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import net.weg.sistemabiblioteca.entity.Livro;
import net.weg.sistemabiblioteca.entity.Usuario;

public record EmprestimoRequestDTO(

        @NotBlank Usuario usuario,
        @NotBlank Livro livro
        ) {
}
