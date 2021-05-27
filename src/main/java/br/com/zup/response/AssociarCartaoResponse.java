package br.com.zup.response;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Embedded;

import br.com.zup.propostas.Cartao;
import br.com.zup.propostas.Vencimento;

public class AssociarCartaoResponse {

	private String id;
	private String emitidoEm;
	private String titular;
	private List<?> bloqueios;
	private List<?> avisos;
	private List<?> carteiras;
	private List<?> parcelas;
	private BigDecimal limite;
	private boolean renegociacao;
	@Embedded
	private Vencimento vencimento;
	private Long idProposta;

	public AssociarCartaoResponse() {
	}

	public AssociarCartaoResponse(String id, String emitidoEm, String titular, List<?> bloqueios, List<?> avisos,
			List<?> carteiras, List<?> parcelas, BigDecimal limite, boolean renegociacao, Vencimento vencimento,
			Long idProposta) {
		super();
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.bloqueios = bloqueios;
		this.avisos = avisos;
		this.carteiras = carteiras;
		this.parcelas = parcelas;
		this.limite = limite;
		this.renegociacao = renegociacao;
		this.vencimento = vencimento;
		this.idProposta = idProposta;
	}

	public String getId() {
		return id;
	}

	public String getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public List<?> getBloqueios() {
		return bloqueios;
	}

	public List<?> getAvisos() {
		return avisos;
	}

	public List<?> getCarteiras() {
		return carteiras;
	}

	public List<?> getParcelas() {
		return parcelas;
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

	public Cartao paraCartao() {
		return new Cartao(idProposta, id, emitidoEm, titular, limite, renegociacao, vencimento, idProposta);
	}

}
