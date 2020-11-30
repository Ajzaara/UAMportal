package com.nokia.application.ossuamws.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="Circle")
public class Circles  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1949332025187567558L;
	
	
	@Id
	@Column(name="circle_id")
	private Integer circleId;	
	
	@Column(name="circle_name")
	private String circleName;	
		
	//onetoone mapping with vendor table
	@Column(name="vendor_id")
	private Integer vendorId;

	@Column(name="is_Active")
	private Integer isActive;
	

//	@ManyToMany(mappedBy = "circleId",fetch = FetchType.LAZY)
//	@Cascade({ CascadeType.SAVE_UPDATE})
//	private Set<EmployeePersonalInfo> emp = new HashSet<EmployeePersonalInfo>();
	
//	@ManyToMany 
//	private OperatorDetails opd;

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Circles(int i) {
		this.circleId = i;
	}

	public Integer getCircleId() {
		return circleId;
	}

	public void setCircleId(Integer circleId) {
		this.circleId = circleId;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}
	
	public Circles() {
		
	}

	public Circles(Integer circleId, String circleName, Integer deletedStatus, Integer opId, Integer vendorId, Integer isActive) {
		this.circleId = circleId;
		this.circleName = circleName;
		this.vendorId = vendorId;
		this.isActive = isActive;
	}

	public Circles(Integer circleId) {
		this.circleId = circleId;
	}
	
}
