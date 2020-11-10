package org.serratec.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.projetoFinal.entidade.PedidoProduto;
import org.serratec.projetoFinal.erro.PedidoProdutoNotFoundException;
import org.serratec.projetoFinal.repository.PedidoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoProdutoService {

	@Autowired
	private PedidoProdutoRepository pedidoProdutoRepository;
	
	public PedidoProduto findPedidoProduto(Integer id) throws PedidoProdutoNotFoundException {
		Optional<PedidoProduto> achado = pedidoProdutoRepository.findById(id);
		if (achado.isPresent()) {
			return achado.get();
		} else {
			throw new PedidoProdutoNotFoundException(id);
		}
	}
	
	public List<PedidoProduto> retornaPedidoProduto() {
		return pedidoProdutoRepository.findAll();
	}
	
	public PedidoProduto retornaUmPedidoProduto(Integer id) throws PedidoProdutoNotFoundException {
		return findPedidoProduto(id);
	}
	
	@Transactional
	public PedidoProduto adicionaPedidoProduto(PedidoProduto pedidoProduto) {
		return pedidoProdutoRepository.save(pedidoProduto);
	}
	
	@Transactional
	public PedidoProduto atualizaPedidoProduto(Integer id, PedidoProduto pedidoProduto) throws PedidoProdutoNotFoundException {
		PedidoProduto pedidoProdutoMudado = findPedidoProduto(id);
		pedidoProdutoMudado.setQuantidade(pedidoProduto.getQuantidade());
		pedidoProdutoMudado.setProduto(pedidoProduto.getProduto());
		return pedidoProdutoRepository.save(pedidoProdutoMudado);
	}

	@Transactional
	public void deletaPedidoProduto(Integer id) throws PedidoProdutoNotFoundException {
		PedidoProduto pedidoProduto = findPedidoProduto(id);
		pedidoProdutoRepository.delete(pedidoProduto);
	}
}
