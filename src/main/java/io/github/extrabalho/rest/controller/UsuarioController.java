package io.github.extrabalho.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.extrabalho.config.security.TokenService;
import io.github.extrabalho.domain.entity.Usuario;
import io.github.extrabalho.rest.dto.LoginResponseDTO;
import io.github.extrabalho.rest.dto.UsuarioDTO;
import io.github.extrabalho.service.impl.UsuarioServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl service;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid UsuarioDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
		var auth = authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((Usuario) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvar(@RequestBody Usuario usuario) {
		return service.salvar(usuario);
	}
	
	@PostMapping("/{usuarioId}/role/{roleId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@PathVariable Integer usuarioId,
					@PathVariable Integer roleId) {
		service.salvarMuitos(usuarioId, roleId);
	}
}
