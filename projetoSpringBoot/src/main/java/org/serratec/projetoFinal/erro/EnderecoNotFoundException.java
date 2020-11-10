package org.serratec.projetoFinal.erro;

public class EnderecoNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	public EnderecoNotFoundException(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
