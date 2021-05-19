package br.com.zup.propostas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
	
	/*010.nao_pode_haver_proposta*/
	boolean existsByDocumento(String documento);
	
	

}
