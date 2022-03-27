package br.com.barbeariaFurao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.barbeariaFurao.datasouce.model.Endereco;
import br.com.barbeariaFurao.exception.EnderecoNotFoundException;
import br.com.barbeariaFurao.repository.EnderecoRepository;
import br.com.barbeariaFurao.resource.model.EnderecoResource;

@Service
public class BuscarEnderecoServiceImpl {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> listarEnderecos(){
		return enderecoRepository.findAll(); 
	}
	
	public  Endereco buscarEnderecoPorId(Long id) throws EnderecoNotFoundException {
		try {
			Optional<Endereco> findById = enderecoRepository.findById(id);
			Endereco endereco = findById.get();
			return endereco;
		} catch (Exception e) {
			throw new EnderecoNotFoundException("Endereco não encontrado pelo id"+id);
		}
	}
//	public  Endereco buscarEnderecoPorId(Long id) throws EnderecoNotFoundException {
//		Optional<Endereco> findById = enderecoRepository.findById(id);
//		Endereco endereco = null;
//		if(!findById.isPresent()) {
//			throw new EnderecoNotFoundException("endereco não encontrado pelo ID:"+id);
//		}else {
//			endereco = findById.get();
//		}
//		ResponseEntity.ok(endereco);
//		return endereco;
//	}
	
	public void AtualizarEndereco(EnderecoResource enderecoResource, Long id) {
		Optional<Endereco> findById = enderecoRepository.findById(id);
		if(findById.isPresent()) {
			Endereco endereco = findById.get();
			endereco.setLogradouro(enderecoResource.getLogradouro());
			endereco.setBairro(enderecoResource.getBairro());
			endereco.setCep(enderecoResource.getCep());
			Integer checkNumeroEndereco = checkNumeroEndereco(enderecoResource.getNumero());
			endereco.setNumero(checkNumeroEndereco);
			enderecoRepository.save(endereco);
		}
	}
	
	public void deletarEndereco(Long id) throws EnderecoNotFoundException {
		Optional<Endereco> findById = enderecoRepository.findById(id);
		if(findById.isPresent()) {
			enderecoRepository.delete(findById.get());
		}else {
			throw new EnderecoNotFoundException("endereco não encontrado pelo ID:"+id);
		}
	}
	
	private Integer checkNumeroEndereco(String numero) {
		return Integer.parseInt(numero);
	}
	
	
}
