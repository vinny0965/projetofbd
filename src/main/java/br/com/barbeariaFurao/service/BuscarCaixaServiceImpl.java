package br.com.barbeariaFurao.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.datasource.model.Caixa;
import br.com.barbeariaFurao.datasource.model.Endereco;
import br.com.barbeariaFurao.exception.CaixaNotFoundException;
import br.com.barbeariaFurao.exception.EnderecoNotFoundException;
import br.com.barbeariaFurao.repository.CaixaRepository;
import br.com.barbeariaFurao.resource.model.CaixaResource;

@Service
public class BuscarCaixaServiceImpl {
	
	@Autowired
	private CaixaRepository caixaRepository;
	
	@Autowired
	private BuscarEnderecoServiceImpl buscarEnderecoServiceImpl;
	
	public List<Caixa> listarCaixas(){
		return caixaRepository.findAll();
	}
	
	public Caixa buscarCaixaPorId(Long id) throws CaixaNotFoundException {
		try {
			Optional<Caixa> findById = caixaRepository.findById(id);
			Caixa caixa = findById.get();
			return caixa;
		} catch (Exception e) {
			throw new CaixaNotFoundException("caixa não encontrado pelo id :"+id);
		}
	}
	
	public void deletarCaixa(Long id) throws CaixaNotFoundException {
		Caixa buscarCaixaPorId = buscarCaixaPorId(id);
		caixaRepository.delete(buscarCaixaPorId);
	}
	
	public void atualizarCaixa(CaixaResource caixaResource, Long id) throws CaixaNotFoundException, NumberFormatException, EnderecoNotFoundException {
		Endereco buscarEnderecoPorId = buscarEnderecoServiceImpl.buscarEnderecoPorId(Long.parseLong(caixaResource.getIdEndereco()));
		Caixa buscarCaixaPorId = buscarCaixaPorId(id);
		if(buscarCaixaPorId !=null) {
			buscarCaixaPorId.setNome(caixaResource.getNome());
			buscarCaixaPorId.setCpf(caixaResource.getCpf());
			buscarCaixaPorId.setDataNascimento(LocalDate.parse(caixaResource.getDataNascimento()));
			buscarCaixaPorId.setEmail(caixaResource.getEmail());
			buscarCaixaPorId.setEndereco(buscarEnderecoPorId);
			buscarCaixaPorId.setLogin(caixaResource.getLogin());
			buscarCaixaPorId.setMatricula(caixaResource.getMatricula());
			buscarCaixaPorId.setSenha(caixaResource.getSenha());
			buscarCaixaPorId.setSexo(caixaResource.getSexo());
			buscarCaixaPorId.setTelefone(caixaResource.getTelefone());
			caixaRepository.save(buscarCaixaPorId);
		}
	}
	

}
