package br.com.barbeariaFurao.conversor;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.barbeariaFurao.datasource.model.Administrador;
import br.com.barbeariaFurao.datasource.model.Endereco;
import br.com.barbeariaFurao.exception.AdministradorResourceException;
import br.com.barbeariaFurao.exception.EnderecoNotFoundException;
import br.com.barbeariaFurao.repository.EnderecoRepository;
import br.com.barbeariaFurao.resource.model.AdministradorResource;
import br.com.barbeariaFurao.service.BuscarEnderecoServiceImpl;

@Component
public class AdministradorConversor {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private BuscarEnderecoServiceImpl buscarEnderecoServiceImpl;
	
public Administrador conversor(AdministradorResource administradorResource) throws AdministradorResourceException, EnderecoNotFoundException {
		Long checkIdEndereco = checkIdEndereco(administradorResource.getEndereco());
		Endereco buscarEnderecoPorId = buscarEnderecoServiceImpl.buscarEnderecoPorId(checkIdEndereco);

		try {
			Administrador administrador = new Administrador();
			LocalDate ceckDataNascimento = ceckDataNascimento(administradorResource.getDataNascimento());
//			Optional<Endereco> findById = enderecoRepository.findById(checkIdEndereco);
			if(buscarEnderecoPorId !=null) {
				Endereco endereco = buscarEnderecoPorId;
				administrador.setEndereco(endereco);
			}
			administrador.setCpf(administradorResource.getCpf());
			administrador.setDataNascimento(ceckDataNascimento);
			administrador.setEmail(administradorResource.getEmail());
			administrador.setLogin(administradorResource.getLogin());
			administrador.setSenha(administradorResource.getSenha());
			administrador.setSexo(administradorResource.getSexo());
			administrador.setTelefone(administradorResource.getSexo());
			administrador.setNome(administradorResource.getNome());
			return administrador;
		} catch (Exception e) {
			throw new AdministradorResourceException("não foi possível converter o resouce para entidade, resource:"+administradorResource);
		}
	}

	public LocalDate ceckDataNascimento(String dataNascimento) {
		return LocalDate.parse(dataNascimento);
	}
	
	
	
	public Long checkIdEndereco(String idEndereco) {
		return Long.parseLong(idEndereco);
	}
	

}
