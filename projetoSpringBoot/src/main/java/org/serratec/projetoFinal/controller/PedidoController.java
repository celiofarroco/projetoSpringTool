package org.serratec.projetoFinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.projetoFinal.entidade.Pedido;
import org.serratec.projetoFinal.erro.PedidoNotFoundException;
import org.serratec.projetoFinal.service.PedidoService;
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
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public List<Pedido> retornaPedido(){
		return pedidoService.retornaPedido();
	}
	
	@GetMapping("/{id}")
	public Pedido retornaUmPedido(@PathVariable Integer id) throws PedidoNotFoundException {
		return pedidoService.retornaUmPedido(id);
	}
	
	@PostMapping
	public Pedido adicionaPedido(@Valid @RequestBody Pedido pedido) throws PedidoNotFoundException {
		return pedidoService.adicionaPedido(pedido);
	}
	
	@PutMapping("/{id}")
	public Pedido atualizaPedido(@PathVariable Integer id, @Valid @RequestBody Pedido pedido) throws PedidoNotFoundException {
		return pedidoService.atualizaPedido(id, pedido);
	}
	
	@DeleteMapping("/{id}")
	public void deletaPedido(@PathVariable Integer id) throws PedidoNotFoundException {
		pedidoService.deletaPedido(id);
	}
}
