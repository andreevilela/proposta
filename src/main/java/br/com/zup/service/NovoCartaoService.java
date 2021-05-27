package br.com.zup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.feign.AssociarCartaoClient;
import br.com.zup.propostas.Cartao;
import br.com.zup.propostas.Proposta;
import br.com.zup.propostas.enums.Status;
import br.com.zup.repository.CartaoRepository;
import br.com.zup.repository.PropostaRepository;
import br.com.zup.response.AssociarCartaoResponse;
import feign.FeignException;

@Service
public class NovoCartaoService {

	@Autowired
	AssociarCartaoClient associarCartaoClient;

	@Autowired
	PropostaRepository propostaRepository;

	@Autowired
	CartaoRepository cartaoRepository;

	public Cartao gravar(Proposta proposta) {

		AssociarCartaoResponse associarCartaoResponse = null;
		try {
			associarCartaoResponse = associarCartaoClient.consultaCartao(proposta.getId().toString()).getBody();

			Cartao cartao = associarCartaoResponse.paraCartao();
			proposta.setCartao(cartao);

			proposta.setStatus(Status.ASSOCIADO);

			propostaRepository.save(proposta);

		} catch (FeignException e) {
			System.out.println("Em processamento");

		}

		return null;
	}

}
