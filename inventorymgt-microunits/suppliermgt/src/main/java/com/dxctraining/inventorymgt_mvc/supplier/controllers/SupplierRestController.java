package com.dxctraining.inventorymgt_mvc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.inventorymgt_mvc.supplier.dto.CreateSupplierRequest;
import com.dxctraining.inventorymgt_mvc.supplier.dto.UpdateSupplierRequest;
import com.dxctraining.inventorymgt_mvc.supplier.entities.Supplier;
import com.dxctraining.inventorymgt_mvc.supplier.service.ISupplierService;



@RestController
@RequestMapping("/suppliers")
public class SupplierRestController {
	
	@Autowired
	private ISupplierService service;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Supplier createSupplier(@RequestBody CreateSupplierRequest supplier) {
		Supplier supplier1 = new Supplier(supplier.getName(), supplier.getPassword());
		supplier1 = service.add(supplier1);
		return supplier1;	
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Supplier getSupplier(@PathVariable("id")int id) {
		Supplier supplier1 = service.findSupplierById(id);
		return supplier1;
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Supplier updateSupplier(@RequestBody UpdateSupplierRequest supplier) {
		Supplier supplier1 = new Supplier(supplier.getName(),supplier.getPassword());
		supplier1.setId(supplier.getId());
		return service.update(supplier1);
	
	}

	
}