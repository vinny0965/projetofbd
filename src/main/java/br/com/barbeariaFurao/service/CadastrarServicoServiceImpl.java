package br.com.barbeariaFurao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.conversor.ServicoConversor;
import br.com.barbeariaFurao.datasource.model.Servico;
import br.com.barbeariaFurao.exception.AdministradorNotFoundException;
import br.com.barbeariaFurao.exception.ServicoResourceException;
import br.com.barbeariaFurao.repository.ServicoRepository;
import br.com.barbeariaFurao.resource.model.ServicoResource;

@Service
public class CadastrarServicoServiceImpl {
	
	@Autowired
	private ServicoConversor servicoConversor;

	@Autowired
	private ServicoRepository servicoRepository;
	
	public ResponseEntity<Servico> cadastrarServico(ServicoResource servicoResource) throws NumberFormatException, ServicoResourceException, AdministradorNotFoundException {
		Servico conversor = servicoConversor.conversor(servicoResource);
		servicoRepository.saveAndFlush(conversor);
		return ResponseEntity.ok(conversor);
	}

}
