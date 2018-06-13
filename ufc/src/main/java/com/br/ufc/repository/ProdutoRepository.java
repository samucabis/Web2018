package com.br.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.ufc.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
