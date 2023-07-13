package io.github.extrabalho.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import io.github.extrabalho.domain.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	UserDetails findByUsername(String username);
}
