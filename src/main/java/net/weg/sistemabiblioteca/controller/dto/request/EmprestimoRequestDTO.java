package net.weg.sistemabiblioteca.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * DTO para requisições relacionadas à entidade Emprestimo.
 */
public record EmprestimoRequestDTO(
        /**
         * Id do autor. Não pode ser nulo ou vazio.
         */
        @NotNull Integer usuarioId,
        /**
         * Id do livro. Não pode ser nulo ou vazio.
         */
        @NotNull Integer livroId,

        /**
         * Data de empréstimo. Não pode ser nula.
         */
        @NotNull LocalDate dataEmprestimo,

        /**
         * Data de devolução. Não pode ser nula.
         */
        @NotNull LocalDate dataDevolucao
) {
}
