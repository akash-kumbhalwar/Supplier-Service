package com.jbk.service;

import org.springframework.http.ResponseEntity;

import com.jbk.model.SupplierModel;

public interface SupplierService {
	
	public boolean addSupplier(SupplierModel supplierModel);

	public SupplierModel getSupplierById(long supplierId);
	
	public boolean deleteSupplierById(long supplierId);
	
	public boolean updateSupplier(SupplierModel supplierModel);

}
