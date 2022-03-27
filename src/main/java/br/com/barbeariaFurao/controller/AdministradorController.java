package br.com.barbeariaFurao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbeariaFurao.datasouce.model.Administrador;
import br.com.barbeariaFurao.service.BuscarAdministradorServiceImpl;

@RestController
@RequestMapping("/api")
public class AdministradorController {
	
	@Autowired
	private BuscarAdministradorServiceImpl buscarAdministradorServiceImpl;
	
	@GetMapping(path = "/administradores")
	public List<Administrador> listarAdministradores(){
		return buscarAdministradorServiceImpl.listarAdministradores();
	}

}
