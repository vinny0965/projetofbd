package br.com.barbeariaFurao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.datasource.model.CupomDesconto;
import br.com.barbeariaFurao.repository.CupomRepository;

@Service
public class BuscarCupomServiceImpl {
	
	@Autowired
	private CupomRepository cupomRepository;
	
	public List<CupomDesconto> listarCupons(){
		return cupomRepository.findAll();
	}

}
