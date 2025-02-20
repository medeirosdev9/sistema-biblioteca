package net.weg.sistemabiblioteca.repository;

import net.weg.sistemabiblioteca.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repositório responsável por acessar e gerenciar os dados da entidade Livro no banco de dados.
 */
public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
