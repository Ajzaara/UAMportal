package com.nokia.application.ossuamws.model.Request;

import com.nokia.application.ossuamws.model.entity.Domain;

public class ManagerRequest {
	private Integer managerId;
	private String name;
	private Long mobile;
	private String mailId;
	private Domain domainId;
	
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
	public Domain getDomainId() {
		return domainId;
	}
	public void setDomainId(Domain domainId) {
		this.domainId = domainId;
	}
	

}
