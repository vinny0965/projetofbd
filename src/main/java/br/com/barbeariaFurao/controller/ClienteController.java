package br.com.barbeariaFurao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbeariaFurao.datasouce.model.Cliente;
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

}
