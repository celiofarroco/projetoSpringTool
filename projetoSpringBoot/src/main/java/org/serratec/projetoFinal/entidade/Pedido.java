package org.serratec.projetoFinal.entidade;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pedido;
	
	@NotNull
	@Past
	@JsonFormat(pattern="dd-MM-yyyy", timezone= "America/Sao_Paulo")
	@Temporal(TemporalType.DATE)
	@Column(name = "dataPedido", nullable = false)
	private Date dataPedido;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name = "id_pedido")
	private Set<PedidoProduto> pedidoProduto;

	public Integer getId_pedido() {
		return id_pedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<PedidoProduto> getPedidoProduto() {
		return pedidoProduto;
	}

	public void setPedidoProduto(Set<PedidoProduto> pedidoProduto) {
		this.pedidoProduto = pedidoProduto;
	}
}
