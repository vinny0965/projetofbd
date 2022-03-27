package br.com.barbeariaFurao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.datasource.model.FluxoCaixa;
import br.com.barbeariaFurao.repository.FluxoCaixaRepository;

@Service
public class BuscarFluxoCaixaServiceImpl {
	
	@Autowired
	private FluxoCaixaRepository fluxoCaixaRepository;
	
	public List<FluxoCaixa> listarFluxosCaixa(){
		return fluxoCaixaRepository.findAll();
	}

}
