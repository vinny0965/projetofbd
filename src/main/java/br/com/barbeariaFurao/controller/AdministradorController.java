package br.com.barbeariaFurao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbeariaFurao.datasouce.model.Administrador;
import br.com.barbeariaFurao.exception.AdministradorResourceException;
import br.com.barbeariaFurao.exception.EnderecoNotFoundException;
import br.com.barbeariaFurao.resource.model.AdministradorResource;
import br.com.barbeariaFurao.service.BuscarAdministradorServiceImpl;
import br.com.barbeariaFurao.service.CadastrarAdministradorServiceImpl;

@RestController
@RequestMapping("/api")
public class AdministradorController {
	
	@Autowired
	private BuscarAdministradorServiceImpl buscarAdministradorServiceImpl;
	
	@Autowired
	private CadastrarAdministradorServiceImpl cadastrarAdministradorServiceImpl;
	
	@GetMapping(path = "/administradores")
	public List<Administrador> listarAdministradores(){
		return buscarAdministradorServiceImpl.listarAdministradores();
	}
	
	@PostMapping(path = "/administrador/save")
	public void cadastrarAdministrador(@RequestBody AdministradorResource administradorResource) throws AdministradorResourceException {
		cadastrarAdministradorServiceImpl.cadastrar(administradorResource);
	}

}
