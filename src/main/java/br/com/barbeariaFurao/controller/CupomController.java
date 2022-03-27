package br.com.barbeariaFurao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbeariaFurao.datasouce.model.CupomDesconto;
import br.com.barbeariaFurao.service.BuscarCupomServiceImpl;

@RestController
@RequestMapping("/api")
public class CupomController {
	
	@Autowired
	private BuscarCupomServiceImpl buscarCupomServiceImpl;
	
	@GetMapping(path = "/cupons")
	public List<CupomDesconto> listarCupons(){
		return buscarCupomServiceImpl.listarCupons();
	}

}
