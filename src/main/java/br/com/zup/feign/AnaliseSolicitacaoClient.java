package br.com.zup.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.zup.request.AnaliseDePropostaRequest;
import br.com.zup.response.AnaliseDePropostaResponse;

/*015.consultando_dados_solicitante*/
@FeignClient(name = "analise-solicitacao", url = "http://localhost:9999")
public interface AnaliseSolicitacaoClient {
	
	@PostMapping("/api/solicitacao")
	AnaliseDePropostaResponse consulta(AnaliseDePropostaRequest request);

}
