package org.serratec.projetoFinal.erro;

public class CategoriaNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	public CategoriaNotFoundException(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
