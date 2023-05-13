package io.github.extrabalho.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.extrabalho.domain.entity.Profissao;
import io.github.extrabalho.rest.dto.ProfissaoDTO;

public class ProfissaoMapper {

	public static Profissao from(ProfissaoDTO dto) {
		Profissao profissao = Profissao
								.builder()
								.profissao(dto.getProfissao())
								.build();
		
		return profissao;
	}
	
	public static List<Profissao> fromList(List<ProfissaoDTO> dto) {
		List<Profissao> profissao = new ArrayList<>();
		
		for(ProfissaoDTO pd : dto) {
			Profissao p = Profissao
							.builder()
							.profissao(pd.getProfissao())
							.build();
			
			profissao.add(p);
		}
		return profissao;
	}

}
