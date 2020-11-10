package org.serratec.projetoFinal.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_categoria;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "nomeCategoria", nullable = false, length = 50)
	private String nomeCategoria;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "descricao", nullable = false, length = 50)
	private String descricao;
	
	@ManyToOne()
	@JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
	private Funcionario funcionario;

	public Integer getId_categoria() {
		return id_categoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
