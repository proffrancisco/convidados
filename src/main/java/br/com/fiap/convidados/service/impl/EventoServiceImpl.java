package br.com.fiap.convidados.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.convidados.dto.EventoDto;
import br.com.fiap.convidados.entity.EventoEntity;
import br.com.fiap.convidados.repository.EventoRepository;
import br.com.fiap.convidados.service.EventoService;
@Service
public class EventoServiceImpl implements EventoService{

	@Autowired
	EventoRepository repository;
	
	@Override
	public List<EventoDto> listaEvento() {
		List<EventoEntity> eventosEntity = repository.findAll();
		List<EventoDto> eventos = fromToEventoDto(eventosEntity);
		return eventos;
	}

	private List<EventoDto> fromToEventoDto(List<EventoEntity> eventosEntity) {
		List<EventoDto> lista = new ArrayList<>();
		for(EventoEntity entity :eventosEntity) {
		ModelMapper mapper = new ModelMapper();
		EventoDto dto = mapper.map(entity, EventoDto.class);
		lista.add(dto);		
		}
		return lista;
	}
}
