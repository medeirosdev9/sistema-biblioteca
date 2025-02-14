package net.weg.sistemabiblioteca.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
public record UsuarioRequestDTO(

        @NotBlank String nome,
        @NotBlank String cpf
) {


}
