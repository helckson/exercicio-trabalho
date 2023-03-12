package io.github.extrabalho.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.github.extrabalho.domain.entity.Ocupacao;
import io.github.extrabalho.domain.entity.Pessoa;
import io.github.extrabalho.domain.mapper.OcupacaoMapper;
import io.github.extrabalho.domain.repository.OcupacaoRepository;
import io.github.extrabalho.domain.repository.PessoaRepository;
import io.github.extrabalho.exception.PessoaNaoEncontradaException;
import io.github.extrabalho.rest.dto.OcupacaoDTO;
import io.github.extrabalho.rest.dto.mapper.OcupacaoDTOMapper;
import io.github.extrabalho.service.OcupacaoService;

@Service
public class OcupacaoServiceImpl implements OcupacaoService{

	@Autowired
	private PessoaRepository pRepository;
	
	@Autowired
	private OcupacaoRepository oRepository;
	
	@Override
	public Ocupacao salvar(OcupacaoDTO dto) {
		Pessoa pessoa = getPessoa(dto.getIdPessoa());
		
		Ocupacao ocupacao = OcupacaoMapper.from(dto);
		ocupacao.setPessoa(pessoa);
		
		Ocupacao o = oRepository.save(ocupacao);
		return o;
	}

	@Override
	public Pessoa getPessoa(Integer id) {
		Optional<Pessoa> pessoa = pRepository.findById(id);
		if(!pessoa.isPresent()) {
			throw new PessoaNaoEncontradaException("Não Encontrada");
		}
		return pessoa.get();
	}

	@Override
	public OcupacaoDTO findByid(Integer id) {
		Ocupacao ocupacao = oRepository.findById(id)
				.orElseThrow(() -> new PessoaNaoEncontradaException("Nao encontrada"));
		OcupacaoDTO dto = OcupacaoDTOMapper.converter(ocupacao);
		return dto;
		
	}

	@Override
	public void delete(Integer id) {
		Optional<Ocupacao> ocupacao = oRepository.findById(id);
		Ocupacao o = ocupacao.get();
		if(ocupacao.isPresent()) {
			oRepository.delete(o);
		}
		else 
			new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Ocupacao não encontrada");
	}

	@Override
	public Ocupacao update(Integer id, OcupacaoDTO dto) {
		Pessoa pessoa = getPessoa(id);
		Ocupacao o = OcupacaoMapper.from(dto);
		o.setId(pessoa.getId());
		o.setPessoa(pessoa);
		return oRepository.save(o);
		
	}
}
