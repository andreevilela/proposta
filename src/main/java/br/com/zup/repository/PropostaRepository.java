package br.com.zup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.propostas.Proposta;
import br.com.zup.propostas.enums.Status;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {

	boolean existsByDocumento(String documento);

	List<Proposta> findAllByStatus(Status elegivel);

}
