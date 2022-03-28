package br.com.barbeariaFurao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbeariaFurao.datasource.model.Cliente;
import br.com.barbeariaFurao.exception.ClienteNotFoundException;
import br.com.barbeariaFurao.service.BuscarClienteServiceImpl;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private BuscarClienteServiceImpl buscarClienteServiceImpl;
	
	@GetMapping(path = "/clientes")
	public List<Cliente> listarClientes(){
		return buscarClienteServiceImpl.listarClientes();
	}
	
	@GetMapping(path = "/cliente/id/{id}")
	public Cliente buscarClientePorId(@PathVariable(name = "id",required = true)Long id) throws ClienteNotFoundException {
		return buscarClienteServiceImpl.buscarClientePorId(id);
	}
	
	@DeleteMapping(path = "/cliente/delete/id/{id}")
	public void deletarClientePorId(@PathVariable(name = "id",required = true)Long id) throws ClienteNotFoundException {
		buscarClienteServiceImpl.deletarCliente(id);
	}

}
