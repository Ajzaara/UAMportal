package com.nokia.application.ossuamws.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vendor")
public class Vendor  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8510284003370574020L;
	
	
	@Id
	@Column(name="vendor_id")
	private Integer vendorId;
	
	@Column(name="vendor_name")
	private String vendorName;
	
	//onetoone mapping with operator
	@Column(name="operator_id")
	private Integer operatorId;
	
	@Column(name="is_Active")
	private Integer isActive;
	
	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Integer getOpId() {
		return operatorId;
	}

	public void setOpId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public Vendor(Integer vendorId, String vendorName, Integer operatorId) {
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.operatorId = operatorId;
	}

	public Vendor() {
	}

	public Vendor(Integer vendorId) {
		this.vendorId = vendorId;
	}	
	 
}
