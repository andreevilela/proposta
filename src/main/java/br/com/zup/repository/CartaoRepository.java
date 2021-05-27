package br.com.zup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.propostas.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

}
