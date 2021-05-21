package br.com.zup.request;

public class AnaliseDePropostaRequest {

	private String documento;
	private String nome;
	private Long idProposta;

	public AnaliseDePropostaRequest() {
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
