package br.com.barbeariaFurao.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.barbeariaFurao.datasource.model.Administrador;
import br.com.barbeariaFurao.datasource.model.CupomDesconto;
import br.com.barbeariaFurao.exception.AdministradorNotFoundException;
import br.com.barbeariaFurao.exception.CupomDescontoResourceException;
import br.com.barbeariaFurao.resource.model.CupomDescontoResource;
import br.com.barbeariaFurao.service.BuscarAdministradorServiceImpl;

@Component
public class CupomDescontoConversor {

	@Autowired
	private BuscarAdministradorServiceImpl buscarAdministradorServiceImpl;
	
	public CupomDesconto conversor(CupomDescontoResource cupomDescontoResource) throws CupomDescontoResourceException, NumberFormatException, AdministradorNotFoundException {
		Administrador buscarAdministradorPorId = buscarAdministradorServiceImpl.buscarAdministradorPorId(Long.parseLong(cupomDescontoResource.getIdAdministrador()));
		try {
			CupomDesconto cupomDesconto = new CupomDesconto();
			cupomDesconto.setAdministrador(buscarAdministradorPorId);
			cupomDesconto.setCodigo(cupomDescontoResource.getCodigo());
			cupomDesconto.setValor(Double.parseDouble(cupomDescontoResource.getValor()));
			return cupomDesconto;
		} catch (Exception e) {
			throw new CupomDescontoResourceException("não foi possível converter o resouce para entidade, resource: "+cupomDescontoResource);
		}
	}
	
}
