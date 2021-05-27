package br.com.zup.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.zup.response.AssociarCartaoResponse;

@FeignClient(value = "cartoes", url = "http://localhost:8888")
public interface AssociarCartaoClient {
		
	@GetMapping(value = "/api/cartoes")
	ResponseEntity<AssociarCartaoResponse> consultaCartao(@RequestParam("idProposta") String idProposta);

}
