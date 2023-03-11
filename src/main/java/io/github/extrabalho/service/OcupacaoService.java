package io.github.extrabalho.service;

import io.github.extrabalho.domain.entity.Ocupacao;
import io.github.extrabalho.domain.entity.Pessoa;
import io.github.extrabalho.rest.dto.OcupacaoDTO;

public interface OcupacaoService {

	Ocupacao salvar(OcupacaoDTO dto);
	
	Pessoa getPessoa(Integer id);
	
	OcupacaoDTO findByid(Integer id);
	
	void delete(Integer id);
	
	Ocupacao update(Integer id, OcupacaoDTO dto);
	
	Ocupacao get(Integer id);
}
