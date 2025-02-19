package net.weg.sistemabiblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import net.weg.sistemabiblioteca.controller.dto.response.EmprestimoResponseDTO;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    @Column(nullable = false)
    private LocalDate dataEmprestimo;

    @Column(nullable = false)
    private LocalDate dataDevolucao;

    public EmprestimoResponseDTO toDto() {
        return new EmprestimoResponseDTO(id, usuario, livro, dataEmprestimo, dataDevolucao);
    }
}