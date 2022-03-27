package br.com.barbeariaFurao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbeariaFurao.datasource.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
