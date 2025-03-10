package net.weg.sistemabiblioteca.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.weg.sistemabiblioteca.controller.dto.request.EmprestimoRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.EmprestimoResponseDTO;
import net.weg.sistemabiblioteca.service.EmprestimoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gerenciar operações relacionadas a Empréstimos.
 */
@RestController
@RequestMapping("/emprestimo")
@Tag(name = "Emprestimo", description = "Operações relacionadas ao Empréstimo")
public class EmprestimoController {

    private final EmprestimoService service;

    /**
     * Construtor para injetar a dependência do serviço de empréstimos.
     *
     * @param service Serviço de empréstimos
     */
    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    /**
     * Cria um novo empréstimo.
     *
     * @param emprestimoRequest Dados do novo empréstimo
     * @return ResponseEntity contendo os detalhes do empréstimo criado
     */
    @PostMapping
    @Operation(summary = "Criar Emprestimo", description = "Registra um novo empréstimo e retorna os dados do empréstimo salvo.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empréstimo criado com sucesso."),
            @ApiResponse(responseCode = "422", description = "Dados inválidos na requisição."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<EmprestimoResponseDTO> create(@RequestBody @Validated EmprestimoRequestDTO emprestimoRequest) {
        try {
            EmprestimoResponseDTO emprestimo = service.create(emprestimoRequest);
            return new ResponseEntity<>(emprestimo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Atualiza um empréstimo existente.
     *
     * @param emprestimo Dados atualizados do empréstimo
     * @param id ID do empréstimo a ser atualizado
     * @return ResponseEntity contendo os detalhes do empréstimo atualizado
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Emprestimo", description = "Atualiza os dados de um empréstimo existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empréstimo atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<EmprestimoResponseDTO> update(@RequestBody EmprestimoRequestDTO emprestimo, @PathVariable Integer id) {
        return ResponseEntity.ok(service.update(emprestimo, id));
    }

    /**
     * Busca um empréstimo pelo ID.
     *
     * @param id ID do empréstimo
     * @return ResponseEntity contendo os detalhes do empréstimo encontrado
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Emprestimo por ID", description = "Obtém os detalhes de um empréstimo pelo ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empréstimo encontrado."),
            @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<EmprestimoResponseDTO> findById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retorna uma lista de todos os empréstimos cadastrados.
     *
     * @return ResponseEntity contendo a lista de empréstimos
     */
    @GetMapping
    @Operation(summary = "Listar Todos os Emprestimos", description = "Retorna uma lista de todos os empréstimos cadastrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de empréstimos retornada com sucesso."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<List<EmprestimoResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Deleta um empréstimo pelo ID.
     *
     * @param id ID do empréstimo a ser removido
     * @return ResponseEntity sem conteúdo
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Emprestimo", description = "Remove um empréstimo pelo ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empréstimo removido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
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
