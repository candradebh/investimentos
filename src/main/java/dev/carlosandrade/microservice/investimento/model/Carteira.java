package dev.carlosandrade.microservice.investimento.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Carteira {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long user_id;
		
	@Enumerated(EnumType.STRING)
	private TipoMoeda tipoMoeda;
	
	private String nome;
	
	private String descricao;
	
	private Long total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoMoeda getTipoMoeda() {
		return tipoMoeda;
	}

	public void setTipoMoeda(TipoMoeda tipoMoeda) {
		this.tipoMoeda = tipoMoeda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getUserId() {
		return user_id;
	}

	public void setUserId(Long user_id) {
		this.user_id = user_id;
	}
	
	
	
}
