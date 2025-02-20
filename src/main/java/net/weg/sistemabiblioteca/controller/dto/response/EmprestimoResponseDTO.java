package net.weg.sistemabiblioteca.controller.dto.response;

import net.weg.sistemabiblioteca.entity.Livro;
import net.weg.sistemabiblioteca.entity.Usuario;

import java.time.LocalDate;

/**
 * DTO de resposta para representar os detalhes de um empréstimo.
 */
public record EmprestimoResponseDTO(

        /**
         * Identificador único do empréstimo.
         */
        Integer id,

        /**
         * Usuário que realizou o empréstimo.
         */
        Usuario usuario,

        /**
         * Livro emprestado.
         */
        Livro livro,

        /**
         * Data em que o empréstimo foi realizado.
         */
        LocalDate dataEmprestimo,

        /**
         * Data prevista para a devolução do livro.
         */
        LocalDate dataDevolucao

) {}