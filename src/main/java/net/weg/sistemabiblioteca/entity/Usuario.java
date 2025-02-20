package net.weg.sistemabiblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import net.weg.sistemabiblioteca.controller.dto.response.UsuarioResponseDTO;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String cargo;

    public UsuarioResponseDTO toDto() {
        return new UsuarioResponseDTO(id, nome, cpf);
    }

}
