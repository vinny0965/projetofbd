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

import br.com.barbeariaFurao.datasource.model.Servico;
import br.com.barbeariaFurao.exception.AdministradorNotFoundException;
import br.com.barbeariaFurao.exception.ServicoNotFoundException;
import br.com.barbeariaFurao.exception.ServicoResourceException;
import br.com.barbeariaFurao.resource.model.ServicoResource;
import br.com.barbeariaFurao.service.BuscarServicoServiceImpl;
import br.com.barbeariaFurao.service.CadastrarServicoServiceImpl;

@RestController
@RequestMapping("/api")
public class ServicoController {
	
	@Autowired
	private BuscarServicoServiceImpl buscarServicoServiceImpl;
	
	@Autowired
	private CadastrarServicoServiceImpl cadastrarServicoServiceImpl;
	
	@GetMapping(path = "/servicos")
	public List<Servico> listarServicos(){
		return buscarServicoServiceImpl.listarServicos();
	}
	
	@GetMapping(path = "/servico/id/{id}")
	public Servico busServico(@PathVariable(name = "id",required = true)Long id) throws ServicoNotFoundException {
		return buscarServicoServiceImpl.buscarServicoPorId(id);
	}
	
	@DeleteMapping(path = "/servico/delete/id/{id}")
	public void deletarServico(@PathVariable(name = "id",required = true)Long id) throws ServicoNotFoundException {
		buscarServicoServiceImpl.deletarServico(id);
	}
	
	@PutMapping(path = "/servico/update/id/{id}")
	public void atualizarServico(@PathVariable(name = "id",required = true)Long id, @RequestBody ServicoResource servicoResource) throws NumberFormatException, AdministradorNotFoundException, ServicoNotFoundException {
		buscarServicoServiceImpl.atualizarServico(servicoResource, id);
	}
	
	@PostMapping(path = "/servico/save")
	public void cadastrarServico(@RequestBody ServicoResource servicoResource) throws NumberFormatException, ServicoResourceException, AdministradorNotFoundException {
		cadastrarServicoServiceImpl.cadastrarServico(servicoResource);
	}

}
