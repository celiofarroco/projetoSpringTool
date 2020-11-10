package org.serratec.projetoFinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.projetoFinal.entidade.Produto;
import org.serratec.projetoFinal.erro.ProdutoNotFoundException;
import org.serratec.projetoFinal.service.ProdutoService;
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
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> retornaProduto(){
		return produtoService.retornaProduto();
	}
	
	@GetMapping("/{id}")
	public Produto retornaUmProduto(@PathVariable Integer id) throws ProdutoNotFoundException {
		return produtoService.retornaUmProduto(id);
	}
	
	@PostMapping
	public Produto adicionaProduto(@Valid @RequestBody Produto produto) throws ProdutoNotFoundException {
		return produtoService.adicionaProduto(produto);
	}
	
	@PutMapping("/{id}")
	public Produto atualizaProduto(@PathVariable Integer id, @Valid @RequestBody Produto produto) throws ProdutoNotFoundException {
		return produtoService.atualizaProduto(id,produto);
	}
	
	@DeleteMapping("/{id}")
	public void produtoCategoria(@PathVariable Integer id) throws ProdutoNotFoundException {
		produtoService.deletaProduto(id);
	}
}
