package org.serratec.projetoFinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.projetoFinal.entidade.Endereco;
import org.serratec.projetoFinal.erro.EnderecoNotFoundException;
import org.serratec.projetoFinal.service.EnderecoService;
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
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public List<Endereco> retornaEndereco(){
		return enderecoService.retornaEndereco();
	}
	
	@GetMapping("/{id}")
	public Endereco retornaUmEndereco(@PathVariable Integer id) throws EnderecoNotFoundException {
		return enderecoService.retornaUmEndereco(id);
	}
	
	@PostMapping
	public Endereco adicionaEndereco(@Valid @RequestBody Endereco endereco) throws EnderecoNotFoundException {
		return enderecoService.adicionaEndereco(endereco);
	}
	
	@PutMapping("/{id}")
	public Endereco atualizaEndereco(@PathVariable Integer id, @Valid @RequestBody Endereco endereco) throws EnderecoNotFoundException {
		return enderecoService.atualizaEndereco(id, endereco);
	}
	
	@DeleteMapping("/{id}")
	public void deletaEndereco(@PathVariable Integer id) throws EnderecoNotFoundException {
		enderecoService.deletaEndereco(id);
	}
}
