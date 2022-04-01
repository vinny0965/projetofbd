package br.com.barbeariaFurao.service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.datasource.model.Agendamento;
import br.com.barbeariaFurao.datasource.model.Cliente;
import br.com.barbeariaFurao.datasource.model.Servico;
import br.com.barbeariaFurao.exception.AgendamentoNotFoundException;
import br.com.barbeariaFurao.exception.ClienteNotFoundException;
import br.com.barbeariaFurao.exception.ServicoNotFoundException;
import br.com.barbeariaFurao.repository.AgendamentoRepository;
import br.com.barbeariaFurao.resource.model.AgendamentoResource;

@Service
public class BuscarAgendamentoServiceImpl {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private BuscarClienteServiceImpl buscarClienteServiceImpl;
	
	@Autowired
	private BuscarServicoServiceImpl buscarServicoServiceImpl;
	
	public List<Agendamento> listarAgendamentos(){
		return agendamentoRepository.findAll();
	}
	
	public Agendamento buscarAgendamento(Long id) throws AgendamentoNotFoundException {
		Optional<Agendamento> findById = agendamentoRepository.findById(id);
		Agendamento agendamento = null;
		if(!findById.isPresent()) {
			throw new AgendamentoNotFoundException("agendamento não encontrado pelo id: "+id);
		}else {
			agendamento = findById.get();
		}
		return agendamento;
	}
	
	public void atualizarAgendamento(AgendamentoResource agendamentoResource, Long id) throws AgendamentoNotFoundException, NumberFormatException, ClienteNotFoundException, ServicoNotFoundException {
		Cliente buscarClientePorId = buscarClienteServiceImpl.buscarClientePorId(Long.parseLong(agendamentoResource.getIdCliente()));
		Servico buscarServicoPorId = buscarServicoServiceImpl.buscarServicoPorId(Long.parseLong(agendamentoResource.getIdServico()));
		Agendamento buscarAgendamento = buscarAgendamento(id);
		if(buscarAgendamento !=null) {
			Agendamento agendamento = buscarAgendamento;
			agendamento.setDataAgendamento(LocalDate.parse(agendamentoResource.getDataAgendamento()));
			agendamento.setHorario(Time.valueOf(agendamentoResource.getHorario()));
			agendamento.setFuncionario(agendamentoResource.getFuncionario());
			agendamento.setCliente(buscarClientePorId);
			agendamento.setServico(buscarServicoPorId);
			agendamentoRepository.save(agendamento);
		}
	}
	
	public void deletarAgendamentoPorId(Long id) throws AgendamentoNotFoundException {
		Agendamento buscarAgendamento = buscarAgendamento(id);
		agendamentoRepository.delete(buscarAgendamento);
	}

}
