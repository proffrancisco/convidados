package br.com.fiap.convidados.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.convidados.dto.ConvidadosDto;
import br.com.fiap.convidados.entity.ConvidadosEntity;
import br.com.fiap.convidados.repository.ConvidadosRepository;
import br.com.fiap.convidados.service.ConvidadosService;

@Service
public class ConvidadosServiceImpl implements ConvidadosService{
	
	@Autowired
	ConvidadosRepository repository;	

	@Override
	public ConvidadosDto salvarConvidados(ConvidadosDto convidadoDto) {		
		ConvidadosEntity entity = convidadoDto.toEntity();		
		entity =  repository.save(entity);
		ConvidadosDto convidadosDto = fromConvidadosEntityToConvidadosDto(entity);
		return convidadosDto;
	}
	

	@Override
	public List<ConvidadosDto> listarConvidados() {	
		
		List<ConvidadosEntity> listaConvidadosEntity = repository.findAll(); 
		
		List<ConvidadosDto> listaConvidadosDto = fromConvidadosEntityToConvidadosDto(listaConvidadosEntity);
		
		return listaConvidadosDto;
	}

	@Override
	public ConvidadosDto editarConvidados(Long id) {
		
		ConvidadosEntity entity = repository.findById(id).get();
		
		ConvidadosDto convidadoDto = fromConvidadosEntityToConvidadosDto(entity);
		
		return convidadoDto;
	}

	@Override
	public void excluirConvidados(Long id) {
		repository.deleteById(id);	
	}
	
	private ConvidadosDto fromConvidadosEntityToConvidadosDto(ConvidadosEntity entity) {
		ConvidadosDto dto = new ConvidadosDto();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setEmail(entity.getEmail());
		dto.setAcompanhante(entity.getAcompanhante());		
		return dto;
	}
	
	private List<ConvidadosDto> fromConvidadosEntityToConvidadosDto(List<ConvidadosEntity> listaEntity) {		
		List<ConvidadosDto> listaConvidadoDto = new ArrayList<>();
		
		for (ConvidadosEntity convidadosEntity : listaEntity) {
			ConvidadosDto dto = new ConvidadosDto();			
			dto.setId(convidadosEntity.getId());
			dto.setNome(convidadosEntity.getNome());
			dto.setEmail(convidadosEntity.getEmail());
			dto.setAcompanhante(convidadosEntity.getAcompanhante());	
			
			listaConvidadoDto.add(dto);
		}			
		return listaConvidadoDto;
	}

}
