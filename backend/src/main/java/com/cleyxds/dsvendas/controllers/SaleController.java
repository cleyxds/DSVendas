package com.cleyxds.dsvendas.controllers;

import com.cleyxds.dsvendas.dto.SaleDTO;
import com.cleyxds.dsvendas.services.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
  
  @Autowired
  private SaleService service;

  @GetMapping
  public ResponseEntity<Page<SaleDTO>> list(Pageable pageable) {
    Page<SaleDTO> list = service.findAll(pageable);

    return ResponseEntity.ok(list);
  }
}
