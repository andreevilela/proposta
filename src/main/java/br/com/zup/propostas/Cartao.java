package br.com.zup.propostas;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cartao")
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCartao;
	private String numeroDoCartao;
	private String emitidoEm;
	private String titular;
	private BigDecimal limite;
	private boolean renegociacao;
	@Embedded
	private Vencimento vencimento;
	private Long idProposta;

	public Cartao() {
	}

	public Cartao(Long idCartao, String numeroDoCartao, String emitidoEm, String titular, BigDecimal limite,
			boolean renegociacao, Vencimento vencimento, Long idProposta) {
		super();
		this.idCartao = idCartao;
		this.numeroDoCartao = numeroDoCartao;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite = limite;
		this.renegociacao = renegociacao;
		this.vencimento = vencimento;
		this.idProposta = idProposta;
	}

	public Long getId() {
		return idCartao;
	}

	public String getNumeroDoCartao() {
		return numeroDoCartao;
	}

	public String getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public boolean isRenegociacao() {
		return renegociacao;
	}

	public Vencimento getVencimento() {
		return vencimento;
	}

	public Long getIdProposta() {
		return idProposta;
	}

}
