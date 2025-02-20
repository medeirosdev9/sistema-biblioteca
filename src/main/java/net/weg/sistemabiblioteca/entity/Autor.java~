package net.weg.sistemabiblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.sistemabiblioteca.controller.dto.response.AutorResponseDTO;

import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(cascade = CascadeType.PERSIST)
    public List<Livro> livros;

    public AutorResponseDTO toDto() {
        return new AutorResponseDTO(this.id, this.nome);
    }
}
