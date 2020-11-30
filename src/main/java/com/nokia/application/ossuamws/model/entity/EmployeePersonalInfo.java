package com.nokia.application.ossuamws.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="employee_personal_info")
public class EmployeePersonalInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -910385788828795325L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer Id;
	
	@Column(name="emp_id")
	private String empId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="login_id")
	private String loginId;
	
	@Column(name="username")
	private String userName ;
	
	@Column(name="email_id")   
	private String emailId ;  
	
	@Column(name="mobile")
	private String mobile ;
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@Cascade({ CascadeType.SAVE_UPDATE})
//	@JoinTable(name = "operator_details", 
//			   joinColumns = { @JoinColumn(name = "emp_id") }, 
//			   inverseJoinColumns = {@JoinColumn(name = "circle_id") })
//	private Set<Circles> circleId = new HashSet<Circles>();

	@CreationTimestamp
	@Column(name="create_timestamp")
	private LocalDateTime createTimestamp ;
	
	//@UpdateTimestamp
	@Column(name="modify_timestamp")
	private LocalDateTime modifyTimestamp ;
	
	//@UpdateTimestamp
	@Column(name="delete_timestamp")
	private LocalDateTime deleteTimestamp ;
	
	@Column(name="expiry_date")
	private LocalDateTime expiryDate;
	
	@Column(name="created_by")
	private String createdBy; 
	
	@Column(name="modified_by")
	private String modifiedBy;
	
	@Column(name="deleted_by")
	private String deletedBy;
	
	@Column(name="is_active")
	private Integer isActive ;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EmployeePersonalInfo(Integer id, String empId, String name, String loginId, String userName, String emailId,
			String mobile, LocalDateTime createTimestamp, LocalDateTime modifyTimestamp, LocalDateTime deleteTimestamp,
			LocalDateTime expiryDate, String createdBy, String modifiedBy, String deletedBy, Integer isActive) {
		super();
		Id = id;
		this.empId = empId;
		this.name = name;
		this.loginId = loginId;
		this.userName = userName;
		this.emailId = emailId;
		this.mobile = mobile;
		this.createTimestamp = createTimestamp;
		this.modifyTimestamp = modifyTimestamp;
		this.deleteTimestamp = deleteTimestamp;
		this.expiryDate = expiryDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.deletedBy = deletedBy;
		this.isActive = isActive;
	}

	public EmployeePersonalInfo(String empId) {
		this.empId = empId;
	}

	public EmployeePersonalInfo() {
	}
	
	
	
}

