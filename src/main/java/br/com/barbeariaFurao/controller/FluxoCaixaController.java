package br.com.barbeariaFurao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbeariaFurao.datasource.model.FluxoCaixa;
import br.com.barbeariaFurao.service.BuscarFluxoCaixaServiceImpl;

@RestController
@RequestMapping("/api")
public class FluxoCaixaController {
	
	@Autowired
	private BuscarFluxoCaixaServiceImpl buscarFluxoCaixaServiceImpl;
	
	@GetMapping(path = "/fluxos-caixa")
	public List<FluxoCaixa> listarFluxoxCaixa(){
		return buscarFluxoCaixaServiceImpl.listarFluxosCaixa();
	}
}
