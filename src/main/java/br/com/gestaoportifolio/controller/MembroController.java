package br.com.gestaoportifolio.controller;

import br.com.gestaoportifolio.model.Membro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface MembroController {

    @Operation(summary = "Adicionar um novo membro",
            description = "Adiciona um novo membro ao sistema com base nos dados enviados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Membro adicionado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Membro.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Erro no servidor",
                    content = @Content(mediaType = "application/json"))
    })
    @PostMapping
    Membro adicionar(@RequestBody Membro membro);
}