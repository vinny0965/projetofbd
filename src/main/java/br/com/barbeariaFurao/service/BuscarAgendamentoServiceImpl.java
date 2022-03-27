package br.com.barbeariaFurao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.datasource.model.Agendamento;
import br.com.barbeariaFurao.repository.AgendamentoRepository;

@Service
public class BuscarAgendamentoServiceImpl {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public List<Agendamento> listarAgendamentos(){
		return agendamentoRepository.findAll();
	}

}
