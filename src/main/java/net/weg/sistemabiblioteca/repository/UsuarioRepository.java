package net.weg.sistemabiblioteca.repository;

import net.weg.sistemabiblioteca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/**
 * Repositório responsável por acessar e gerenciar os dados da entidade Usuario no banco de dados.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCpf(String cpf);
}