package com.jbk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.SupplierEntity;
import com.jbk.model.SupplierModel;
import com.jbk.service.SupplierService;

@RestController
@RequestMapping("supplier")
public class SupplierController {
	
	@Autowired
	private SupplierService service;
	
	//1. add supplier
	
	@PostMapping("add-supplier")
	public ResponseEntity<String> addSupplier(@RequestBody @Valid SupplierModel supplierModel){
		
		service.addSupplier(supplierModel);
		
			return ResponseEntity.ok("Supplier Added Successfully..!!");
		
	
	}
	
	@GetMapping("get-supplier-by-id/{supplierId}")
	public ResponseEntity<SupplierModel> getSupplierById(@PathVariable long supplierId){

		   SupplierModel supplierModel = service.getSupplierById(supplierId);
		
		return ResponseEntity.ok(supplierModel);
		
	}
	
	@DeleteMapping("delete-supplier-by-id/{supplierId}")
	public ResponseEntity<String> deleteSupplierById(@PathVariable long supplierId){
		
		service.deleteSupplierById(supplierId);
	
		return ResponseEntity.ok("Supplier deleted successfully");
	
	}
	
	@PutMapping("update-supplier")
	public ResponseEntity<String> updateSupplier(@RequestBody @Valid SupplierModel supplierModel){
		
		service.updateSupplier(supplierModel);
		
		return ResponseEntity.ok("Supplier Updated Successfully..!!");
		
		
	}
	

}
