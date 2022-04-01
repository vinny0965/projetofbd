package br.com.barbeariaFurao.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.datasource.model.Cliente;
import br.com.barbeariaFurao.datasource.model.Endereco;
import br.com.barbeariaFurao.exception.ClienteNotFoundException;
import br.com.barbeariaFurao.exception.EnderecoNotFoundException;
import br.com.barbeariaFurao.repository.ClienteRepository;
import br.com.barbeariaFurao.resource.model.ClienteResource;

@Service
public class BuscarClienteServiceImpl {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BuscarEnderecoServiceImpl buscarEnderecoServiceImpl;
	
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}

	public Cliente buscarClientePorId(Long id) throws ClienteNotFoundException {
		 Optional<Cliente> findById = clienteRepository.findById(id);
		 Cliente cliente = null;
		 if(!findById.isPresent()) {
			 throw new ClienteNotFoundException("Cliente não encontrado pelo id: "+id);
		 }else {
			 cliente = findById.get();
		 }
		 return cliente;
	}
	
	public void atualizarCliente(ClienteResource clienteResource, Long id) throws NumberFormatException, EnderecoNotFoundException {
		Endereco buscarEnderecoPorId = buscarEnderecoServiceImpl.buscarEnderecoPorId(Long.parseLong(clienteResource.getIdEndereco()));
		Cliente cliente = null;
		Optional<Cliente> findById = clienteRepository.findById(id);
		if(findById.isPresent()) {
			cliente = findById.get();
			cliente.setEndereco(buscarEnderecoPorId);
			cliente.setNome(clienteResource.getNome());
			cliente.setCpf(clienteResource.getEmail());
			cliente.setDataNascimento(LocalDate.parse(clienteResource.getDataNascimento()));
			cliente.setSexo(clienteResource.getSexo());
			cliente.setTelefone(clienteResource.getTelefone());
			cliente.setEmail(clienteResource.getEmail());
			clienteRepository.save(cliente);
		}
		
	}
	
	public void deletarCliente(Long id) throws ClienteNotFoundException {
		Optional<Cliente> findById = clienteRepository.findById(id);
		if(findById.isPresent()) {
			clienteRepository.delete(findById.get());
		}else {
			throw new ClienteNotFoundException("Cliente não encontrado pelo id: "+id);
		}
	}
	
}
