package br.com.fiap.convidados.dto;

import javax.validation.constraints.NotBlank;

import br.com.fiap.convidados.entity.ConvidadosEntity;

public class ConvidadosDto {

	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	private String email;

	@NotBlank
		private String acompanhante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(String acompanhante) {
		this.acompanhante = acompanhante;
	}
	
	public ConvidadosEntity toEntity() {
		ConvidadosEntity entity = new ConvidadosEntity();
		entity.setId(this.id);
		entity.setEmail(this.email);
		entity.setNome(this.nome);
		entity.setAcompanhante(this.acompanhante);
		return entity;
	}
	

}
