package dev.carlosandrade.microservice.investimento.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carteira {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Long user_id;

	@Transient
	private String userName;


	@Enumerated(EnumType.STRING)
	private TipoMoeda tipoMoeda;
	
	private String nome;
	
	private String descricao;
	
	@Positive
	private Long total;

}
