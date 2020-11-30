package com.nokia.application.ossuamws.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="operator_details")

public class OperatorDetails implements Serializable{
	
	private static final long serialVersionUID = 4834923696272026656L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer Id;
	
	@OneToOne
	@JoinColumn(name="emp_id") 
	private EmployeePersonalInfo empId;
	
	@OneToOne
	@JoinColumn(name="operator_id") 
	private Operator operatorId;
	
	@Column(name="oss_type")
	private String ossType;
	
	@OneToOne
	@JoinColumn(name="vendor_id") 
	private Vendor vendorId;
	
	@OneToMany
	@JoinColumn(name="circle_id") 
	private Set<Circles> circleId = new HashSet<Circles>();
	
	@OneToMany
	@JoinColumn(name="oss_id") 
	private Set<OSS> ossId = new HashSet<OSS>();
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	public Operator getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Operator operatorId) {
		this.operatorId = operatorId;
	}
	
	public Vendor getVendorId() {
		return vendorId;
	}
	public void setVendorId(Vendor vendorId) {
		this.vendorId = vendorId;
	}
	
	
	public String getOssType() {
		return ossType;
	}
	public void setOssType(String ossType) {
		this.ossType = ossType;
	}
	public Set<Circles> getCircleId() {
		return circleId;
	}
	public void setCircleId(Set<Circles> circleId) {
		this.circleId = circleId;
	}
	public Set<OSS> getOssId() {
		return ossId;
	}
	public void setOssId(Set<OSS> ossId) {
		this.ossId = ossId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public EmployeePersonalInfo getEmpId() {
		return empId;
	}
	public void setEmpId(EmployeePersonalInfo empId) {
		this.empId = empId;
	}
	
	public OperatorDetails(Integer id, EmployeePersonalInfo empId, Operator operatorId, String ossType, Vendor vendorId,
			Set<Circles> circleId, Set<OSS> ossId) {
		this.Id = id;
		this.empId = empId;
		this.operatorId = operatorId;
		this.ossType = ossType;
		this.vendorId = vendorId;
		this.circleId = circleId;
		this.ossId = ossId;
	}
	public OperatorDetails() {
	}
	

	
}
