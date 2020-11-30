package com.nokia.application.ossuamws.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5479437623081596383L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dept_id")
	private Integer deptId;
	
	@Column(name="dept_name")
	private String deptName;
	
	@Column(name="is_active")
	private Integer isActive;
	
//	@OneToOne( mappedBy="departmentId")
//    private Employee emp;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Department(Integer deptId, String deptName, Integer isActive) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.isActive = isActive;
	}

	public Department() {
	}

	public Department(Integer deptId) {
		this.deptId = deptId;
	}
	
}
/*
CS CORE
FM
BSS FM
BSS
BSS
PM
PM
NPO
PS Core
FM
*/
