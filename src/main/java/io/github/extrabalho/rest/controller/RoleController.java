package io.github.extrabalho.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.extrabalho.domain.entity.Role;
import io.github.extrabalho.service.impl.RoleServiceImpl;

@RestController
@RequestMapping("/api/role")
public class RoleController {

	@Autowired
	RoleServiceImpl service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Role criar(@RequestBody Role role) {
		return service.criar(role);
	}
}
