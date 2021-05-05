package com.cleyxds.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import com.cleyxds.dsvendas.dto.SellerDTO;
import com.cleyxds.dsvendas.entities.Seller;
import com.cleyxds.dsvendas.repositories.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
  
  @Autowired
  private SellerRepository repository;

  public List<SellerDTO> findAll() {
    List<Seller> sellers = repository.findAll();

    return sellers
      .stream()
      .map(seller -> new SellerDTO(seller))
      .collect(Collectors.toList());
  }
}
