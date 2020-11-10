package org.serratec.projetoFinal.erro;

public class ClienteNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	public ClienteNotFoundException(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
