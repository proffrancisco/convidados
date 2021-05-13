package br.com.fiap.convidados.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.convidados.dto.ConvidadosDto;
import br.com.fiap.convidados.entity.ConvidadosEntity;
import br.com.fiap.convidados.service.ConvidadosService;

@Controller
public class ConvidadosController {

	@Autowired
	private ConvidadosService service; 
	

	@PostMapping("/convidados")
	public String salvarConvidados(@Valid ConvidadosDto convidadoDto, BindingResult result) {
		
		if(!result.hasErrors()) {
			service.salvarConvidados(convidadoDto);	
			return "redirect:/convidados";
		}			
		
		return "redirect:/convidados";
	}

	@GetMapping("/convidados")
	public ModelAndView listar() {

		ModelAndView view = new ModelAndView("convidados/ListaConvidados");

		List<ConvidadosDto> convidados = service.listarConvidados();
		
		view.addObject("convidado", new ConvidadosEntity());

		view.addObject("convidados", convidados);

		return view;
	}
	
	@GetMapping("/convidados/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		
		ConvidadosDto convidado = service.editarConvidados(id);	
		
		ModelAndView view = new ModelAndView("convidados/editar-convidado");

		view.addObject("convidado", convidado);		

		return view;
	}
	
	@GetMapping("/convidados/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		
		service.excluirConvidados(id);			
			
		return "redirect:/convidados";
	}

}
