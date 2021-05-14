package br.com.fiap.convidados.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.convidados.dto.ConvidadosDto;
import br.com.fiap.convidados.service.ConvidadosService;

@RunWith(MockitoJUnitRunner.class)
public class ConvidadosControllerTests {
	
	@InjectMocks
	private ConvidadosController controller;
	
	
	 @Mock 
	 private ConvidadosService service;
	 
	@Test
	public void deveRetornaPaginaListaConvidadosComSucesso() {
		List<ConvidadosDto> lista = new ArrayList<>();
		when(service.listarConvidados()).thenReturn(lista);		
		ModelAndView view = controller.listar();
		assertEquals("convidados/ListaConvidados", view.getViewName());
	}
	
	@Test
	public void deveExcluirConvidadoComSucesso() {			
		String redirect = controller.excluir(1L);
		assertEquals("redirect:/convidados", redirect);
	}
	
	@Test
	public void deveSalvarConvidadosComSucesso() {	
		BindingResult result = mock(BindingResult.class);
		when(result.hasErrors()).thenReturn(false);
		when(service.salvarConvidados(new ConvidadosDto())).thenReturn(new ConvidadosDto());
		String redirect = controller.salvarConvidados(new ConvidadosDto() , result);
		assertEquals("redirect:/convidados", redirect);		
	}
	
	@Test
	public void deveSalvarConvidadosComErro() {	
		BindingResult result = mock(BindingResult.class);
		when(result.hasErrors()).thenReturn(true);
		when(service.salvarConvidados(new ConvidadosDto())).thenReturn(new ConvidadosDto());
		String redirect = controller.salvarConvidados(new ConvidadosDto() , result);
		assertEquals("redirect:/erro", redirect);		
	}
	
	@Test
	public void deveEditarConvidados() {			
		when(service.editarConvidados(1L)).thenReturn(new ConvidadosDto());
		ModelAndView wiew = controller.editar(1L);
		assertEquals("convidados/editar-convidado", wiew.getViewName());		
	}

}
