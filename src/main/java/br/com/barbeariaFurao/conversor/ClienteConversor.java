package br.com.barbeariaFurao.conversor;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.barbeariaFurao.datasource.model.Cliente;
import br.com.barbeariaFurao.datasource.model.Endereco;
import br.com.barbeariaFurao.exception.ClienteResouceException;
import br.com.barbeariaFurao.exception.EnderecoNotFoundException;
import br.com.barbeariaFurao.resource.model.ClienteResource;
import br.com.barbeariaFurao.service.BuscarEnderecoServiceImpl;

@Component
public class ClienteConversor {
	
	@Autowired
	private BuscarEnderecoServiceImpl buscarEnderecoServiceImpl;

	public Cliente converter(ClienteResource clienteResource) throws ClienteResouceException, NumberFormatException, EnderecoNotFoundException {
		Endereco buscarEnderecoPorId = buscarEnderecoServiceImpl.buscarEnderecoPorId(Long.parseLong(clienteResource.getIdEndereco()));
		try {
			Cliente cliente = new Cliente();
			cliente.setNome(clienteResource.getNome());
			cliente.setCpf(clienteResource.getCpf());
			cliente.setDataNascimento(LocalDate.parse(clienteResource.getDataNascimento()));
			cliente.setEmail(clienteResource.getEmail());
			cliente.setSexo(clienteResource.getSexo());
			cliente.setTelefone(clienteResource.getTelefone());
			cliente.setEndereco(buscarEnderecoPorId);
			return cliente;
			
		} catch (Exception e) {
			throw new ClienteResouceException("não foi possível converter o cliente resource para entidade resource:"+clienteResource);
		}
	}
	
	
}
