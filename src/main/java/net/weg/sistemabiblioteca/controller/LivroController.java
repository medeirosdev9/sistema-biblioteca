package net.weg.sistemabiblioteca.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.sistemabiblioteca.controller.dto.request.LivroRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.LivroResponseDTO;
import net.weg.sistemabiblioteca.entity.Livro;
import net.weg.sistemabiblioteca.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
@AllArgsConstructor
@Tag(name = "Livro", description = "Operações relacionadas ao Livro")
public class LivroController {

    private LivroService service;

    /**
     * Cria um novo Livro.
     *
     * @param livroDto Objeto com os dados para criação do Livro.
     * @return JSON do Livro criado e status da requisição.
     */
    @PostMapping
    @Operation(summary = "Criar Livro", description = "Método para criar um novo Livro e retornar seu JSON com o status da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Livro criado com sucesso."),
            @ApiResponse(responseCode = "422", description = "Falha na validação dos dados enviados."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<LivroResponseDTO> create(@RequestBody @Valid LivroRequestDTO livroDto) {
        try {
            LivroResponseDTO livroResponseDTO = service.create(livroDto);
            return new ResponseEntity<>(livroResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Atualiza um Livro existente com base no ID informado.
     *
     * @param livro Objeto com os novos dados do Livro.
     * @param id    ID do Livro que será atualizado.
     * @return JSON do Livro atualizado e status da requisição.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Livro", description = "Método para atualizar um Livro existente com base no ID informado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<Livro> update(@RequestBody Livro livro, @PathVariable Integer id) {
        Livro livroAtualizado = service.update(livro, id);
        return new ResponseEntity<>(livroAtualizado, HttpStatus.OK);
    }

    /**
     * Busca um Livro pelo seu ID.
     *
     * @param id ID do Livro a ser buscado.
     * @return JSON do Livro encontrado e status da requisição.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Livro por ID", description = "Método para buscar um Livro com base no ID informado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Livro encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<LivroResponseDTO> findById(@PathVariable Integer id) {
        try {
            LivroResponseDTO livro = service.findById(id);
            return new ResponseEntity<>(livro, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Lista todos os Livros cadastrados.
     *
     * @return Lista de JSONs dos Livros e status da requisição.
     */
    @GetMapping
    @Operation(summary = "Listar Todos os Livros", description = "Método para listar todos os Livros cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Livros listados com sucesso."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<List<LivroResponseDTO>> findAll() {
        try {
            List<LivroResponseDTO> livros = service.findAll();
            return new ResponseEntity<>(livros, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deleta um Livro pelo seu ID.
     *
     * @param id ID do Livro a ser deletado.
     * @return Status da requisição.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Livro", description = "Método para deletar um Livro com base no ID informado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Livro deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
