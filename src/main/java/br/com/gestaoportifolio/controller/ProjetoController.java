package br.com.gestaoportifolio.controller;

import br.com.gestaoportifolio.model.Projeto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Tag(name = "Projetos")
public interface ProjetoController {

    @Operation(summary = "Listar todos os projetos",
            description = "Lista todos os projetos disponíveis no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Projetos listados com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Projeto.class))),
            @ApiResponse(responseCode = "500", description = "Erro no servidor",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping
    String listar(Model model);

    @Operation(summary = "Exibir formulário para novo projeto",
            description = "Exibe o formulário para adicionar um novo projeto.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Formulário exibido com sucesso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Erro no servidor",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/novo")
    String novo(Model model);

    @Operation(summary = "Salvar um novo projeto",
            description = "Salva um novo projeto no sistema com base nos dados enviados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Projeto salvo com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Projeto.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Erro no servidor",
                    content = @Content(mediaType = "application/json"))
    })
    @PostMapping
    String salvar(Projeto projeto, BindingResult result, RedirectAttributes attributes);

    @Operation(summary = "Excluir um projeto",
            description = "Exclui um projeto do sistema com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Projeto excluído com sucesso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Requisição inválida",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Erro no servidor",
                    content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("/{id}")
    String excluir(@PathVariable Long id, RedirectAttributes attributes);
}