package br.com.gestaoportifolio.repository;

import br.com.gestaoportifolio.model.Membro;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Hidden
@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

}
