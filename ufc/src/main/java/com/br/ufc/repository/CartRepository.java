package com.br.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.ufc.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
