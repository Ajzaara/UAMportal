package com.nokia.application.ossuamws.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="Manager")
public class Manager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1078132623067148730L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manager_id")
	private Integer managerId;

	@Column(name = "name")
	private String name;

	@Column(name = "mobile")
	private Long mobile;

	@Column(name = "mail_id")
	private String mailId;

	 @OneToOne
	 @JoinColumn(name="domain_id") 
	 private Domain domainId;
	
	@Column(name="is_active")
	private Integer isActive ;
	
	@CreationTimestamp
	@Column(name="create_timestamp")
	private LocalDateTime createTimestamp ;
	
	//@UpdateTimestamp
	@Column(name="modify_timestamp")
	private LocalDateTime modifyTimestamp ;
	
	//@UpdateTimestamp
	@Column(name="delete_timestamp")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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


	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(Integer managerId) {
		this.managerId = managerId;
	}

	public Manager(Integer managerId, String name, Long mobile, String mailId, Domain domainId, String secondLevelMgrId,
			Integer isActive, LocalDateTime createTimestamp, LocalDateTime modifyTimestamp,
			LocalDateTime deleteTimestamp) {
		this.managerId = managerId;
		this.name = name;
		this.mobile = mobile;
		this.mailId = mailId;
		this.domainId = domainId;
		this.isActive = isActive;
		this.createTimestamp = createTimestamp;
		this.modifyTimestamp = modifyTimestamp;
		this.deleteTimestamp = deleteTimestamp;
	}
	
	
	
}
