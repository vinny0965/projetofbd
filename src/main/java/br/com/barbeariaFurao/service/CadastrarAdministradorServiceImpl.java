package br.com.barbeariaFurao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.conversor.AdministradorConversor;
import br.com.barbeariaFurao.datasouce.model.Administrador;
import br.com.barbeariaFurao.exception.AdministradorResourceException;
import br.com.barbeariaFurao.exception.EnderecoNotFoundException;
import br.com.barbeariaFurao.repository.AdministradorRepository;
import br.com.barbeariaFurao.resource.model.AdministradorResource;

@Service
public class CadastrarAdministradorServiceImpl {

	@Autowired
	private AdministradorRepository administradorRepository;
	
	@Autowired
	private AdministradorConversor administradorConversor;
	
	public ResponseEntity<Administrador> cadastrar(AdministradorResource administradorResource) throws AdministradorResourceException{
		Administrador conversor = administradorConversor.conversor(administradorResource);
		administradorRepository.saveAndFlush(conversor);
		return ResponseEntity.ok(conversor);
	}
	
}
