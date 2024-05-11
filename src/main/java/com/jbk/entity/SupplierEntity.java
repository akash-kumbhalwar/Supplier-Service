package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supplier")
public class SupplierEntity {
	
	@Id
	private long supplierId;
	
	@Column(nullable = false, unique = true)
	private String supplierName;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private int postalCode;
	
	@Column(nullable = false)
	private String Country;
	
	@Column(nullable = false, unique = true)
	private String mobile;
	
	
	public SupplierEntity() {
		
		super();	
	}
	
	
	public SupplierEntity(long supplierId, String supplierName, String city, int postalCode, String country,
			String mobile) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.city = city;
		this.postalCode = postalCode;
		Country = country;
		this.mobile = mobile;
	}
	
	
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Override
	public String toString() {
		return "supplierModel [supplierId=" + supplierId + ", supplierName=" + supplierName + ", city=" + city
				+ ", postalCode=" + postalCode + ", Country=" + Country + ", mobile=" + mobile + "]";
	}
	
	

}
