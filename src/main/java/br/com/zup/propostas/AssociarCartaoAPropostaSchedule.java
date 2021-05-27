package br.com.zup.propostas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.zup.propostas.enums.Status;
import br.com.zup.repository.PropostaRepository;
import br.com.zup.service.NovoCartaoService;

@Configuration
@EnableScheduling
@EnableAsync
public class AssociarCartaoAPropostaSchedule {

	@Autowired
	NovoCartaoService novoCartaoService;

	@Autowired
	private PropostaRepository propostaRepository;

	public List<Proposta> listaPropostasElegiveis() {

		return propostaRepository.findAllByStatus(Status.ELEGIVEL);
	}

	@Scheduled(fixedDelay = 10000)
	public void AssociaCartaoAProposta() {

		List<Proposta> lista = listaPropostasElegiveis();
		System.out.println("Dentro do schedule");
		System.out.println(lista.toString());

		for (Proposta proposta : lista) {
			novoCartaoService.gravar(proposta);

		}

	}

}
