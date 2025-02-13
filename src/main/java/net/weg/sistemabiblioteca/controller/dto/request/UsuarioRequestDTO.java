package net.weg.sistemabiblioteca.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import net.weg.sistemabiblioteca.entity.Usuario;

public record UsuarioRequestDTO(

        @NotBlank String nome,
        @NotBlank String cpf
) {

    public Usuario toEntity() {
        return Usuario.builder()
                .nome(this.nome)
                .cpf(this.cpf)
                .build();
    }
}
