package net.weg.sistemabiblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import net.weg.sistemabiblioteca.controller.dto.response.UsuarioResponseDTO;

/**
 * Representa um usuário do sistema da biblioteca.
 */
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    /**
     * Identificador único do usuário.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nome do usuário.
     */
    @Column(nullable = false)
    private String nome;

    /**
     * CPF do usuário.
     */
    @Column(nullable = false)
    private String cpf;

    /**
     * Cargo do usuário na biblioteca.
     */
    @Column(nullable = false)
    private String cargo;

    /**
     * Converte a entidade Usuario para um objeto UsuarioResponseDTO.
     *
     * @return DTO representando o usuário.
     */
    public UsuarioResponseDTO toDto() {
        return new UsuarioResponseDTO(id, nome, cpf);
    }
}