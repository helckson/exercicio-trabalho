package io.github.extrabalho.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.github.extrabalho.domain.entity.Ocupacao;
import io.github.extrabalho.domain.entity.Profissao;
import io.github.extrabalho.domain.mapper.ProfissaoMapper;
import io.github.extrabalho.domain.repository.OcupacaoRepository;
import io.github.extrabalho.domain.repository.ProfissaoRepository;
import io.github.extrabalho.rest.dto.ProfissaoDTO;
import io.github.extrabalho.service.ProfissaoService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProfissaoServiceImpl implements ProfissaoService{

	@Autowired
	private ProfissaoRepository repository;
	
//	@Autowired
//	private OcupacaoRepository oRepository;
	
	@Override
	public Profissao salvar(ProfissaoDTO dto) {
	
		Profissao profissao = ProfissaoMapper.from(dto);
		
		return repository.save(profissao);
		
	}

	@Override
	public void deletar(Integer id) {
		Optional<Profissao> profissao = repository.findById(id);
		if(profissao.isPresent()) {
			Profissao p = profissao.get();
			repository.delete(p);
		}else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profissao nao encontrada");
	}

}
