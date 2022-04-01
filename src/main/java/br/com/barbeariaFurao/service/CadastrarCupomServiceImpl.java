package br.com.barbeariaFurao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.conversor.CupomDescontoConversor;
import br.com.barbeariaFurao.datasource.model.CupomDesconto;
import br.com.barbeariaFurao.exception.AdministradorNotFoundException;
import br.com.barbeariaFurao.exception.CupomDescontoResourceException;
import br.com.barbeariaFurao.repository.CupomRepository;
import br.com.barbeariaFurao.resource.model.CupomDescontoResource;

@Service
public class CadastrarCupomServiceImpl {
	
	@Autowired
	private CupomDescontoConversor conversor;
	
	@Autowired
	private CupomRepository cupomRepository;
	
	public ResponseEntity<CupomDesconto> cadastrarCupom(CupomDescontoResource cupomDescontoResource) throws NumberFormatException, CupomDescontoResourceException, AdministradorNotFoundException {
		CupomDesconto conversor2 = conversor.conversor(cupomDescontoResource);
		cupomRepository.saveAndFlush(conversor2);
		return ResponseEntity.ok(conversor2);
	}


}
