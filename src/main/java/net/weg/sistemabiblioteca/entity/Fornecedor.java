package net.weg.sistemabiblioteca.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;

    @OneToMany(mappedBy = "fornecedor")
    private List<Livro> livros;

    @NonNull
    @Column(nullable = false)
    private String cnpf;
}
