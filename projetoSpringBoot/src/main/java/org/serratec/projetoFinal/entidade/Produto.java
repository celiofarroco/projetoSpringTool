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
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_produto;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "nomeProduto", nullable = false, length = 50)
	private String nomeProduto;
	
	@NotNull
	@Size(min = 1, max = 7)
	@Column(name = "preco", nullable = false, length = 7)
	private double preco;
	
	@NotNull
	@Past
	@JsonFormat(pattern="dd-MM-yyyy", timezone= "America/Sao_Paulo")
	@Temporal(TemporalType.DATE)
	@Column(name = "dataFabricacao", nullable = false)
	private Date dataFabricacao;
	
	@Size(min = 1, max = 5)
	@Column(name = "estoque", nullable = true, length = 5)
	private int estoque;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "descricao", nullable = false, length = 50)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	private Categoria categoria;
	
	public Integer getId_produto() {
		return id_produto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
