package net.weg.sistemabiblioteca.repository;

import net.weg.sistemabiblioteca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
