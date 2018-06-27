package com.br.ufc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.br.ufc.model.Pessoa;
import com.br.ufc.repository.PessoaRepository;
import com.br.ufc.model.Role;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public void adicionarPessoa(Pessoa pessoa) {
		String teste = new BCryptPasswordEncoder().encode(pessoa.getSenha());
		System.out.println(teste);
		pessoa.setSenha(teste);
		Role role = new Role();
		role.setPapel("ROLE_USER");
		pessoa.setRoles(Arrays.asList(role));
		pessoaRepository.save(pessoa);
	}
	

	public List<Pessoa> retornarTodasAsPessoas() {
		
		return pessoaRepository.findAll();
	}
	
	public Pessoa buscarPorId(String id) {
		return pessoaRepository.getOne(id);
	}


	public void removerPessoa(String id) {
		pessoaRepository.deleteById(id);
		
	}
	

}