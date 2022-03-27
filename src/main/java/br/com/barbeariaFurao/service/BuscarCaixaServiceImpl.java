package br.com.barbeariaFurao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.datasouce.model.Caixa;
import br.com.barbeariaFurao.repository.CaixaRepository;

@Service
public class BuscarCaixaServiceImpl {
	
	@Autowired
	private CaixaRepository caixaRepository;
	
	public List<Caixa> listarCaixas(){
		return caixaRepository.findAll();
	}

}
