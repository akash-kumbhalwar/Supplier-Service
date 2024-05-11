package com.jbk.dao;

import com.jbk.entity.SupplierEntity;
import com.jbk.model.SupplierModel;

public interface SupplierDao {
	
	public boolean addSupplier(SupplierEntity supplierEntity);
	
	public SupplierEntity getSupplierById(long supplierId);
	
	public boolean deleteSupplierById(long supplierId);
	
	public boolean updateSupplier(SupplierEntity supplierEntity);

}
