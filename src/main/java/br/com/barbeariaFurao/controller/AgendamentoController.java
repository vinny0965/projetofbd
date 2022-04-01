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

import br.com.barbeariaFurao.datasource.model.Agendamento;
import br.com.barbeariaFurao.exception.AgendamentoNotFoundException;
import br.com.barbeariaFurao.exception.AgendamentoResourceException;
import br.com.barbeariaFurao.exception.ClienteNotFoundException;
import br.com.barbeariaFurao.exception.ServicoNotFoundException;
import br.com.barbeariaFurao.resource.model.AgendamentoResource;
import br.com.barbeariaFurao.service.BuscarAgendamentoServiceImpl;
import br.com.barbeariaFurao.service.CadastrarAgendamentoServiceImpl;

@RestController
@RequestMapping("/api")
public class AgendamentoController {
	
	@Autowired
	private BuscarAgendamentoServiceImpl buscarAgendamentoServiceImpl;
	
	@Autowired
	private CadastrarAgendamentoServiceImpl cadastrarAgendamentoServiceImpl;
	
	@GetMapping(path = "/agendamentos")
	public List<Agendamento> listarAgendamentos(){
		return buscarAgendamentoServiceImpl.listarAgendamentos();
	}
	
	@GetMapping(path = "/agendamento/id/{id}")
	public Agendamento buscarAgendamentoPorId(@PathVariable(name = "id",required = true)Long id) throws AgendamentoNotFoundException {
		return buscarAgendamentoServiceImpl.buscarAgendamento(id);
	}
	
	@PostMapping(path = "/agendamento/save")
	public void CadastrarAgendamento(@RequestBody AgendamentoResource agendamentoResource) throws AgendamentoResourceException, ClienteNotFoundException, ServicoNotFoundException {
		cadastrarAgendamentoServiceImpl.cadastrarAgendamento(agendamentoResource);
	}
	
	@PutMapping(path = "/agendamento/update/id/{id}")
	public void atualizarAgendamento(@PathVariable(name = "id",required = true)Long id, @RequestBody AgendamentoResource agendamentoResource) throws NumberFormatException, AgendamentoNotFoundException, ClienteNotFoundException, ServicoNotFoundException {
		buscarAgendamentoServiceImpl.atualizarAgendamento(agendamentoResource, id);
	}
	
	@DeleteMapping(path = "/agendamento/delete/id/{id}")
	public void deletarAgendamento(@PathVariable(name = "id",required = true)Long id) throws AgendamentoNotFoundException {
		buscarAgendamentoServiceImpl.deletarAgendamentoPorId(id);
	}
	
	
	

}
