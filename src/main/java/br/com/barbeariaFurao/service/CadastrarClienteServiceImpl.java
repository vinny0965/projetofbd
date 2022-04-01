package br.com.barbeariaFurao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.conversor.ClienteConversor;
import br.com.barbeariaFurao.datasource.model.Cliente;
import br.com.barbeariaFurao.exception.ClienteResouceException;
import br.com.barbeariaFurao.exception.EnderecoNotFoundException;
import br.com.barbeariaFurao.repository.ClienteRepository;
import br.com.barbeariaFurao.resource.model.ClienteResource;

@Service
public class CadastrarClienteServiceImpl {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteConversor clienteConversor;
	
	public ResponseEntity<Cliente> cadastrar(ClienteResource clienteResource) throws NumberFormatException, ClienteResouceException, EnderecoNotFoundException {
		Cliente converter = clienteConversor.converter(clienteResource);
		clienteRepository.saveAndFlush(converter);
		return ResponseEntity.ok(converter);
	}

}
