package io.github.extrabalho.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ocupacao")
public class Ocupacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "empresa", length = 20)
	private String empresa;
	
	@Column(name = "ano_inicio", length = 5)
	private Integer anoInicio;
	
	@Column(name = "salario", length = 10)
	private Integer salario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pessoa pessoa;
}
