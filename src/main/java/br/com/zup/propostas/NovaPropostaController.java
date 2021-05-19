package br.com.zup.propostas;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import feign.FeignException;

@RestController
@RequestMapping("/api/propostas")
public class NovaPropostaController {
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	private AnaliseSolicitacaoClient analiseClient;
	
	@PostMapping
	public ResponseEntity<?> cadastra(@RequestBody @Valid NovaPropostaRequest request,
			UriComponentsBuilder uriBuilder) {
		
		if(propostaRepository.existsByDocumento(request.getDocumento())) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		Proposta novaProposta = request.paraProposta();
		
		propostaRepository.save(novaProposta);
		
		try {
			AnaliseDePropostaRequest analiseRequest = 
					new AnaliseDePropostaRequest(novaProposta.getDocumento(),
												novaProposta.getNome(), 
												novaProposta.getId());
			
			AnaliseDePropostaResponse resultadoDaConsulta = analiseClient.consulta(analiseRequest);
			Status status = resultadoDaConsulta.status();
				
			novaProposta.setStatus(status);
						
		} catch (FeignException.UnprocessableEntity entity) {
			novaProposta.setStatus(Status.NAO_ELEGIVEL);
			
		} catch (FeignException.ServiceUnavailable ex) {
			propostaRepository.delete(novaProposta);
		}
		
		propostaRepository.save(novaProposta);
		
		URI location = uriBuilder.path("/api/propostas/{id}").
				buildAndExpand(novaProposta.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
