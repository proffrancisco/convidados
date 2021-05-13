package br.com.fiap.convidados.service;

import java.util.List;

import br.com.fiap.convidados.dto.ConvidadosDto;

public interface ConvidadosService {

	ConvidadosDto salvarConvidados(ConvidadosDto convidadoDto);
	
	List<ConvidadosDto> listarConvidados();
	
	ConvidadosDto editarConvidados(Long id);
	
	void excluirConvidados(Long id);
	
}
