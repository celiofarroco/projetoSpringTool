package org.serratec.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.projetoFinal.entidade.Cliente;
import org.serratec.projetoFinal.erro.ClienteNotFoundException;
import org.serratec.projetoFinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findCliente(Integer id) throws ClienteNotFoundException {
		Optional<Cliente> achado = clienteRepository.findById(id);
		if (achado.isPresent()) {
			return achado.get();
		} else {
			throw new ClienteNotFoundException(id);
		}
	}
	
	public List<Cliente> retornaCliente() {
		return clienteRepository.findAll();
	}
	
	public Cliente retornaUmCliente(Integer id) throws ClienteNotFoundException {
		return findCliente(id);
	}
	
	@Transactional
	public Cliente adicionaCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public Cliente atualizaCliente(Integer id, Cliente cliente) throws ClienteNotFoundException {
		Cliente clienteMudado = findCliente(id);
		clienteMudado.setNomeUsuario(cliente.getNomeUsuario());
		clienteMudado.setNomeCompleto(cliente.getNomeCompleto());
		clienteMudado.setDataNascimento(cliente.getDataNascimento());
		clienteMudado.setEmail(cliente.getEmail());
		clienteMudado.setCpf(cliente.getCpf());
		clienteMudado.setTelefone(cliente.getTelefone());
		clienteMudado.setEndereco(cliente.getEndereco());
		return clienteRepository.save(clienteMudado);
	}

	@Transactional
	public void deletaCliente(Integer id) throws ClienteNotFoundException {
		Cliente cliente = findCliente(id);
		clienteRepository.delete(cliente);
	}
}
