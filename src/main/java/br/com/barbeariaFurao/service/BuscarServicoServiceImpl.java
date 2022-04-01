package br.com.barbeariaFurao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.datasource.model.Administrador;
import br.com.barbeariaFurao.datasource.model.Servico;
import br.com.barbeariaFurao.exception.AdministradorNotFoundException;
import br.com.barbeariaFurao.exception.ServicoNotFoundException;
import br.com.barbeariaFurao.repository.ServicoRepository;
import br.com.barbeariaFurao.resource.model.ServicoResource;

@Service
public class BuscarServicoServiceImpl {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private BuscarAdministradorServiceImpl buscarAdministradorServiceImpl;
	
	public List<Servico> listarServicos(){
		return servicoRepository.findAll();
	}
	
	public Servico buscarServicoPorId(Long id) throws ServicoNotFoundException {
		Optional<Servico> findById = servicoRepository.findById(id);
		Servico servico = null;
		if(!findById.isPresent()) {
			throw new ServicoNotFoundException("servico não encontrado pelo id: "+id);
		}else {
			servico = findById.get();
		}
		return servico;
	}
	
	public void deletarServico(Long id) throws ServicoNotFoundException {
		Servico buscarServicoPorId = buscarServicoPorId(id);
		servicoRepository.delete(buscarServicoPorId);
	}
	
	public void atualizarServico(ServicoResource servicoResource, Long id) throws NumberFormatException, AdministradorNotFoundException, ServicoNotFoundException {
		Administrador buscarAdministradorPorId = buscarAdministradorServiceImpl.buscarAdministradorPorId(Long.parseLong(servicoResource.getIdAdministrador()));
		Servico buscarServicoPorId = buscarServicoPorId(id);
		Servico servico = buscarServicoPorId;
		servico.setTipoServico(servicoResource.getTipoServico());
		servico.setValor(Double.parseDouble(servicoResource.getValor()));
		servico.setAdministrador(buscarAdministradorPorId);
		servicoRepository.save(servico);
		
	}
	
	
}
