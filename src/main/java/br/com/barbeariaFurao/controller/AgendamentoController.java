package br.com.barbeariaFurao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbeariaFurao.datasouce.model.Agendamento;
import br.com.barbeariaFurao.service.BuscarAgendamentoServiceImpl;

@RestController
@RequestMapping("/api")
public class AgendamentoController {
	
	@Autowired
	private BuscarAgendamentoServiceImpl buscarAgendamentoServiceImpl;
	
	@GetMapping(path = "/agendamentos")
	public List<Agendamento> listarAgendamentos(){
		return buscarAgendamentoServiceImpl.listarAgendamentos();
	}

}
