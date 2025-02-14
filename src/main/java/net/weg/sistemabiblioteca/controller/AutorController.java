package net.weg.sistemabiblioteca.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import net.weg.sistemabiblioteca.controller.dto.request.AutorRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.request.LivroRequestDTO;
import net.weg.sistemabiblioteca.controller.dto.response.AutorResponseDTO;
import net.weg.sistemabiblioteca.controller.dto.response.LivroResponseDTO;
import net.weg.sistemabiblioteca.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private AutorService service;

    @PostMapping
    @Tag(name = "Autor", description = "Operações relacionadas ao Autor")
    @Operation(summary = "Post Autor", description = "Método para postar um Autor, retorna o JSON do Autor + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<AutorResponseDTO> create(@RequestBody @Validated AutorRequestDTO autorRequest) {
        try {
            return new ResponseEntity<>(service.create(autorRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


}
