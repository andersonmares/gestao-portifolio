package br.com.gestaoportifolio.controller;

import br.com.gestaoportifolio.model.Projeto;
import br.com.gestaoportifolio.model.Status;
import br.com.gestaoportifolio.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("projetos", projetoService.listarTodos());
        return "projetos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("projeto", new Projeto());
        model.addAttribute("statusList", Status.values());
        return "projetos/form";
    }

    @PostMapping
    public String salvar(@Valid Projeto projeto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "projetos/form";
        }
        projetoService.salvar(projeto);
        attributes.addFlashAttribute("mensagem", "Projeto salvo com sucesso!");
        return "redirect:/projetos";
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
        projetoService.excluir(id);
        attributes.addFlashAttribute("mensagem", "Projeto excluído com sucesso!");
        return "redirect:/projetos";
    }
}
