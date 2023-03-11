package io.github.extrabalho.rest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OcupacaoDTO {

	@NotEmpty(message = "{campo.nome-empresa.obrigatorio}")
	private String nomeEmpresa;
	
	@NotNull(message = "{campo.inicio.obrigatorio}")
	private Integer inicio;
	
	@NotNull(message = "{campo.salario.obrigatorio}")
	private Integer salario;
	
	@NotNull(message = "{campo.id-pessoa.obrigatorio}")
	private Integer idPessoa;
}
