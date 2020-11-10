package org.serratec.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.projetoFinal.entidade.Funcionario;
import org.serratec.projetoFinal.erro.FuncionarioNotFoundException;
import org.serratec.projetoFinal.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario findFuncionario(Integer id) throws FuncionarioNotFoundException {
		Optional<Funcionario> achado = funcionarioRepository.findById(id);
		if (achado.isPresent()) {
			return achado.get();
		} else {
			throw new FuncionarioNotFoundException(id);
		}
	}
	
	public List<Funcionario> retornaFuncionario() {
		return funcionarioRepository.findAll();
	}
	
	public Funcionario retornaUmFuncionario(Integer id) throws FuncionarioNotFoundException {
		return findFuncionario(id);
	}
	
	@Transactional
	public Funcionario adicionaFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	@Transactional
	public Funcionario atualizaFuncionario(Integer id, Funcionario funcionario) throws FuncionarioNotFoundException {
		Funcionario funcionarioMudado = findFuncionario(id);
		funcionarioMudado.setNomeFuncionario(funcionario.getNomeFuncionario());
		funcionarioMudado.setCpf(funcionario.getCpf());
		return funcionarioRepository.save(funcionarioMudado);
	}

	@Transactional
	public void deletaFuncionario(Integer id) throws FuncionarioNotFoundException {
		Funcionario funcionario = findFuncionario(id);
		funcionarioRepository.delete(funcionario);
	}
}
