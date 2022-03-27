package br.com.barbeariaFurao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbeariaFurao.datasource.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

}
