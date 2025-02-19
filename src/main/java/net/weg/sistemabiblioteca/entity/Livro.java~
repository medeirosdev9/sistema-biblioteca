package net.weg.sistemabiblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import net.weg.sistemabiblioteca.controller.dto.response.LivroResponseDTO;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String sinopse;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Autor autor;


    public LivroResponseDTO toDto() {
        return new LivroResponseDTO(id, titulo, genero, autor.getId());
    }
}
