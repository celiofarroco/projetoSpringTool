package org.serratec.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.projetoFinal.entidade.Categoria;
import org.serratec.projetoFinal.erro.CategoriaNotFoundException;
import org.serratec.projetoFinal.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findCategoria(Integer id) throws CategoriaNotFoundException {
		Optional<Categoria> achado = categoriaRepository.findById(id);
		if (achado.isPresent()) {
			return achado.get();
		} else {
			throw new CategoriaNotFoundException(id);
		}
	}
	
	public List<Categoria> retornaCategoria() {
		return categoriaRepository.findAll();
	}
	
	public Categoria retornaUmaCategoria(Integer id) throws CategoriaNotFoundException {
		return findCategoria(id);
	}
	
	@Transactional
	public Categoria adicionaCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	@Transactional
	public Categoria atualizaCategoria(Integer id, Categoria categoria) throws CategoriaNotFoundException {
		Categoria categoriaMudado = findCategoria(id);
		categoriaMudado.setNomeCategoria(categoria.getNomeCategoria());
		categoriaMudado.setDescricao(categoria.getDescricao());
		categoriaMudado.setFuncionario(categoria.getFuncionario());
		return categoriaRepository.save(categoriaMudado);
	}

	@Transactional
	public void deletaCategoria(Integer id) throws CategoriaNotFoundException {
		Categoria categoria = findCategoria(id);
		categoriaRepository.delete(categoria);
	}
}
