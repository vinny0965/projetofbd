package br.com.barbeariaFurao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.conversor.CaixaConversor;
import br.com.barbeariaFurao.datasource.model.Caixa;
import br.com.barbeariaFurao.exception.CaixaResourceException;
import br.com.barbeariaFurao.exception.EnderecoNotFoundException;
import br.com.barbeariaFurao.repository.CaixaRepository;
import br.com.barbeariaFurao.resource.model.CaixaResource;

@Service
public class CadastrarCaixaServiceImpl {
	
	@Autowired
	private CaixaConversor caixaConversor;
	
	@Autowired
	private CaixaRepository caixaRepository;
	
	public ResponseEntity<Caixa> CadastrarCaixa(CaixaResource caixaResource) throws NumberFormatException, EnderecoNotFoundException, CaixaResourceException {
		Caixa conversor = caixaConversor.conversor(caixaResource);
		caixaRepository.saveAndFlush(conversor);
		return ResponseEntity.ok(conversor);
	}

}
