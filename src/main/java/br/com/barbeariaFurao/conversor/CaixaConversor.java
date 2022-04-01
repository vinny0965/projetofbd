package br.com.barbeariaFurao.conversor;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.barbeariaFurao.datasource.model.Caixa;
import br.com.barbeariaFurao.datasource.model.Endereco;
import br.com.barbeariaFurao.exception.CaixaResourceException;
import br.com.barbeariaFurao.exception.EnderecoNotFoundException;
import br.com.barbeariaFurao.resource.model.CaixaResource;
import br.com.barbeariaFurao.service.BuscarEnderecoServiceImpl;

@Component
public class CaixaConversor {
	
	@Autowired
	private BuscarEnderecoServiceImpl buscarEnderecoServiceImpl;
	
	
	public Caixa conversor(CaixaResource caixaResource) throws NumberFormatException, EnderecoNotFoundException, CaixaResourceException {
		Endereco buscarEnderecoPorId = buscarEnderecoServiceImpl.buscarEnderecoPorId(Long.parseLong(caixaResource.getIdEndereco()));
		try {
			Caixa caixa = new Caixa();
			caixa.setNome(caixaResource.getNome());
			caixa.setCpf(caixaResource.getCpf());
			caixa.setDataNascimento(LocalDate.parse(caixaResource.getDataNascimento()));
			caixa.setEmail(caixaResource.getEmail());
			caixa.setEndereco(buscarEnderecoPorId);
			caixa.setLogin(caixaResource.getLogin());
			caixa.setMatricula(caixaResource.getMatricula());
			caixa.setSenha(caixaResource.getSenha());
			caixa.setSexo(caixaResource.getSexo());
			caixa.setTelefone(caixaResource.getTelefone());
			return caixa;
			
		} catch (Exception e) {
			throw new CaixaResourceException("erro ao converter resource caixa para entidade, resource: "+caixaResource);
		}
	}
	

}
