package org.serratec.projetoFinal.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_endereco;
	
	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "cidade", nullable = false, length = 50)
	private String cidade;
	
	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "rua", nullable = false, length = 50)
	private String rua;
	
	@NotNull
	@Size(min = 1, max = 5)
	@Column(name = "numero", nullable = false, length = 5)
	private int numero;
	
	@Size(min = 1, max = 50)
	@Column(name = "complemento", nullable = true, length = 50)
	private String complemento;

	public Integer getId_endereco() {
		return id_endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
