package br.com.barbeariaFurao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbeariaFurao.datasource.model.CupomDesconto;

public interface CupomRepository extends JpaRepository<CupomDesconto, Long>{

}
