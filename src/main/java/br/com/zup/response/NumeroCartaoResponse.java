package br.com.zup.response;

import org.springframework.format.annotation.DateTimeFormat;

public class NumeroCartaoResponse {

	private String id;
	private DateTimeFormat emitidoEm;
	private String titular;

	public NumeroCartaoResponse() {
	}

	public NumeroCartaoResponse(String id, DateTimeFormat emitidoEm, String titular) {
		super();
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
	}

	public String getId() {
		return id;
	}

	public DateTimeFormat getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

}
