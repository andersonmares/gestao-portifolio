package br.com.gestaoportifolio.controller.impl;

import br.com.gestaoportifolio.model.Projeto;
import br.com.gestaoportifolio.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/projetos")
public class ProjetoControllerImpl {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("projetos", projetoService.listarTodos());
        return "projetos/lista"; // JSP está em /WEB-INF/views/projetos/lista.jsp
    }


    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("projeto", new Projeto());
        return "projetos/form";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute Projeto projeto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "projetos/form";
        }
        projetoService.salvar(projeto);
        attributes.addFlashAttribute("mensagem", "Projeto salvo com sucesso!");
        return "redirect:/projetos/lista";
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
        projetoService.excluir(id);
        attributes.addFlashAttribute("mensagem", "Projeto excluído com sucesso!");
        return "redirect:/projetos/lista";
    }
}