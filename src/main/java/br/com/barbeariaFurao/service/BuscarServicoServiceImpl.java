package br.com.barbeariaFurao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.datasouce.model.Servico;
import br.com.barbeariaFurao.repository.ServicoRepository;

@Service
public class BuscarServicoServiceImpl {

	@Autowired
	private ServicoRepository servicoRepository;
	
	public List<Servico> listarServicos(){
		return servicoRepository.findAll();
	}
}
