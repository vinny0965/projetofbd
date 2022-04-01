package br.com.barbeariaFurao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.datasource.model.Administrador;
import br.com.barbeariaFurao.datasource.model.CupomDesconto;
import br.com.barbeariaFurao.exception.AdministradorNotFoundException;
import br.com.barbeariaFurao.exception.CupomDescontoNotFoundException;
import br.com.barbeariaFurao.repository.CupomRepository;
import br.com.barbeariaFurao.resource.model.CupomDescontoResource;

@Service
public class BuscarCupomServiceImpl {
	
	@Autowired
	private CupomRepository cupomRepository;
	
	@Autowired
	private BuscarAdministradorServiceImpl buscarAdministradorServiceImpl;
	
	public List<CupomDesconto> listarCupons(){
		return cupomRepository.findAll();
	}
	
	public CupomDesconto buscarCupomPorId(Long id) throws CupomDescontoNotFoundException {
		Optional<CupomDesconto> findById = cupomRepository.findById(id);
		CupomDesconto cupomDesconto = null;
		if(!findById.isPresent()) {
			throw new CupomDescontoNotFoundException("cupom não encontrado pelo id: "+id);
		}else {
			cupomDesconto = findById.get();
		}
		return cupomDesconto;
	}
	
	public void deletarCupomPorId(Long id) throws CupomDescontoNotFoundException {
		CupomDesconto buscarCupomPorId = buscarCupomPorId(id);
		cupomRepository.delete(buscarCupomPorId);
	}
	
	public void atualizarCupomPorId(CupomDescontoResource cupomDescontoResource, Long id) throws CupomDescontoNotFoundException, NumberFormatException, AdministradorNotFoundException {
		Administrador buscarAdministradorPorId = buscarAdministradorServiceImpl.buscarAdministradorPorId(Long.parseLong(cupomDescontoResource.getIdAdministrador()));
		CupomDesconto buscarCupomPorId = buscarCupomPorId(id);
		if(buscarCupomPorId !=null) {
			CupomDesconto cupomDesconto = buscarCupomPorId;
			cupomDesconto.setAdministrador(buscarAdministradorPorId);
			cupomDesconto.setCodigo(cupomDescontoResource.getCodigo());
			cupomDesconto.setValor(Double.parseDouble(cupomDescontoResource.getValor()));
			cupomRepository.save(cupomDesconto);
		}
	}
	

}
