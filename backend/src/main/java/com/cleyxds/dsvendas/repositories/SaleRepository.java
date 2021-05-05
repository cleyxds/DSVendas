package com.cleyxds.dsvendas.repositories;

import com.cleyxds.dsvendas.entities.Sale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
  
}
