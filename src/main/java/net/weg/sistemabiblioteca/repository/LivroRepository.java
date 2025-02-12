package net.weg.sistemabiblioteca.repository;

import net.weg.sistemabiblioteca.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
