package com.cleyxds.dsvendas.repositories;

import com.cleyxds.dsvendas.entities.Seller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
  
}
