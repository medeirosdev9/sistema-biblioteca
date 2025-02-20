package net.weg.sistemabiblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import net.weg.sistemabiblioteca.controller.dto.response.EmprestimoResponseDTO;

import java.time.LocalDate;

/**
 * Representa um empréstimo de livro na biblioteca.
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emprestimos")
public class Emprestimo {

    /**
     * Identificador único do empréstimo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Usuário que realizou o empréstimo.
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    /**
     * Livro emprestado.
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    /**
     * Data em que o empréstimo foi realizado.
     */
    @Column(nullable = false)
    private LocalDate dataEmprestimo;

    /**
     * Data prevista para a devolução do livro.
     */
    @Column(nullable = false)
    private LocalDate dataDevolucao;

    /**
     * Converte a entidade Emprestimo para seu DTO correspondente.
     *
     * @return um objeto {@link net.weg.sistemabiblioteca.controller.dto.response.EmprestimoResponseDTO} representando os dados do empréstimo.
     */
    public EmprestimoResponseDTO toDto() {
        return new EmprestimoResponseDTO(id, usuario, livro, dataEmprestimo, dataDevolucao);
    }
}
