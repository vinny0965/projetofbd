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

import br.com.barbeariaFurao.datasource.model.Caixa;
import br.com.barbeariaFurao.exception.CaixaNotFoundException;
import br.com.barbeariaFurao.exception.CaixaResourceException;
import br.com.barbeariaFurao.exception.EnderecoNotFoundException;
import br.com.barbeariaFurao.resource.model.CaixaResource;
import br.com.barbeariaFurao.service.BuscarCaixaServiceImpl;
import br.com.barbeariaFurao.service.CadastrarCaixaServiceImpl;

@RestController
@RequestMapping("/api")
public class CaixaController {
	
	@Autowired
	private BuscarCaixaServiceImpl buscarCaixaServiceImpl;
	
	@Autowired
	private CadastrarCaixaServiceImpl cadastrarCaixaServiceImpl;
	
	@GetMapping(path = "/caixas")
	public List<Caixa> listarCaixas(){
		return buscarCaixaServiceImpl.listarCaixas();
	}
	
	@GetMapping(path = "/caixa/id/{id}")
	public Caixa busCaixa(@PathVariable(name = "id",required = true)Long id) throws CaixaNotFoundException {
		return buscarCaixaServiceImpl.buscarCaixaPorId(id);
	}

	@PutMapping(path = "/caixa/update/id/{id}")
	public void atualizarCaixa(@PathVariable(name = "id",required = true)Long id, @RequestBody CaixaResource caixaResource) throws NumberFormatException, CaixaNotFoundException, EnderecoNotFoundException {
		buscarCaixaServiceImpl.atualizarCaixa(caixaResource, id);
	}
	
	@DeleteMapping(path = "/caixa/delete/id/{id}")
	public void deletarCaixaPorId(@PathVariable(name = "id",required = true)Long id) throws CaixaNotFoundException {
		buscarCaixaServiceImpl.deletarCaixa(id);
	}
	
	@PostMapping(path = "/caixa/save")
	public void cadastrarCaixa(@RequestBody CaixaResource caixaResource) throws NumberFormatException, EnderecoNotFoundException, CaixaResourceException {
		cadastrarCaixaServiceImpl.CadastrarCaixa(caixaResource);
		
	}
	
	
	
}
