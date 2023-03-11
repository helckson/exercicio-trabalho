package io.github.extrabalho.domain.mapper;

import io.github.extrabalho.domain.entity.Pessoa;
import io.github.extrabalho.rest.dto.PessoaDTO;

public class PessoaMapper {

	public static Pessoa from(PessoaDTO dto) {
		Pessoa pessoa = Pessoa
						.builder()
						.nome(dto.getNome())
						.cpf(dto.getCpf())
						.build();
		
		return pessoa;		
	}
}
