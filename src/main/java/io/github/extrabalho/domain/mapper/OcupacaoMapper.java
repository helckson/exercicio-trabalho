package io.github.extrabalho.domain.mapper;

import io.github.extrabalho.domain.entity.Ocupacao;
import io.github.extrabalho.rest.dto.OcupacaoDTO;

public class OcupacaoMapper {

	public static Ocupacao from(OcupacaoDTO dto) {
		Ocupacao ocupacao = Ocupacao
								.builder()
								.empresa(dto.getNomeEmpresa())
								.anoInicio(dto.getInicio())
								.salario(dto.getSalario())
								.build();
		
		return ocupacao;
	}
}
