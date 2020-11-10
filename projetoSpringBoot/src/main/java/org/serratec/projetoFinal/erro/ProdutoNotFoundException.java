package org.serratec.projetoFinal.erro;

public class ProdutoNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	public ProdutoNotFoundException(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
