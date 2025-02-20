package net.weg.sistemabiblioteca.repository;

import net.weg.sistemabiblioteca.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório responsável por acessar e gerenciar os dados da entidade Autor no banco de dados.
 */
@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
}