package br.com.barbeariaFurao.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.barbeariaFurao.datasource.model.Administrador;
import br.com.barbeariaFurao.datasource.model.Servico;
import br.com.barbeariaFurao.exception.AdministradorNotFoundException;
import br.com.barbeariaFurao.exception.ServicoResourceException;
import br.com.barbeariaFurao.resource.model.ServicoResource;
import br.com.barbeariaFurao.service.BuscarAdministradorServiceImpl;

@Component
public class ServicoConversor {
	
	@Autowired
	private BuscarAdministradorServiceImpl buscarAdministradorServiceImpl;
	
	public Servico conversor(ServicoResource servicoResource) throws ServicoResourceException, NumberFormatException, AdministradorNotFoundException {
		Administrador buscarAdministradorPorId = buscarAdministradorServiceImpl.buscarAdministradorPorId(Long.parseLong(servicoResource.getIdAdministrador()));
		try {
			Servico servico = new Servico();
			servico.setTipoServico(servicoResource.getTipoServico());
			servico.setValor(Double.parseDouble(servicoResource.getValor()));
			servico.setAdministrador(buscarAdministradorPorId);
			return servico;
		} catch (Exception e) {
			throw new ServicoResourceException("não foi possível converter o resource servico para entidade resouce: "+servicoResource);
		}
	}

}
