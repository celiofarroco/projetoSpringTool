package org.serratec.projetoFinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.projetoFinal.entidade.Cliente;
import org.serratec.projetoFinal.erro.ClienteNotFoundException;
import org.serratec.projetoFinal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> retornaCliente(){
		return clienteService.retornaCliente();
	}
	
	@GetMapping("/{id}")
	public Cliente retornaUmCliente(@PathVariable Integer id) throws ClienteNotFoundException {
		return clienteService.retornaUmCliente(id);
	}
	
	@PostMapping
	public Cliente adicionaCliente(@Valid @RequestBody Cliente cliente) throws ClienteNotFoundException {
		return clienteService.adicionaCliente(cliente);
	}
	
	@PutMapping("/{id}")
	public Cliente atualizaCliente(@PathVariable Integer id, @Valid @RequestBody Cliente cliente) throws ClienteNotFoundException {
		return clienteService.atualizaCliente(id, cliente);
	}
	
	@DeleteMapping("/{id}")
	public void deletaCliente(@PathVariable Integer id) throws ClienteNotFoundException {
		clienteService.deletaCliente(id);
	}
}
