package net.weg.sistemabiblioteca.repository;

import net.weg.sistemabiblioteca.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
