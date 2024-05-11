package com.jbk.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.SupplierDao;
import com.jbk.entity.SupplierEntity;
import com.jbk.exception.ResourceAlreadyExistException;
import com.jbk.exception.ResourceNotExistException;
import com.jbk.exception.SomethingWentWrongException;
import com.jbk.model.SupplierModel;

@Repository
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	//1. Add Supplier
	//2. something went wrong during add supplier
	@Override
	public boolean addSupplier(SupplierEntity supplierEntity) {
		boolean isAdded=false;
		try {
			Session session = sessionFactory.openSession();
			
			SupplierEntity dbEntity = getSupplierById(supplierEntity.getSupplierId());
			if(dbEntity == null) {
				session.save(supplierEntity); //insert into
				session.beginTransaction().commit();
				isAdded=true;
			}else {
				throw new ResourceAlreadyExistException("supplier already exist with id:-"+supplierEntity.getSupplierId());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something went wrong in during add supplier");
		}
	
		return isAdded;
	}

	@Override
	public SupplierEntity getSupplierById(long supplierId) {
		SupplierEntity supplierEntity=null;
		try {
		Session session = sessionFactory.openSession();
		 supplierEntity = session.get(SupplierEntity.class, supplierId);
		session.beginTransaction().commit();
		}catch(HibernateException e) {
			throw new SomethingWentWrongException("Connection Failure");
		}
		return supplierEntity;
	}

	@Override
	public boolean deleteSupplierById(long supplierId) {
		boolean isDeleted = false;
		try {
			Session session = sessionFactory.openSession();
			
			SupplierEntity supplierEntity = session.get(SupplierEntity.class, supplierId);
			
			if(supplierEntity != null) {
				session.delete(supplierEntity);
				session.beginTransaction().commit();
				isDeleted=true;
			}else {
				throw new ResourceNotExistException("Supplier not exist with Id:-"+supplierId);
			}
			} catch(ResourceNotExistException e) {
				throw new ResourceNotExistException("Supplier not exist with Id:-"+supplierId);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Sonething Went Wrong during deleting:-"+supplierId);
		}
		return isDeleted;
	}

	//update Supplier
	//1 supplier is update
	//2 supplier not found
	//3 something went wrong during update
	@Override
	public boolean updateSupplier(SupplierEntity supplierEntity) {
		boolean isUpdated=false;
		try {
			Session session = sessionFactory.openSession();
			
			SupplierEntity dbSupplier = getSupplierById(supplierEntity.getSupplierId());
			
			if(dbSupplier!=null) {
			session.update(supplierEntity);
			session.beginTransaction().commit();
			isUpdated=true;
			
		}else {
			throw new ResourceNotExistException("Supplier not found to update:"+supplierEntity.getSupplierId());
		}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something Went Wrong during update supplier");
		}
		
		return isUpdated ;
	}

}
