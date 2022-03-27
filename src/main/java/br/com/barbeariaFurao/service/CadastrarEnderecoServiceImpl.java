package br.com.barbeariaFurao.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.conversor.EnderecoConversor;
import br.com.barbeariaFurao.datasource.model.Endereco;
import br.com.barbeariaFurao.exception.EnderecoResouceException;
import br.com.barbeariaFurao.repository.EnderecoRepository;
import br.com.barbeariaFurao.resource.model.EnderecoResource;

@Service
public class CadastrarEnderecoServiceImpl {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private EnderecoConversor enderecoConversor;
	
	public ResponseEntity<Endereco> cadastrar(EnderecoResource enderecoResource) throws EnderecoResouceException {
		Endereco conversor;
		conversor = enderecoConversor.conversor(enderecoResource);
		enderecoRepository.saveAndFlush(conversor);
		return ResponseEntity.ok(conversor);
		
	}

}
