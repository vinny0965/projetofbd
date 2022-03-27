package br.com.barbeariaFurao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.conversor.AdministradorConversor;
import br.com.barbeariaFurao.datasouce.model.Administrador;
import br.com.barbeariaFurao.datasouce.model.Endereco;
import br.com.barbeariaFurao.exception.AdministradorNotFoundException;
import br.com.barbeariaFurao.exception.AdministradorResourceException;
import br.com.barbeariaFurao.exception.EnderecoNotFoundException;
import br.com.barbeariaFurao.repository.AdministradorRepository;
import br.com.barbeariaFurao.repository.EnderecoRepository;
import br.com.barbeariaFurao.resource.model.AdministradorResource;
import br.com.barbeariaFurao.resource.model.EnderecoResource;

@Service
public class BuscarAdministradorServiceImpl {
	
	@Autowired
	private AdministradorRepository administradorRepository;
	
	@Autowired
	private BuscarEnderecoServiceImpl buscarEnderecoServiceImpl;
	
	@Autowired
	private AdministradorConversor administradorConversor;
	
	public List<Administrador> listarAdministradores(){
		return administradorRepository.findAll();
	}
	
	public Administrador buscarAdministradorPorId(Long id) throws AdministradorNotFoundException {
		Optional<Administrador> findById = administradorRepository.findById(id);
		Administrador administrador = null;
		if(!findById.isPresent()) {
			throw new AdministradorNotFoundException("Administrador não encontrado pelo id:"+id);
		}else {
			administrador = findById.get();
		}
		return administrador;
	}
	
	public void deletarAdministrador(Long id) throws AdministradorNotFoundException {
		Optional<Administrador> findById = administradorRepository.findById(id);
		if(findById.isPresent()) {
			administradorRepository.delete(findById.get());
		}else {
			throw new AdministradorNotFoundException("Administrador não encontrado pelo id:"+id);
		}	
	}
	
	public void atualizarAdministrador(AdministradorResource administradorResource, Long id) throws EnderecoNotFoundException, AdministradorNotFoundException, AdministradorResourceException{
		Endereco buscarEnderecoPorId = buscarEnderecoServiceImpl.buscarEnderecoPorId(Long.parseLong(administradorResource.getEndereco()));
		Optional<Administrador> findById = administradorRepository.findById(id);
		if(findById.isPresent()) {
			Administrador administrador = findById.get();
			administrador.setNome(administradorResource.getNome());
			administrador.setEndereco(buscarEnderecoPorId);
			administradorRepository.save(administrador);
		}
	}
	
	public Long checkId(String id) {
		return Long.parseLong(id);
	}
}
