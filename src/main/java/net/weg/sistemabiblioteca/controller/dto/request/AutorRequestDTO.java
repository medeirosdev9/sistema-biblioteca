package net.weg.sistemabiblioteca.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import net.weg.sistemabiblioteca.entity.Autor;

public record AutorRequestDTO(

        @NotBlank String nome
) {

    public Autor toEntity(){
        return Autor.builder()
                .nome(this.nome)
                .build();
    }
}
