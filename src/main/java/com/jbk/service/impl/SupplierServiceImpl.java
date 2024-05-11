package com.jbk.service.impl;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.SupplierDao;
import com.jbk.entity.SupplierEntity;
import com.jbk.exception.ResourceNotExistException;
import com.jbk.model.SupplierModel;
import com.jbk.service.SupplierService;



@Service
public class SupplierServiceImpl implements SupplierService {



	@Autowired
	private SupplierDao dao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public boolean addSupplier(SupplierModel supplierModel) {

		SupplierEntity supplierEntity = mapper.map(supplierModel, SupplierEntity.class);


		boolean isAdded = dao.addSupplier(supplierEntity); 

		return isAdded;
	}

	@Override
	public SupplierModel getSupplierById(long supplierId) {

		SupplierEntity supplierEntity = dao.getSupplierById(supplierId);

		if(supplierEntity != null) {

			SupplierModel supplierModel = mapper.map(supplierEntity, SupplierModel.class);
			return supplierModel;
		}else {
			throw new ResourceNotExistException("Supplier Not Exist with Id:-"+supplierId);
		}
	}

	@Override
	public boolean deleteSupplierById(long supplierId) {

		boolean supplierEntity = dao.deleteSupplierById(supplierId);

		SupplierModel map = mapper.map(supplierEntity, SupplierModel.class);

		return supplierEntity;
	}

	@Override
	public boolean updateSupplier(SupplierModel supplierModel) {

		SupplierEntity supplierEntity = mapper.map(supplierModel, SupplierEntity.class);



		return dao.updateSupplier(supplierEntity);
	}

}
