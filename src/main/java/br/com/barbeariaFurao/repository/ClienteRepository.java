package br.com.barbeariaFurao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbeariaFurao.datasouce.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
