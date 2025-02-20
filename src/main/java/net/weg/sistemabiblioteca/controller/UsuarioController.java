package net.weg.sistemabiblioteca.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.weg.sistemabiblioteca.controller.dto.request.UsuarioRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.UsuarioResponseDTO;
import net.weg.sistemabiblioteca.entity.Usuario;
import net.weg.sistemabiblioteca.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }


    @PostMapping
    @Tag(name = "Usuario", description = "Operações relacionadas ao Usuario")
    @Operation(summary = "Post Usuario", description = "Método para postar um Usuario, retorna o JSON do Usuario + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<UsuarioResponseDTO> create(@RequestBody @Validated UsuarioRequestDTO usuarioRequest) {
        try {
            return new ResponseEntity<>(service.create(usuarioRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Atualiza um Usuario existente com base no ID informado.
     *
     * @param usuario Objeto com os novos dados do Usuario.
     * @param id    ID do Usuario que será atualizado.
     * @return JSON do Usuario atualizado e status da requisição.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Usuario", description = "Método para atualizar um Usuario existente com base no ID informado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Usuario não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, @PathVariable Integer id) {
        Usuario usuarioAtualizado = service.update(usuario, id);
        return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
    }

    /**
     * Busca um Usuario pelo seu ID.
     *
     * @param id ID do Usuario a ser buscado.
     * @return JSON do Usuario encontrado e status da requisição.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Usuario por ID", description = "Método para buscar um Usuario com base no ID informado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Usuario não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable Integer id) {
        try {
            UsuarioResponseDTO usuario = service.findById(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * Lista todos os Usuarios cadastrados.
     *
     * @return Lista de JSONs dos Usuarios e status da requisição.
     */
    @GetMapping
    @Operation(summary = "Listar Todos os Usuarios", description = "Método para listar todos os Usuarios cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuarios listados com sucesso."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        try {
            List<UsuarioResponseDTO> Usuarioes = service.findAll();
            return new ResponseEntity<>(Usuarioes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deleta um Usuario pelo seu ID.
     *
     * @param id ID do Usuario a ser deletado.
     * @return Status da requisição.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Usuario", description = "Método para deletar um Usuario com base no ID informado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Usuario não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

