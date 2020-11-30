package com.nokia.application.ossuamws.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="employee_profile_info")
public class EmployeeProfileInfo implements Serializable{
	
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

	@Column(name="NSN_account")
	private String NSNaccount; 
	
	@Column(name="domain_id")   
	private Domain domainId ;
	
	@Column(name="dept_id")   
	private Department departmentId;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="location")
	private String location ;
	
	@Column(name="company")
	private String company ;
	
	@Column(name="title")
	private String tiltle ;

	@Column(name="UID")
	private String UID;
	
	@Lob
	@Column(name="upload_form")
	private byte[] uploadForm ;
	
	@Transient
 	private String uploadFormType;
 	
	@Column(name="upload_form_name")
	private String uploadFormName;
	
	@Column(name = "profile_names")
	private Integer profileNames;

	@Column(name = "requested_profile")
	private Integer requestedProfile;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getNSNaccount() {
		return NSNaccount;
	}

	public void setNSNaccount(String nSNaccount) {
		NSNaccount = nSNaccount;
	}

	public Domain getDomainId() {
		return domainId;
	}

	public void setDomainId(Domain domainId) {
		this.domainId = domainId;
	}

	public Department getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTiltle() {
		return tiltle;
	}

	public void setTiltle(String tiltle) {
		this.tiltle = tiltle;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public byte[] getUploadForm() {
		return uploadForm;
	}

	public void setUploadForm(byte[] uploadForm) {
		this.uploadForm = uploadForm;
	}

	public String getUploadFormType() {
		return uploadFormType;
	}

	public void setUploadFormType(String uploadFormType) {
		this.uploadFormType = uploadFormType;
	}

	public String getUploadFormName() {
		return uploadFormName;
	}

	public void setUploadFormName(String uploadFormName) {
		this.uploadFormName = uploadFormName;
	}

	public Integer getProfileNames() {
		return profileNames;
	}

	public void setProfileNames(Integer profileNames) {
		this.profileNames = profileNames;
	}

	public Integer getRequestedProfile() {
		return requestedProfile;
	}

	public void setRequestedProfile(Integer requestedProfile) {
		this.requestedProfile = requestedProfile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}

