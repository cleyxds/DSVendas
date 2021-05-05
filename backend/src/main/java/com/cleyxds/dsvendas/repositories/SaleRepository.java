package com.cleyxds.dsvendas.repositories;

import java.util.List;

import com.cleyxds.dsvendas.dto.SaleSuccessDTO;
import com.cleyxds.dsvendas.dto.SaleSumDTO;
import com.cleyxds.dsvendas.entities.Sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SaleRepository extends JpaRepository<Sale, Long> {
  
  @Query("SELECT new com.cleyxds.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) " 
    + " FROM Sale AS obj GROUP BY obj.seller")
  List<SaleSumDTO> amountGroupedBySeller();

  @Query("SELECT new com.cleyxds.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " 
    + " FROM Sale AS obj GROUP BY obj.seller")
  List<SaleSuccessDTO> successGroupedBySeller();

}
