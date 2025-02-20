package net.weg.sistemabiblioteca.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.weg.sistemabiblioteca.controller.dto.request.AutorRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.AutorResponseDTO;
import net.weg.sistemabiblioteca.entity.Autor;
import net.weg.sistemabiblioteca.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para operações relacionadas à entidade Autor.
 */
@RestController
@RequestMapping("/autor")
@Tag(name = "Autor", description = "Operações relacionadas ao Autor")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService service;

    /**
     * Cria um novo Autor e retorna os dados cadastrados.
     *
     * @param autorRequest Objeto contendo os dados do Autor a ser criado.
     * @return ResponseEntity contendo o Autor criado.
     */
    @PostMapping
    @Operation(summary = "Criar Autor", description = "Cria um novo Autor e retorna os dados cadastrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Autor criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<AutorResponseDTO> create(@RequestBody AutorRequestDTO autorRequest) {
        try {
            AutorResponseDTO autor = service.create(autorRequest);
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Obtém os dados de um Autor pelo ID informado.
     *
     * @param id Identificador do Autor.
     * @return ResponseEntity contendo o Autor encontrado.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Autor por ID", description = "Obtém os dados de um Autor pelo ID informado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Autor encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Autor não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<AutorResponseDTO> findById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retorna uma lista com todos os Autores cadastrados.
     *
     * @return ResponseEntity contendo a lista de Autores.
     */
    @GetMapping
    @Operation(summary = "Listar Autores", description = "Retorna uma lista com todos os Autores cadastrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<AutorResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Remove um Autor do sistema pelo ID informado.
     *
     * @param id Identificador do Autor a ser removido.
     * @return ResponseEntity sem conteúdo.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Autor", description = "Remove um Autor do sistema pelo ID informado.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Autor deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Autor não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
