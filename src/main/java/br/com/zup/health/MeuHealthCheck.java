package br.com.zup.health;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class MeuHealthCheck implements HealthIndicator {
	
	@Override
    public Health health() {
        Map<String, Object> details = new HashMap<>();
        details.put("versão", "1.2.3");
        details.put("descrição", "Aqui pode vir alguma informação customizada caso solicitado");
        details.put("endereço", "127.0.0.1");
        return Health.up().withDetails(details).build();
    }

}
