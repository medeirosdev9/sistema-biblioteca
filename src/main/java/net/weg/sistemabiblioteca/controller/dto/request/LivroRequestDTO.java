package net.weg.sistemabiblioteca.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import net.weg.sistemabiblioteca.entity.Autor;
import net.weg.sistemabiblioteca.entity.Emprestimo;
import net.weg.sistemabiblioteca.entity.Livro;

public record LivroRequestDTO(

        @NotBlank String titulo,
        @NotNull Integer quantidade,

        @NotBlank String sinopse,

        @NotBlank String genero,

        @NotNull Integer autor_id


) {

}
