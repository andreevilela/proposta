package br.com.zup.propostas;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

import br.com.zup.propostas.enums.Status;
import br.com.zup.validacao.Documento;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	@Embedded
	private Endereco endereco;

	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idCartao")
	Cartao cartao;

	public Proposta() {
	}

	public Proposta(@Email @NotBlank String email, @NotBlank String nome, @Positive BigDecimal salario,
			@NotBlank String documento, @Valid Endereco endereco) {
		super();
		this.email = email;
		this.nome = nome;
		this.salario = salario;
		this.documento = documento;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public Status getStatus() {
		return status;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setStatus(Status status) {
		this.status = status;

	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	@Override
	public String toString() {
		return "Proposta [id=" + id + ", email=" + email + ", nome=" + nome + ", salario=" + salario + ", documento="
				+ documento + ", endereco=" + endereco + ", status=" + status + ", cartao=" + cartao + "]";
	}

}
