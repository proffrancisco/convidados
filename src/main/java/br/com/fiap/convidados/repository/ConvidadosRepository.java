package br.com.fiap.convidados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.convidados.entity.ConvidadosEntity;

public interface ConvidadosRepository extends JpaRepository<ConvidadosEntity, Long>{

}
