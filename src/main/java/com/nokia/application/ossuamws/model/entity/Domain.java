package com.nokia.application.ossuamws.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Domain")
public class Domain  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8302840657847442763L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="domain_id")
	private Integer domainId;
	
	@Column(name="domain_name")
	private String domainName;
	
	@Column(name="is_active")
	private Integer isActive;
	
	public Integer getDomainId() {
		return domainId;
	}
	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	
	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	
	
}
/* 
DId	DomainName

0	--Select--
1	RAN
2	PS-CORE
3	CS-CORE
4	TXN
5	NPO
6	PM
7	Ericsson CSR
8	Ericsson project
9	Airtel Customer
10	OSS
11	Nokia Project*/