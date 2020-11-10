package org.serratec.projetoFinal.erro;

public class PedidoNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	public PedidoNotFoundException(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
