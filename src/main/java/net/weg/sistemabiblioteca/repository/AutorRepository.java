package net.weg.sistemabiblioteca.repository;

import net.weg.sistemabiblioteca.controller.dto.request.AutorRequestDTO;
import net.weg.sistemabiblioteca.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Integer> {


}
