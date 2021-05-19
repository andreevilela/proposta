package br.com.zup.propostas;

import javax.validation.constraints.NotBlank;

public class EnderecoRequest {

	@NotBlank
	private String cep;

	@NotBlank
	private String rua;

	@NotBlank
	private String numero;

	@NotBlank
	private String bairro;

	@NotBlank
	private String cidade;

	@NotBlank
	private String estado;
	private String complemento;

	public EnderecoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnderecoRequest(@NotBlank String cep, @NotBlank String rua, @NotBlank String numero, @NotBlank String bairro,
			@NotBlank String cidade, @NotBlank String estado, String complemento) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public Endereco paraEndereco() {
		return new Endereco(cep, rua, numero, bairro, cidade, estado, complemento);
	}

}
