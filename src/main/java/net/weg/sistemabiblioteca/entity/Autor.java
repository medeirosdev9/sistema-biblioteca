package net.weg.sistemabiblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.sistemabiblioteca.controller.dto.response.AutorResponseDTO;

import java.util.List;

/**
 * Entidade que representa um Autor no sistema.
 */
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "autores")
public class Autor {

    /**
     * Identificador único do Autor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nome do Autor.
     */
    @Column(nullable = false)
    private String nome;

    /**
     * Lista de livros associados ao Autor.
     */
    @OneToMany(cascade = CascadeType.PERSIST)
    public List<Livro> livros;

    /**
     * Converte a entidade Autor para um DTO de resposta.
     *
     * @return AutorResponseDTO contendo os dados do Autor.
     */
    public AutorResponseDTO toDto() {
        return new AutorResponseDTO(this.id, this.nome);
    }
}
