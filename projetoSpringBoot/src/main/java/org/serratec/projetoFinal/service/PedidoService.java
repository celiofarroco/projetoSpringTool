package org.serratec.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.projetoFinal.entidade.Pedido;
import org.serratec.projetoFinal.erro.PedidoNotFoundException;
import org.serratec.projetoFinal.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido findPedido(Integer id) throws PedidoNotFoundException {
		Optional<Pedido> achado = pedidoRepository.findById(id);
		if (achado.isPresent()) {
			return achado.get();
		} else {
			throw new PedidoNotFoundException(id);
		}
	}
	
	public List<Pedido> retornaPedido() {
		return pedidoRepository.findAll();
	}
	
	public Pedido retornaUmPedido(Integer id) throws PedidoNotFoundException {
		return findPedido(id);
	}
	
	@Transactional
	public Pedido adicionaPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	@Transactional
	public Pedido atualizaPedido(Integer id, Pedido pedido) throws PedidoNotFoundException {
		Pedido pedidoMudado = findPedido(id);
		pedidoMudado.setDataPedido(pedido.getDataPedido());
		pedidoMudado.setCliente(pedido.getCliente());
		pedidoMudado.setPedidoProduto(pedido.getPedidoProduto());
		return pedidoRepository.save(pedidoMudado);
	}

	@Transactional
	public void deletaPedido(Integer id) throws PedidoNotFoundException {
		Pedido pedido = findPedido(id);
		pedidoRepository.delete(pedido);
	}
}
