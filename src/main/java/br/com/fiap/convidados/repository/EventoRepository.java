package br.com.fiap.convidados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.convidados.entity.EventoEntity;

@Repository
public interface EventoRepository extends JpaRepository<EventoEntity, Long>{

	
}
