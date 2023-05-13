package io.github.extrabalho.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.extrabalho.domain.entity.Profissao;
import io.github.extrabalho.rest.dto.ProfissaoDTO;

public class ProfissaoDTOMapper {

	public static ProfissaoDTO converter(Profissao profissao) {
		ProfissaoDTO dto = ProfissaoDTO
							.builder()
							.profissao(profissao.getProfissao())
							.build();
		
		return dto;
	}
	
	public static List<ProfissaoDTO> converterLista(List<Profissao> profissao) {
		List<ProfissaoDTO> list = new ArrayList<>();
		
		for(Profissao p : profissao) {
			ProfissaoDTO dto = ProfissaoDTO
								.builder()
								.profissao(p.getProfissao())
								.build();
						
			list.add(dto);
		}
		return list;
	}
}
