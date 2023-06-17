package io.github.extrabalho.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.extrabalho.domain.entity.Pessoa;
import io.github.extrabalho.rest.dto.InformacaoCompletaDTO;

public class InformacaoCompletaDTOMapper {

	public static InformacaoCompletaDTO from(Pessoa pessoa) {
		
		var dto = InformacaoCompletaDTO
				.builder()
				.codigo(pessoa.getId())
				.nome(pessoa.getNome())
				.cpf(pessoa.getCpf())
				.listagem(OcupacaoDTOMapper.converterLista(pessoa.getListagem()))
				.build();
		
		return dto;
	}
	
	public static List<InformacaoCompletaDTO> fromList(List<Pessoa> pessoa) {
		if(pessoa == null) {
			return null;
		}
		
		var lista = new ArrayList<InformacaoCompletaDTO>();
		
		for(Pessoa p : pessoa) {
			var InfoCompleta = InformacaoCompletaDTO
					.builder()
					.codigo(p.getId())
					.nome(p.getNome())
					.cpf(p.getCpf())
					.listagem(OcupacaoDTOMapper.converterLista(p.getListagem()))
					.build();
			
			lista.add(InfoCompleta);
		}
		return lista; 
		
//		List<InformacaoCompletaDTO> list = pessoa.stream()
//				.map(InformacaoCompletaDTOMapper::from)
//				.collect(Collectors.toList());
//		return list;
	}
}
