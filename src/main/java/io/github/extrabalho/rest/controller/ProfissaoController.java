package io.github.extrabalho.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.extrabalho.domain.entity.Profissao;
import io.github.extrabalho.rest.dto.ProfissaoDTO;
import io.github.extrabalho.service.impl.ProfissaoServiceImpl;

@RestController
@RequestMapping("/api/profissao")
public class ProfissaoController {

	@Autowired
	private ProfissaoServiceImpl service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Profissao save(@RequestBody ProfissaoDTO dto) {
		return service.salvar(dto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.deletar(id);
	}
	
}
