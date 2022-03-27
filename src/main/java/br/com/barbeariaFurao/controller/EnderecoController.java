package br.com.barbeariaFurao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbeariaFurao.datasource.model.Endereco;
import br.com.barbeariaFurao.exception.EnderecoNotFoundException;
import br.com.barbeariaFurao.exception.EnderecoResouceException;
import br.com.barbeariaFurao.resource.model.EnderecoResource;
import br.com.barbeariaFurao.service.BuscarEnderecoServiceImpl;
import br.com.barbeariaFurao.service.CadastrarEnderecoServiceImpl;

@RestController
@RequestMapping("/api")
public class EnderecoController {
	
	@Autowired
	private CadastrarEnderecoServiceImpl cadastrarEnderecoServiceImpl;
	
	@Autowired
	private BuscarEnderecoServiceImpl buscarEnderecoServiceImpl;
	
	@PostMapping(path = "/endereco/save")
	public void cadastrarEndereco(@RequestBody EnderecoResource enderecoResource) throws EnderecoResouceException {
		cadastrarEnderecoServiceImpl.cadastrar(enderecoResource);
	}
	
	@GetMapping(path = "/enderecos")
	public List<Endereco> listarEnderecos(){
		return buscarEnderecoServiceImpl.listarEnderecos();
	}
	
	@GetMapping(path = "/endereco/id/{id}")
	public Endereco buscarEndereco(@PathVariable(name = "id",required = true)Long id) throws EnderecoNotFoundException {
		return buscarEnderecoServiceImpl.buscarEnderecoPorId(id);
	}
	
	@PutMapping(path = "/endereco/update/id/{id}")
	public void atualizarEndereco(@PathVariable(name = "id",required = true)Long id, @RequestBody EnderecoResource enderecoResource) {
		buscarEnderecoServiceImpl.AtualizarEndereco(enderecoResource, id);
	}
	
	@DeleteMapping(path = "/endereco/delete/id/{id}")
	public void deletarEndereco(@PathVariable(name = "id", required = true)Long id) throws EnderecoNotFoundException {
		buscarEnderecoServiceImpl.deletarEndereco(id);
	}

}
