package br.com.barbeariaFurao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbeariaFurao.datasource.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
