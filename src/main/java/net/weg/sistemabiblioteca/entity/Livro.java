package net.weg.sistemabiblioteca.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;

    @NonNull
    @Column(nullable = false)
    private String titulo;

    @NonNull
    @Column(nullable = false)
    private String sinopse;

    @NonNull
    @Column(nullable = false)
    private String autor;

    @NonNull
    @Column(nullable = false)
    private String genero;

    @NonNull
    @Column(nullable = false)
    private Integer quantidade;

    @NonNull
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Fornecedor fornecedor;


}
