package br.com.zup.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.feign.AnaliseSolicitacaoClient;
import br.com.zup.propostas.Proposta;
import br.com.zup.propostas.enums.Status;
import br.com.zup.repository.PropostaRepository;
import br.com.zup.request.AnaliseDePropostaRequest;
import br.com.zup.request.NovaPropostaRequest;
import br.com.zup.response.AnaliseDePropostaResponse;
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

		if (propostaRepository.existsByDocumento(request.getDocumento())) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
		}

		Proposta novaProposta = request.paraProposta();

		try {
			AnaliseDePropostaRequest analiseRequest = new AnaliseDePropostaRequest(novaProposta.getDocumento(),
					novaProposta.getNome(), novaProposta.getId());

			AnaliseDePropostaResponse resultadoDaConsulta = analiseClient.consulta(analiseRequest);
			Status status = resultadoDaConsulta.status();

			novaProposta.setStatus(status);

		} catch (FeignException.UnprocessableEntity entity) {
			novaProposta.setStatus(Status.NAO_ELEGIVEL);

		}

		propostaRepository.save(novaProposta);

		URI uri = uriBuilder.path("/api/propostas/{id}").buildAndExpand(novaProposta.getId()).toUri();
		return ResponseEntity.created(uri).body(novaProposta);
	}

}
