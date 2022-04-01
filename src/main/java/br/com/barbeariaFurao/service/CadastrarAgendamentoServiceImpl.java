package br.com.barbeariaFurao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.conversor.AgendamentoConversor;
import br.com.barbeariaFurao.datasource.model.Agendamento;
import br.com.barbeariaFurao.exception.AgendamentoResourceException;
import br.com.barbeariaFurao.exception.ClienteNotFoundException;
import br.com.barbeariaFurao.exception.ServicoNotFoundException;
import br.com.barbeariaFurao.repository.AgendamentoRepository;
import br.com.barbeariaFurao.resource.model.AgendamentoResource;

@Service
public class CadastrarAgendamentoServiceImpl {

	@Autowired
	private AgendamentoConversor agendamentoConversor;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public ResponseEntity<Agendamento> cadastrarAgendamento(AgendamentoResource agendamentoResource) throws AgendamentoResourceException, ClienteNotFoundException, ServicoNotFoundException {
		Agendamento conversor = agendamentoConversor.conversor(agendamentoResource);
		agendamentoRepository.saveAndFlush(conversor);
		return ResponseEntity.ok(conversor);
	}

}
