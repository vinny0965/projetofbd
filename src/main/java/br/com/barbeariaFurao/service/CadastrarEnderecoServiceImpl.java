package br.com.barbeariaFurao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.conversor.EnderecoConversor;
import br.com.barbeariaFurao.datasouce.model.Endereco;
import br.com.barbeariaFurao.exception.EnderecoResouceException;
import br.com.barbeariaFurao.repository.EnderecoRepository;
import br.com.barbeariaFurao.resource.model.EnderecoResource;

@Service
public class CadastrarEnderecoServiceImpl {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private EnderecoConversor enderecoConversor;
	
	public void cadastrar(EnderecoResource enderecoResource) {
		Endereco conversor;
		try {
			conversor = enderecoConversor.conversor(enderecoResource);
			enderecoRepository.saveAndFlush(conversor);
		} catch (EnderecoResouceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
