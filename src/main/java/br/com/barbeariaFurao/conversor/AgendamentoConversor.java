package br.com.barbeariaFurao.conversor;

import java.sql.Time;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.barbeariaFurao.datasource.model.Agendamento;
import br.com.barbeariaFurao.datasource.model.Cliente;
import br.com.barbeariaFurao.datasource.model.Servico;
import br.com.barbeariaFurao.exception.AgendamentoResourceException;
import br.com.barbeariaFurao.exception.ClienteNotFoundException;
import br.com.barbeariaFurao.exception.ServicoNotFoundException;
import br.com.barbeariaFurao.resource.model.AgendamentoResource;
import br.com.barbeariaFurao.service.BuscarClienteServiceImpl;
import br.com.barbeariaFurao.service.BuscarServicoServiceImpl;

@Component
public class AgendamentoConversor {

	@Autowired
	private BuscarClienteServiceImpl buscarClienteServiceImpl;
	
	@Autowired
	private BuscarServicoServiceImpl buscarServicoServiceImpl;
	
	public Agendamento conversor(AgendamentoResource agendamentoResource) throws AgendamentoResourceException, ClienteNotFoundException, ServicoNotFoundException {
		Cliente buscarClientePorId = buscarClienteServiceImpl.buscarClientePorId(Long.parseLong(agendamentoResource.getIdCliente()));
		Servico buscarServicoPorId = buscarServicoServiceImpl.buscarServicoPorId(Long.parseLong(agendamentoResource.getIdServico()));
		try {
			Agendamento agendamento = new Agendamento();
			agendamento.setDataAgendamento(LocalDate.parse(agendamentoResource.getDataAgendamento()));
			agendamento.setHorario(Time.valueOf(agendamentoResource.getHorario()));
			agendamento.setFuncionario(agendamentoResource.getFuncionario());
			agendamento.setServico(buscarServicoPorId);
			agendamento.setCliente(buscarClientePorId);
			return agendamento;
		} catch (Exception e) {
			throw new AgendamentoResourceException("não foi possível converter o resouce para entidade, resouce: "+agendamentoResource);
		}
	}
	

}
