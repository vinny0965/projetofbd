package br.com.barbeariaFurao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.datasource.model.Cliente;
import br.com.barbeariaFurao.exception.ClienteNotFoundException;
import br.com.barbeariaFurao.repository.ClienteRepository;

@Service
public class BuscarClienteServiceImpl {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}

	public Cliente buscarClientePorId(Long id) throws ClienteNotFoundException {
		 Optional<Cliente> findById = clienteRepository.findById(id);
		 Cliente cliente = null;
		 if(!findById.isPresent()) {
			 throw new ClienteNotFoundException("Cliente não encontrado pelo id: "+id);
		 }else {
			 cliente = findById.get();
		 }
		 return cliente;
	}
	
	public void deletarCliente(Long id) throws ClienteNotFoundException {
		Optional<Cliente> findById = clienteRepository.findById(id);
		if(findById.isPresent()) {
			clienteRepository.delete(findById.get());
		}else {
			throw new ClienteNotFoundException("Cliente não encontrado pelo id: "+id);
		}
	}
	
}
