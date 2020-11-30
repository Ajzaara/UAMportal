package com.nokia.application.ossuamws.shared.Dto;

import java.time.LocalDateTime;

import com.nokia.application.ossuamws.model.entity.Domain;

public class ManagerDto {

	private Integer managerId;
	private String name;
	private Long mobile;
	private String mailId;
	private Domain domainId;
	private String secondLevelMgrName;
	private Long secondLevelMgrMobile;
	private String secondLevelMgrMailId;
	private Integer isActive ;
	private LocalDateTime createTimestamp ;
	private LocalDateTime modifyTimestamp ;
	private LocalDateTime deleteTimestamp ;
	
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
	public String getSecondLevelMgrName() {
		return secondLevelMgrName;
	}
	public void setSecondLevelMgrName(String secondLevelMgrName) {
		this.secondLevelMgrName = secondLevelMgrName;
	}
	public Long getSecondLevelMgrMobile() {
		return secondLevelMgrMobile;
	}
	public void setSecondLevelMgrMobile(Long secondLevelMgrMobile) {
		this.secondLevelMgrMobile = secondLevelMgrMobile;
	}
	public String getSecondLevelMgrMailId() {
		return secondLevelMgrMailId;
	}
	public void setSecondLevelMgrMailId(String secondLevelMgrMailId) {
		this.secondLevelMgrMailId = secondLevelMgrMailId;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public LocalDateTime getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(LocalDateTime createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public LocalDateTime getModifyTimestamp() {
		return modifyTimestamp;
	}

	public void setModifyTimestamp(LocalDateTime modifyTimestamp) {
		this.modifyTimestamp = modifyTimestamp;
	}

	public LocalDateTime getDeleteTimestamp() {
		return deleteTimestamp;
	}

	public void setDeleteTimestamp(LocalDateTime deleteTimestamp) {
		this.deleteTimestamp = deleteTimestamp;
	}
	
}
