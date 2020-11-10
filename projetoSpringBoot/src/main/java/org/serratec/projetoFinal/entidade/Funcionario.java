package org.serratec.projetoFinal.entidade;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_funcionario;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "nomeFuncionario", nullable = false, length = 50)
	private String nomeFuncionario;
	
	@NotNull
	@Size(min = 12, max = 12)
	@Column(name = "cpf", nullable = false, length = 12)
	private String cpf;
	
	@ManyToMany
	@JoinTable(name = "funcionario_produto" , 
		joinColumns = @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario"),
		inverseJoinColumns = @JoinColumn(name = "id_produto", referencedColumnName = "id_produto"))
	private Set<Produto> produto;

	public Integer getId_funcionario() {
		return id_funcionario;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
