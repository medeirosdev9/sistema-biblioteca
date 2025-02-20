package net.weg.sistemabiblioteca.repository;

import net.weg.sistemabiblioteca.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Repositório responsável por acessar e gerenciar os dados da entidade Emprestimo no banco de dados.
 */
@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
}
