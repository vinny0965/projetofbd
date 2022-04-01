package br.com.barbeariaFurao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbeariaFurao.datasource.model.Cliente;
import br.com.barbeariaFurao.exception.ClienteNotFoundException;
import br.com.barbeariaFurao.exception.ClienteResouceException;
import br.com.barbeariaFurao.exception.EnderecoNotFoundException;
import br.com.barbeariaFurao.resource.model.ClienteResource;
import br.com.barbeariaFurao.service.BuscarClienteServiceImpl;
import br.com.barbeariaFurao.service.CadastrarClienteServiceImpl;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private BuscarClienteServiceImpl buscarClienteServiceImpl;
	
	@Autowired
	private CadastrarClienteServiceImpl cadastrarClienteServiceImpl;
	
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
	
	@PutMapping(path = "/cliente/update/id/{id}")
	public void atualizarClientePorId(@PathVariable(name = "id",required = true)Long id, @RequestBody ClienteResource clienteResource) throws NumberFormatException, EnderecoNotFoundException {
		buscarClienteServiceImpl.atualizarCliente(clienteResource, id);
	}
	
	@PostMapping(path = "/cliente/save")
	public void cadastrarCliente(@RequestBody ClienteResource clienteResource) throws NumberFormatException, ClienteResouceException, EnderecoNotFoundException {
		cadastrarClienteServiceImpl.cadastrar(clienteResource);
	}

}
