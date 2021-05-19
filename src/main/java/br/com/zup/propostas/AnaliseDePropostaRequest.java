package br.com.zup.propostas;

public class AnaliseDePropostaRequest {

	private String documento;
	private String nome;
	private Long idProposta;

	/*
	 * @deprecated apenas para o uso do framework
	 */

	@Deprecated
	public AnaliseDePropostaRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnaliseDePropostaRequest(String documento, String nome, Long idProposta) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public Long getIdProposta() {
		return idProposta;
	}

}
