package br.com.barbeariaFurao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbeariaFurao.datasource.model.Caixa;

public interface CaixaRepository extends JpaRepository<Caixa, Long>{

}
