package org.serratec.projetoFinal.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cliente;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "nomeUsuario", nullable = false, length = 50)
	private String nomeUsuario;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "nomeCompleto", nullable = false, length = 50)
	private String nomeCompleto;
	
	@NotNull
	@Past
	@JsonFormat(pattern="dd-MM-yyyy", timezone= "America/Sao_Paulo")
	@Temporal(TemporalType.DATE)
	@Column(name = "dataNascimento", nullable = false)
	private Date dataNascimento;
	
	@NotNull
	@Size(min = 7, max = 30)
	@Column(name = "email", nullable = false, length = 30)
	private String email;
	
	@NotNull
	@Size(min = 12, max = 12)
	@Column(name = "cpf", nullable = false, length = 12)
	private String cpf;
	
	@NotNull
	@Size(min = 10, max = 11)
	@Column(name = "telefone", nullable = false, length = 11)
	private String telefone;
	
	@ManyToOne()
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
	private Endereco endereco;

	public Integer getId_cliente() {
		return id_cliente;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
