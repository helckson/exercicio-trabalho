package io.github.extrabalho.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.extrabalho.domain.entity.Pessoa;
import io.github.extrabalho.rest.dto.InformacaoCompletaDTO;
import io.github.extrabalho.rest.dto.PessoaDTO;
import io.github.extrabalho.service.impl.PessoaServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

	@Autowired
	private PessoaServiceImpl service;
	
	@GetMapping
	public List<InformacaoCompletaDTO> findAll() {
		return service.getPessoas();
	}
	
	@GetMapping("/byNome")
	public List<PessoaDTO> findByName(@RequestParam("nome") String nome) {
		return service.procurarPorNome(nome);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/{id}")
	public InformacaoCompletaDTO findById(@PathVariable Integer id) {
		return service.getPessoa(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa save(@RequestBody @Valid PessoaDTO dto) {
		return service.salvar(dto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@PutMapping("/{id}")
	public Pessoa update(@PathVariable Integer id,
			@RequestBody @Valid PessoaDTO dto) {
		return service.update(id, dto);
	}
	
}
