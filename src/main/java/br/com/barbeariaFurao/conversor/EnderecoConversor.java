package br.com.barbeariaFurao.conversor;

import org.springframework.stereotype.Component;


import br.com.barbeariaFurao.datasouce.model.Endereco;
import br.com.barbeariaFurao.exception.EnderecoResouceException;
import br.com.barbeariaFurao.resource.model.EnderecoResource;


@Component
public class EnderecoConversor {
	
	
	public Endereco conversor(EnderecoResource enderecoResource) throws EnderecoResouceException {
		
		try {
			Endereco endereco = new Endereco();
			Integer checkNumeroEndereco = checkNumeroEndereco(enderecoResource.getNumero());
			endereco.setLogradouro(enderecoResource.getLogradouro());
			endereco.setBairro(enderecoResource.getBairro());
			endereco.setCep(enderecoResource.getCep());
			endereco.setNumero(checkNumeroEndereco);
			return endereco;
		} catch (Exception e) {
			throw new EnderecoResouceException("não foi possível converter o resource para entidade: "+enderecoResource);
		}
		
	}
	
	private Integer checkNumeroEndereco(String numero) {
		return Integer.parseInt(numero);
	}
	
	

}
