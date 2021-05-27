package br.com.zup.propostas;

import java.util.Date;

public class Vencimento {

	private String id;
	private int dia;
	private Date dataDeCriacao;

	public Vencimento() {
	}

	public Vencimento(String id, int dia, Date dataDeCriacao) {
		super();
		this.id = id;
		this.dia = dia;
		this.dataDeCriacao = dataDeCriacao;
	}

	public String getId() {
		return id;
	}

	public int getDia() {
		return dia;
	}

	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}

}
