package io.github.extrabalho.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.extrabalho.domain.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
