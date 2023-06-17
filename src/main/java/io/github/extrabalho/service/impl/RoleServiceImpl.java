package io.github.extrabalho.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.extrabalho.domain.entity.Role;
import io.github.extrabalho.domain.repository.RoleRepository;

@Service
public class RoleServiceImpl {

	@Autowired
	RoleRepository repository;
	
	public Role criar(Role role) {
		return repository.save(role);
	}
}
