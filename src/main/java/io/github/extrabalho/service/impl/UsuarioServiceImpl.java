package io.github.extrabalho.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.extrabalho.config.security.TokenService;
import io.github.extrabalho.domain.entity.Role;
import io.github.extrabalho.domain.entity.Usuario;
import io.github.extrabalho.domain.repository.RoleRepository;
import io.github.extrabalho.domain.repository.UsuarioRepository;
import io.github.extrabalho.rest.dto.LoginResponseDTO;
import io.github.extrabalho.rest.dto.UsuarioDTO;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServiceImpl {

	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	public ResponseEntity<?> login(UsuarioDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
		var auth = authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((Usuario) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	public Usuario salvar(Usuario usuario) {
		String encodedPassword = encoder.encode(usuario.getPassword());
		usuario.setPassword(encodedPassword);
		
		return repository.save(usuario);
	}
	
	public void salvarMuitos(Integer usuarioID, Integer roleId) {
		Usuario usuario = repository.findById(usuarioID)
				.orElseThrow(() -> new EntityNotFoundException("Usuario não encontrada"));
		Role role = roleRepository.findById(roleId)
				.orElseThrow(() -> new EntityNotFoundException("Role não encontrada"));
		
		usuario.getRoles().add(role);
		repository.save(usuario);
	}
}
