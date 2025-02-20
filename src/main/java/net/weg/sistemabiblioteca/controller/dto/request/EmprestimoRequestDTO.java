package net.weg.sistemabiblioteca.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record EmprestimoRequestDTO(

        @NotNull Integer usuarioId,
        @NotNull Integer livroId,

        @NotNull LocalDate dataEmprestimo,
        @NotNull LocalDate dataDevolucao
) {
}
