package io.github.extrabalho.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.extrabalho.domain.entity.Ocupacao;
import io.github.extrabalho.rest.dto.OcupacaoDTO;
import io.github.extrabalho.service.impl.OcupacaoServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ocupacao")
public class OcupacaoController {

	@Autowired
	private OcupacaoServiceImpl service;
	
	@GetMapping(value = "/{id}")
	public OcupacaoDTO findById(@PathVariable Integer id) {
		return service.findByid(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Ocupacao save(@RequestBody @Valid OcupacaoDTO dto) {
		return service.salvar(dto);
	}
	
	@PostMapping("/{ocupacaoId}/profissao/{profissaoId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@PathVariable Integer ocupacaoId,
					@PathVariable Integer profissaoId) {
		service.salvarMuitos(ocupacaoId, profissaoId);
	}
	
	@DeleteMapping("/{ocupacaoId}/profissao/{profissaoId}")
	public void delete(@PathVariable Integer ocupacaoId,
			@PathVariable Integer profissaoId) {
		service.deletarMuitos(ocupacaoId, profissaoId);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@PutMapping("/{id}")
	public Ocupacao update(@PathVariable Integer id, 
			@RequestBody @Valid OcupacaoDTO dto) {
		return service.update(id, dto);
	}
}
