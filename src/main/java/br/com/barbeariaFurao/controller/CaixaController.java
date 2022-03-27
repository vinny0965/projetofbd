package br.com.barbeariaFurao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbeariaFurao.datasource.model.Caixa;
import br.com.barbeariaFurao.service.BuscarCaixaServiceImpl;

@RestController
@RequestMapping("/api")
public class CaixaController {
	
	@Autowired
	private BuscarCaixaServiceImpl buscarCaixaServiceImpl;
	
	@GetMapping(path = "/caixas")
	public List<Caixa> listarCaixas(){
		return buscarCaixaServiceImpl.listarCaixas();
	}

}
