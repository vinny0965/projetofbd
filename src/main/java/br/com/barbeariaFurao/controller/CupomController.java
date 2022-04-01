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

import br.com.barbeariaFurao.datasource.model.CupomDesconto;
import br.com.barbeariaFurao.exception.AdministradorNotFoundException;
import br.com.barbeariaFurao.exception.CupomDescontoNotFoundException;
import br.com.barbeariaFurao.exception.CupomDescontoResourceException;
import br.com.barbeariaFurao.resource.model.CupomDescontoResource;
import br.com.barbeariaFurao.service.BuscarCupomServiceImpl;
import br.com.barbeariaFurao.service.CadastrarCupomServiceImpl;

@RestController
@RequestMapping("/api")
public class CupomController {
	
	@Autowired
	private BuscarCupomServiceImpl buscarCupomServiceImpl;
	
	@Autowired
	private CadastrarCupomServiceImpl cadastrarCupomServiceImpl;
	
	@GetMapping(path = "/cupons")
	public List<CupomDesconto> listarCupons(){
		return buscarCupomServiceImpl.listarCupons();
	}
	
	@GetMapping(path = "/cupom/id/{id}")
	public CupomDesconto busCupomDesconto(@PathVariable(name = "id",required = true)Long id) throws CupomDescontoNotFoundException {
		return buscarCupomServiceImpl.buscarCupomPorId(id);
	}
	
	@PutMapping(path = "/cupom/update/id/{id}")
	public void atualizarCupom(@PathVariable(name = "id",required = true)Long id, @RequestBody CupomDescontoResource cupomDescontoResource) throws NumberFormatException, CupomDescontoNotFoundException, AdministradorNotFoundException{
		buscarCupomServiceImpl.atualizarCupomPorId(cupomDescontoResource, id);
	}
	
	@DeleteMapping(path = "/cupom/delete/id/{id}")
	public void deletarCupomPorId(@PathVariable(name = "id",required = true)Long id) throws CupomDescontoNotFoundException {
		buscarCupomServiceImpl.deletarCupomPorId(id);
	}
	
	@PostMapping(path = "/cupom/save")
	public void cadastrarCupom(@RequestBody CupomDescontoResource cupomDescontoResource) throws NumberFormatException, CupomDescontoResourceException, AdministradorNotFoundException {
		cadastrarCupomServiceImpl.cadastrarCupom(cupomDescontoResource);
	}
	
	
}
