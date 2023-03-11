package io.github.extrabalho.rest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacaoCompletaDTO {

	private Integer codigo;
	private String nome;
	private Integer cpf;
	private List<OcupacaoDTO> listagem;
}
