package com.cleyxds.dsvendas.services;

import java.util.List;

import com.cleyxds.dsvendas.dto.SaleDTO;
import com.cleyxds.dsvendas.dto.SaleSuccessDTO;
import com.cleyxds.dsvendas.dto.SaleSumDTO;
import com.cleyxds.dsvendas.entities.Sale;
import com.cleyxds.dsvendas.repositories.SaleRepository;
import com.cleyxds.dsvendas.repositories.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {
  
  @Autowired
  private SaleRepository repository;

  @Autowired
  private SellerRepository sellerRepository;

  @Transactional(readOnly = true)
  public Page<SaleDTO> findAll(Pageable pageable) {
    sellerRepository.findAll();
    Page<Sale> sales = repository.findAll(pageable);

    return sales
      .map(sale -> new SaleDTO(sale));
  }

  @Transactional(readOnly = true)
  public List<SaleSumDTO> amountGroupedBySeller() {
    return repository.amountGroupedBySeller();
  }

  @Transactional(readOnly = true)
  public List<SaleSuccessDTO> successGroupedBySeller() {
    return repository.successGroupedBySeller();
  }
}
