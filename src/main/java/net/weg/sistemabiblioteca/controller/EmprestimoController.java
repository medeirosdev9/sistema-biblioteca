package net.weg.sistemabiblioteca.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.weg.sistemabiblioteca.controller.dto.request.EmprestimoRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.EmprestimoResponseDTO;
import net.weg.sistemabiblioteca.entity.Emprestimo;
import net.weg.sistemabiblioteca.service.EmprestimoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
@Tag(name = "Emprestimo", description = "Operações relacionadas ao Emprestimo")
public class EmprestimoController {

    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Criar Emprestimo", description = "Registra um novo empréstimo e retorna os dados do empréstimo salvo.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empréstimo criado com sucesso."),
            @ApiResponse(responseCode = "422", description = "Dados inválidos na requisição."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<EmprestimoResponseDTO> create(@RequestBody @Validated EmprestimoRequestDTO emprestimoRequest) {
        return ResponseEntity.ok(service.create(emprestimoRequest));
    }

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

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Emprestimo por ID", description = "Obtém os detalhes de um empréstimo pelo ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empréstimo encontrado."),
            @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<EmprestimoResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    @Operation(summary = "Listar Todos os Emprestimos", description = "Retorna uma lista de todos os empréstimos cadastrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de empréstimos retornada com sucesso."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<List<EmprestimoResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Emprestimo", description = "Remove um empréstimo pelo ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Empréstimo removido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
