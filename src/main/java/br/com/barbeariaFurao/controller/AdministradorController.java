package br.com.barbeariaFurao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbeariaFurao.datasouce.model.Administrador;
import br.com.barbeariaFurao.exception.AdministradorNotFoundException;
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
	public void cadastrarAdministrador(@RequestBody AdministradorResource administradorResource) throws AdministradorResourceException, EnderecoNotFoundException {
		cadastrarAdministradorServiceImpl.cadastrar(administradorResource);
	}
	
	@DeleteMapping(path = "/administrador/delete/id/{id}")
	public void deletarAdministrador(@PathVariable(name = "id",required = true)Long id) throws AdministradorNotFoundException {
		buscarAdministradorServiceImpl.deletarAdministrador(id);
	}
	
	@PutMapping(path = "/administrador/update/id/{id}")
	public void atualizarEndereco(@PathVariable(name = "id",required = true)Long id, @RequestBody AdministradorResource administradorResource) throws EnderecoNotFoundException, AdministradorNotFoundException, AdministradorResourceException {
		buscarAdministradorServiceImpl.atualizarAdministrador(administradorResource, id);
	}

}
