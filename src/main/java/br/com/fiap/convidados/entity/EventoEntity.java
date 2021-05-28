package br.com.fiap.convidados.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_evento")
public class EventoEntity {
	
	@Id
	@Column(name= "id_evento")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEG_EVENTO")
	@SequenceGenerator(name = "SEG_EVENTO",sequenceName = "SEG_EVENTO",initialValue = 1)
	private Long id;
	
	private String descricao;
	
	@OneToMany(mappedBy = "evento")
	private List<ConvidadosEntity> convidados;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ConvidadosEntity> getConvidados() {
		return convidados;
	}

	public void setConvidados(List<ConvidadosEntity> convidados) {
		this.convidados = convidados;
	}

	

}
