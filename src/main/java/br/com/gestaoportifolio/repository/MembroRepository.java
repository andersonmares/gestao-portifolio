package br.com.gestaoportifolio.repository;

import br.com.gestaoportifolio.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

}
