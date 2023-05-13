package io.github.extrabalho.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.extrabalho.domain.entity.Ocupacao;
import io.github.extrabalho.rest.dto.OcupacaoDTO;

public class OcupacaoDTOMapper {

	public static OcupacaoDTO converter(Ocupacao ocupacao) {
		OcupacaoDTO dto = OcupacaoDTO
							.builder()
							.idPessoa(ocupacao.getPessoa().getId())
							.nomeEmpresa(ocupacao.getEmpresa())
							.inicio(ocupacao.getAnoInicio())
							.salario(ocupacao.getSalario())
							.build();
		
		return dto;							
	}
	
	public static List<OcupacaoDTO> converterLista(List<Ocupacao> ocupacao) {
		List<OcupacaoDTO> lista = new ArrayList<>();
		
		for(Ocupacao o : ocupacao) {
			OcupacaoDTO dto = OcupacaoDTO
					.builder()
					.nomeEmpresa(o.getEmpresa())
					.inicio(o.getAnoInicio())
					.salario(o.getSalario())
					.idPessoa(o.getPessoa().getId())
					.listaProfissoes(ProfissaoDTOMapper.converterLista(o.getProfissoes()))
					.build();
			
			lista.add(dto);
		}
		return lista;
	}
}
