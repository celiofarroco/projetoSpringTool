package org.serratec.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.projetoFinal.entidade.Produto;
import org.serratec.projetoFinal.erro.ProdutoNotFoundException;
import org.serratec.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto findProduto(Integer id) throws ProdutoNotFoundException {
		Optional<Produto> achado = produtoRepository.findById(id);
		if (achado.isPresent()) {
			return achado.get();
		} else {
			throw new ProdutoNotFoundException(id);
		}
	}
	
	public List<Produto> retornaProduto() {
		return produtoRepository.findAll();
	}
	
	public Produto retornaUmProduto(Integer id) throws ProdutoNotFoundException {
		return findProduto(id);
	}
	
	@Transactional
	public Produto adicionaProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@Transactional
	public Produto atualizaProduto(Integer id, Produto produto) throws ProdutoNotFoundException {
		Produto produtoMudado = findProduto(id);
		produtoMudado.setNomeProduto(produto.getNomeProduto());
		produtoMudado.setPreco(produto.getPreco());
		produtoMudado.setDataFabricacao(produto.getDataFabricacao());
		produtoMudado.setEstoque(produto.getEstoque());
		produtoMudado.setDescricao(produto.getDescricao());
		produtoMudado.setCategoria(produto.getCategoria());
		return produtoRepository.save(produtoMudado);
	}

	@Transactional
	public void deletaProduto(Integer id) throws ProdutoNotFoundException {
		Produto produto = findProduto(id);
		produtoRepository.delete(produto);
	}
}
