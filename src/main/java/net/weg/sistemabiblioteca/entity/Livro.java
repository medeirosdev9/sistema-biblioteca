package net.weg.sistemabiblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import net.weg.sistemabiblioteca.controller.dto.response.LivroResponseDTO;

/**
 * Representa um livro cadastrado na biblioteca.
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "livros")
public class Livro {

    /**
     * Identificador único do livro.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Título do livro.
     */
    @Column(nullable = false)
    private String titulo;

    /**
     * Sinopse do livro.
     */
    @Column(nullable = false)
    private String sinopse;

    /**
     * Gênero do livro.
     */
    @Column(nullable = false)
    private String genero;

    /**
     * Quantidade de exemplares disponíveis.
     */
    @Column(nullable = false)
    private Integer quantidade;

    /**
     * Autor do livro.
     */
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Autor autor;

    /**
     * Converte a entidade Livro para seu DTO correspondente.
     *
     * @return um objeto {@link net.weg.sistemabiblioteca.controller.dto.response.LivroResponseDTO} representando os dados do livro.
     */
    public LivroResponseDTO toDto() {
        return new LivroResponseDTO(id, titulo, genero, autor.getId());
    }
}
