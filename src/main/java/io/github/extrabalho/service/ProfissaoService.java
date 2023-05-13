package io.github.extrabalho.service;

import io.github.extrabalho.domain.entity.Profissao;
import io.github.extrabalho.rest.dto.ProfissaoDTO;

public interface ProfissaoService {

	Profissao salvar(ProfissaoDTO dto);
	
	void deletar(Integer id);
}
