package br.com.gestaoportifolio.service;

import br.com.gestaoportifolio.model.Membro;
import br.com.gestaoportifolio.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    public Membro adicionar(Membro membro) {
        return membroRepository.save(membro);
    }
}
