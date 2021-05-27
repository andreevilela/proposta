package br.com.zup.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.zup.request.AnaliseDePropostaRequest;
import br.com.zup.response.AnaliseDePropostaResponse;

@FeignClient(name = "analise-solicitacao", url = "http://localhost:9999")
public interface AnaliseSolicitacaoClient {

	@PostMapping("/api/solicitacao")
	AnaliseDePropostaResponse consulta(AnaliseDePropostaRequest analiseDePropostaRequest);

}
