package org.serratec.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.projetoFinal.entidade.Endereco;
import org.serratec.projetoFinal.erro.EnderecoNotFoundException;
import org.serratec.projetoFinal.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco findEndereco(Integer id) throws EnderecoNotFoundException {
		Optional<Endereco> achado = enderecoRepository.findById(id);
		if (achado.isPresent()) {
			return achado.get();
		} else {
			throw new EnderecoNotFoundException(id);
		}
	}
	
	public List<Endereco> retornaEndereco() {
		return enderecoRepository.findAll();
	}
	
	public Endereco retornaUmEndereco(Integer id) throws EnderecoNotFoundException {
		return findEndereco(id);
	}
	
	@Transactional
	public Endereco adicionaEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	@Transactional
	public Endereco atualizaEndereco(Integer id, Endereco endereco) throws EnderecoNotFoundException {
		Endereco enderecoMudado = findEndereco(id);
		enderecoMudado.setCidade(endereco.getCidade());
		enderecoMudado.setRua(endereco.getRua());
		enderecoMudado.setNumero(endereco.getNumero());
		enderecoMudado.setComplemento(endereco.getComplemento());
		return enderecoRepository.save(enderecoMudado);
	}

	@Transactional
	public void deletaEndereco(Integer id) throws EnderecoNotFoundException {
		Endereco endereco = findEndereco(id);
		enderecoRepository.delete(endereco);
	}
}
