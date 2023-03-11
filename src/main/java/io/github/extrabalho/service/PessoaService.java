package io.github.extrabalho.service;

import java.util.List;

import io.github.extrabalho.domain.entity.Pessoa;
import io.github.extrabalho.rest.dto.InformacaoCompletaDTO;
import io.github.extrabalho.rest.dto.PessoaDTO;

public interface PessoaService {
	
	Pessoa salvar(PessoaDTO dto);
	
	Pessoa get(Integer id);
	
	InformacaoCompletaDTO getPessoa(Integer id);
	
	PessoaDTO findById(Integer id);
	
	List<InformacaoCompletaDTO> getPessoas();
	
	void delete(Integer id); 
	
	Pessoa update(Integer id, PessoaDTO dto);
}
