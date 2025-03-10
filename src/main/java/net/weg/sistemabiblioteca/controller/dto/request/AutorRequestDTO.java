package net.weg.sistemabiblioteca.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import net.weg.sistemabiblioteca.entity.Autor;

/**
 * DTO para requisições relacionadas à entidade Autor.
 */
public record AutorRequestDTO(

        /**
         * Nome do autor. Não pode ser nulo ou vazio.
         */
        @NotBlank String nome
) {

    /**
     * Converte este DTO em uma entidade Autor.
     *
     * @return Objeto da entidade Autor com os dados preenchidos a partir deste DTO.
     */
    public Autor toEntity(){
        return Autor.builder()
                .nome(this.nome)
                .build();
    }
}