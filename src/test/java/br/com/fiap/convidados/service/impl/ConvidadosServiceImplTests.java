package br.com.fiap.convidados.service.impl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.fiap.convidados.dto.ConvidadosDto;
import br.com.fiap.convidados.entity.ConvidadosEntity;
import br.com.fiap.convidados.repository.ConvidadosRepository;

@RunWith(MockitoJUnitRunner.class)
public class ConvidadosServiceImplTests {
	
	@InjectMocks
	ConvidadosServiceImpl service;
	
	@Mock
	ConvidadosRepository repository;
	
	private ConvidadosEntity entity;
	
	private List<ConvidadosEntity> listaEntity;
	@Before
	public void setup() {
		
		listaEntity = new ArrayList<>();
		
		entity = new ConvidadosEntity();
		entity.setNome("teste");
		entity.setId(1L);
		entity.setEmail("email");
		entity.setAcompanhante("1");
		
		listaEntity.add(entity);
	}
	
	@Test
	public void deveSalvarConvidadosComSucesso() {
		when(repository.save(any(ConvidadosEntity.class))).thenReturn(entity);
		ConvidadosDto convidadosDto = service.salvarConvidados(new ConvidadosDto());
		assertEquals("teste",convidadosDto.getNome());
	}
	
	@Test
	public void deveListarConvidadosComSucesso() {
		when(repository.findAll()).thenReturn(listaEntity);
		List<ConvidadosDto> listaConvidadosDto = service.listarConvidados();
		assertNotNull(listaConvidadosDto);
	}
	
	@Test
	public void deveEditarConvidadosComSucesso() {
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		ConvidadosDto dto = service.editarConvidados(1L);
		assertNotNull(dto);
	}
	
	@Test
	public void deveExcluirConvidadosComSucesso() {
		service.excluirConvidados(1L);		
	}	


}
