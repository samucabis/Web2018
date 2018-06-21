package com.br.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.ufc.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String>{
	
	Pessoa findByLogin(String login);
}
