package org.serratec.projetoFinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.projetoFinal.entidade.Funcionario;
import org.serratec.projetoFinal.erro.FuncionarioNotFoundException;
import org.serratec.projetoFinal.service.FuncionarioService;
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
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	public List<Funcionario> retornaFuncionario(){
		return funcionarioService.retornaFuncionario();
	}
	
	@GetMapping("/{id}")
	public Funcionario retornaUmFuncionario(@PathVariable Integer id) throws FuncionarioNotFoundException {
		return funcionarioService.retornaUmFuncionario(id);
	}
	
	@PostMapping
	public Funcionario adicionaFuncionario(@Valid @RequestBody Funcionario funcionario) throws FuncionarioNotFoundException {
		return funcionarioService.adicionaFuncionario(funcionario);
	}
	
	@PutMapping("/{id}")
	public Funcionario atualizaFuncionario(@PathVariable Integer id, @Valid @RequestBody Funcionario funcionario) throws FuncionarioNotFoundException {
		return funcionarioService.atualizaFuncionario(id, funcionario);
	}
	
	@DeleteMapping("/{id}")
	public void deletaFuncionario(@PathVariable Integer id) throws FuncionarioNotFoundException {
		funcionarioService.deletaFuncionario(id);
	}
}
