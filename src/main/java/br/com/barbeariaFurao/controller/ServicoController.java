package br.com.barbeariaFurao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbeariaFurao.datasource.model.Servico;
import br.com.barbeariaFurao.service.BuscarServicoServiceImpl;

@RestController
@RequestMapping("/api")
public class ServicoController {
	
	@Autowired
	private BuscarServicoServiceImpl buscarServicoServiceImpl;
	
	@GetMapping(path = "/servicos")
	public List<Servico> listarServicos(){
		return buscarServicoServiceImpl.listarServicos();
	}

}
