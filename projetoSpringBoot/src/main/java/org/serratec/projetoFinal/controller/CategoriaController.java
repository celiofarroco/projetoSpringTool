package org.serratec.projetoFinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.projetoFinal.entidade.Categoria;
import org.serratec.projetoFinal.erro.CategoriaNotFoundException;
import org.serratec.projetoFinal.service.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> retornaCategoria(){
		return categoriaService.retornaCategoria();
	}
	
	@GetMapping("/{id}")
	public Categoria retornaUmaCategoria(@PathVariable Integer id) throws CategoriaNotFoundException {
		return categoriaService.retornaUmaCategoria(id);
	}
	
	@PostMapping
	public Categoria adicionaCategoria(@Valid @RequestBody Categoria categoria) throws CategoriaNotFoundException {
		return categoriaService.adicionaCategoria(categoria);
	}
	
	@PutMapping("/{id}")
	public Categoria atualizaCategoria(@PathVariable Integer id, @Valid @RequestBody Categoria categoria) throws CategoriaNotFoundException {
		return categoriaService.atualizaCategoria(id, categoria);
	}
	
	@DeleteMapping("/{id}")
	public void deletaCategoria(@PathVariable Integer id) throws CategoriaNotFoundException {
		categoriaService.deletaCategoria(id);
	}
}
