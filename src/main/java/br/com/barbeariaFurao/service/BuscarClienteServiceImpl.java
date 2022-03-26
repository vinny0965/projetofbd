package br.com.barbeariaFurao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.datasouce.model.Cliente;
import br.com.barbeariaFurao.repository.ClienteRepository;

@Service
public class BuscarClienteServiceImpl {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}

}
