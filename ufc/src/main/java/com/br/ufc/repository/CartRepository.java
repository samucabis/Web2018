package com.br.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.ufc.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
