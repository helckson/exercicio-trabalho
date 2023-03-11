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
public class PessoaDTO {

	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@NotNull(message = "{campo.cpf.obrigatorio}")
	private Integer cpf;
}
