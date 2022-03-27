package br.com.barbeariaFurao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.datasouce.model.Administrador;
import br.com.barbeariaFurao.repository.AdministradorRepository;

@Service
public class BuscarAdministradorServiceImpl {
	
	@Autowired
	private AdministradorRepository administradorRepository;
	
	public List<Administrador> listarAdministradores(){
		return administradorRepository.findAll();
	}

}
