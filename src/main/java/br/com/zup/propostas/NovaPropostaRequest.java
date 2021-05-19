package br.com.zup.propostas;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

public class NovaPropostaRequest {

	@Email
	@NotBlank
	private String email;

	@NotBlank
	private String nome;

	@NotNull
	@Positive
	private BigDecimal salario;

	@NotBlank
	@Documento
	private String documento;

	@NotNull
	@Valid
	private EnderecoRequest endereco;

	public NovaPropostaRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NovaPropostaRequest(@Email @NotBlank String email, @NotBlank String nome, @Positive BigDecimal salario,
			@NotBlank String documento, EnderecoRequest endereco) {
		super();
		this.email = email;
		this.nome = nome;
		this.salario = salario;
		this.documento = documento;
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public String getDocumento() {
		return documento;
	}

	public EnderecoRequest getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return "NovaPropostaRequest [email=" + email + ", nome=" + nome + ", salario=" + salario + ", documento="
				+ documento + ", endereco=" + endereco + "]";
	}

	public Proposta paraProposta() {
		Endereco novoEndereco = endereco.paraEndereco();
		return new Proposta(email, nome, salario, documento, novoEndereco);
	}

}
