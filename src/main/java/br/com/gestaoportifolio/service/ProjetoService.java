package br.com.gestaoportifolio.service;

import br.com.gestaoportifolio.exception.BusinessException;
import br.com.gestaoportifolio.model.Projeto;
import br.com.gestaoportifolio.model.Status;
import br.com.gestaoportifolio.repository.ProjetoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }

    public Projeto buscarPorId(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado"));
    }

    public Projeto salvar(Projeto projeto) {
        if (projeto.getStatus() == Status.INICIADO ||
                projeto.getStatus() == Status.EM_ANDAMENTO ||
                projeto.getStatus() == Status.ENCERRADO) {
            throw new BusinessException("Não é possível excluir projeto com status iniciado, em andamento ou encerrado.");
        }
        return projetoRepository.save(projeto);
    }

    public void excluir(Long id) {
        Projeto projeto = projetoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado"));
        if (projeto.getStatus() == Status.INICIADO ||
            projeto.getStatus() == Status.EM_ANDAMENTO ||
            projeto.getStatus() == Status.ENCERRADO) {
            throw new BusinessException("Não é possível excluir projeto com status iniciado, em andamento ou encerrado.");
        }
        projetoRepository.delete(projeto);
    }
}
