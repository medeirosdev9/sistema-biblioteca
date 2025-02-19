package net.weg.sistemabiblioteca.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.weg.sistemabiblioteca.controller.dto.request.AutorRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.AutorResponseDTO;
import net.weg.sistemabiblioteca.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
@Tag(name = "Autor", description = "Operações relacionadas ao Autor")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService service;

    @PostMapping
    @Operation(summary = "Criar Autor", description = "Cria um novo Autor e retorna os dados cadastrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Autor criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<AutorResponseDTO> create(@RequestBody  AutorRequestDTO autorRequest) {
        return ResponseEntity.status(201).body(service.create(autorRequest));
    }

//    @PutMapping("/{id}")
//    @Operation(summary = "Atualizar Autor", description = "Atualiza os dados de um Autor existente pelo ID.")
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", description = "Autor atualizado com sucesso"),
//            @ApiResponse(responseCode = "404", description = "Autor não encontrado"),
//            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
//            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
//    })
////    public ResponseEntity<AutorResponseDTO> update(@PathVariable Integer id, @RequestBody AutorRequestDTO autorRequest) {
////        return ResponseEntity.ok(service.update(autorRequest));
////    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Autor por ID", description = "Obtém os dados de um Autor pelo ID informado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Autor encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Autor não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<AutorResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    @Operation(summary = "Listar Autores", description = "Retorna uma lista com todos os Autores cadastrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<AutorResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Autor", description = "Remove um Autor do sistema pelo ID informado.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Autor deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Autor não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
