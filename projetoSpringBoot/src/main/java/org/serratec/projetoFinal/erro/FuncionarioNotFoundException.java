package org.serratec.projetoFinal.erro;

public class FuncionarioNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	public FuncionarioNotFoundException(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
