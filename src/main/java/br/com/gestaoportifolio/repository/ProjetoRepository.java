package br.com.gestaoportifolio.repository;

import br.com.gestaoportifolio.model.Projeto;
import br.com.gestaoportifolio.model.Status;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Hidden
@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    List<Projeto> findByStatus(Status status);
}
