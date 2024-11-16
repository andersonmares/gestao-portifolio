package br.com.gestaoportifolio.controller.impl;

import br.com.gestaoportifolio.controller.MembroController;
import br.com.gestaoportifolio.model.Membro;
import br.com.gestaoportifolio.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/membros")
public class MembroControllerImpl implements MembroController {

    @Autowired
    private MembroService membroService;

    @PostMapping
    public Membro adicionar(@RequestBody Membro membro) {
        return membroService.adicionar(membro);
    }
}
