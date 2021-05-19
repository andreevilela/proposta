package br.com.zup.propostas;

public class AnaliseDePropostaResponse {

	private String documento;
	private String nome;
	private String idProposta;
	private ResultadoSolicitacao resultadoSolicitacao;

	public AnaliseDePropostaResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnaliseDePropostaResponse(String documento, String nome, String idProposta,
			ResultadoSolicitacao resultadoSolicitacao) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
		this.resultadoSolicitacao = resultadoSolicitacao;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public String getIdProposta() {
		return idProposta;
	}

	public ResultadoSolicitacao getResultadoSolicitacao() {
		return resultadoSolicitacao;
	}

	public Status status() {
		return resultadoSolicitacao.getStatus();
		
	}

}
