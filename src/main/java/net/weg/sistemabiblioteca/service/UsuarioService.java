package net.weg.sistemabiblioteca.service;

import net.weg.sistemabiblioteca.controller.dto.request.UsuarioRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.UsuarioResponseDTO;
import net.weg.sistemabiblioteca.entity.Usuario;
import net.weg.sistemabiblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Serviço responsável pelo gerenciamento de usuários no sistema da biblioteca.
 */
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    /**
     * Cria um novo usuário no sistema.
     *
     * @param usuarioRequestDTO Objeto DTO contendo as informações do usuário.
     * @return Objeto DTO representando o usuário criado.
     */
    public UsuarioResponseDTO create(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = repository.save(toEntity(usuarioRequestDTO));
        return usuario.toDto();
    }

    /**
     * Atualiza um usuário existente.
     *
     * @param usuario Objeto do usuário com os novos dados.
     * @param id Identificador do usuário a ser atualizado.
     * @return Objeto do usuário atualizado.
     */
    public Usuario update(Usuario usuario, Integer id) {
        usuario.setId(id);
        return repository.save(usuario);
    }

    /**
     * Exclui um usuário do sistema pelo seu ID.
     *
     * @param id Identificador do usuário a ser removido.
     */
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Busca um usuário pelo seu ID.
     *
     * @param id Identificador do usuário.
     * @return Objeto DTO representando o usuário encontrado.
     * @throws NoSuchElementException Se o usuário não for encontrado.
     */
    public UsuarioResponseDTO findById(Integer id) {
        Usuario usuario = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return usuario.toDto();
    }


    /**
     * Retorna uma lista de todos os usuários cadastrados no sistema.
     *
     * @return Lista de objetos DTO representando os usuários.
     */
    public List<UsuarioResponseDTO> findAll() {
        return repository.findAll().stream().map(Usuario::toDto).collect(Collectors.toList());
    }

    public Usuario findEntityById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado!"));
    }


    /**
     * Converte um DTO de requisição de usuário para uma entidade {@link Usuario}.
     *
     * @param usuario Objeto DTO de requisição.
     * @return Objeto da entidade Usuario.
     */
    public Usuario toEntity(UsuarioRequestDTO usuario) {
        return Usuario.builder()
                .nome(usuario.nome())
                .cpf(usuario.cpf())
                .cargo(usuario.cargo())
                .build();
    }

}
