package org.serratec.projetoFinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.projetoFinal.entidade.PedidoProduto;
import org.serratec.projetoFinal.erro.PedidoProdutoNotFoundException;
import org.serratec.projetoFinal.service.PedidoProdutoService;
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
@RequestMapping("/pedidoproduto")
public class PedidoProdutoController {

	@Autowired
	private PedidoProdutoService pedidoProdutoService;
	
	@GetMapping
	public List<PedidoProduto> retornaPedidoProduto(){
		return pedidoProdutoService.retornaPedidoProduto();
	}
	
	@GetMapping("/{id}")
	public PedidoProduto retornaUmPedidoProduto(@PathVariable Integer id) throws PedidoProdutoNotFoundException {
		return pedidoProdutoService.retornaUmPedidoProduto(id);
	}
	
	@PostMapping
	public PedidoProduto adicionaPedidoProduto(@Valid @RequestBody PedidoProduto pedidoProduto) throws PedidoProdutoNotFoundException {
		return pedidoProdutoService.adicionaPedidoProduto(pedidoProduto);
	}
	
	@PutMapping("/{id}")
	public PedidoProduto atualizaPedidoProduto(@PathVariable Integer id, @Valid @RequestBody PedidoProduto pedidoProduto) throws PedidoProdutoNotFoundException {
		return pedidoProdutoService.atualizaPedidoProduto(id, pedidoProduto);
	}
	
	@DeleteMapping("/{id}")
	public void deletaPedidoProduto(@PathVariable Integer id) throws PedidoProdutoNotFoundException {
		pedidoProdutoService.deletaPedidoProduto(id);
	}
}
