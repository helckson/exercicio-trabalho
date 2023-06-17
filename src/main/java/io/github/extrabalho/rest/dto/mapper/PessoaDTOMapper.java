package io.github.extrabalho.rest.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import io.github.extrabalho.domain.entity.Pessoa;
import io.github.extrabalho.rest.dto.PessoaDTO;

public class PessoaDTOMapper {

	public static PessoaDTO from(Pessoa pessoa) {
		PessoaDTO PessoaDto = PessoaDTO
								.builder()
								.nome(pessoa.getNome())
								.cpf(pessoa.getCpf())
								.build();
		
		return PessoaDto;						
	}
	
	public static List<PessoaDTO> fromList(List<Pessoa> pessoa) {
		List<PessoaDTO> lista = new ArrayList<>();
		
		for(Pessoa p : pessoa) {
			PessoaDTO dto = PessoaDTO
								.builder()
								.nome(p.getNome())
								.cpf(p.getCpf())
								.build();
			lista.add(dto);
		}
		return lista;
		
//		List<PessoaDTO> list = pessoa.stream().map(PessoaDTOMapper::from).collect(Collectors.toList());
//		return list;
		
	}
}
