package net.weg.sistemabiblioteca.repository;

import net.weg.sistemabiblioteca.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
