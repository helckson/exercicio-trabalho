package io.github.extrabalho.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.extrabalho.domain.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

	List<Pessoa> findByNomeContainingIgnoreCase(String nome);
}
