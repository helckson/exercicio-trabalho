package io.github.extrabalho.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.extrabalho.domain.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
