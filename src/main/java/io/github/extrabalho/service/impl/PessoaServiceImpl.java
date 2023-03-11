package io.github.extrabalho.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.github.extrabalho.domain.entity.Pessoa;
import io.github.extrabalho.domain.mapper.PessoaMapper;
import io.github.extrabalho.domain.repository.PessoaRepository;
import io.github.extrabalho.exception.PessoaNaoEncontradaException;
import io.github.extrabalho.rest.dto.InformacaoCompletaDTO;
import io.github.extrabalho.rest.dto.PessoaDTO;
import io.github.extrabalho.rest.dto.mapper.InformacaoCompletaDTOMapper;
import io.github.extrabalho.rest.dto.mapper.PessoaDTOMapper;
import io.github.extrabalho.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService{

	@Autowired
	private PessoaRepository repository;
	
	@Override
	public Pessoa salvar(PessoaDTO dto) {
		Pessoa pessoa = PessoaMapper.from(dto);
		Pessoa p = repository.save(pessoa);
		return p;
	}

	@Override
	public InformacaoCompletaDTO getPessoa(Integer id) {
		Pessoa pessoa = get(id);
		return InformacaoCompletaDTOMapper.from(pessoa);
	}

	@Override
	public Pessoa get(Integer id) {
		Optional<Pessoa> pessoa = repository.findById(id);
		if(!pessoa.isPresent()) {
			throw new PessoaNaoEncontradaException("Pessoa nao encontrada");
		}
		return pessoa.get();
	}
	
	@Override
	public PessoaDTO findById(Integer id) {
		Pessoa pessoa = repository.findById(id)
				.orElseThrow(() -> new PessoaNaoEncontradaException("Nao Encontrada"));
		PessoaDTO dto = PessoaDTOMapper.from(pessoa);
		return dto;
	}

	@Override
	public List<InformacaoCompletaDTO> getPessoas() {
		List<Pessoa> pessoas = repository.findAll();
		return InformacaoCompletaDTOMapper.fromList(pessoas);
	}

	@Override
	public void delete(Integer id) {
		Optional<Pessoa> p = repository.findById(id);
		Pessoa pessoa = p.get();
		if(p.isPresent()) {
			repository.delete(pessoa);
		}
		else 
			new ResponseStatusException(HttpStatus.NOT_FOUND, "Nao encontrado");
	}

	@Override
	public Pessoa update(Integer id, PessoaDTO dto) {
		Pessoa pessoa = get(id);		
		Pessoa p = PessoaMapper.from(dto);
		p.setId(pessoa.getId());
		return repository.save(p);
	}	
}
