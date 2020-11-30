package com.nokia.application.ossuamws.model.Request;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.nokia.application.ossuamws.model.entity.Circles;
import com.nokia.application.ossuamws.model.entity.Department;
import com.nokia.application.ossuamws.model.entity.Domain;
import com.nokia.application.ossuamws.model.entity.Manager;
import com.nokia.application.ossuamws.model.entity.Nodes;
import com.nokia.application.ossuamws.model.entity.Operator;
import com.nokia.application.ossuamws.model.entity.Vendor;

public class EmployeeRequest {

	private Integer Id;
	private String empId;
	private String emailId ;   
	private String designation;
	private String location ;
	private String company ;
	private String mobile ;
	private String NSNaccount; 
	private Set<Circles> circleId = new HashSet<Circles>();
	private Integer isActive ;
	private String tiltle ;
	private String UID;
	private String userName;
	private Integer formAttached;
	private Integer profileNames;
	private Integer requestedProfile;
	private LocalDateTime createTimestamp ;
	private LocalDateTime modifyTimestamp ;
	private LocalDateTime deleteTimestamp ;
	private LocalDateTime expiryDate;
	private Domain domainId ;   
	private Department departmentId;
	private Manager managerId ;
	private Operator operatorId ;
	private Vendor vendorId; 
	private Nodes nodeId;
	

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	
	public Department getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}

	public Domain getDomainId() {
		return domainId;
	}

	public void setDomainId(Domain domainId) {
		this.domainId = domainId;
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

	public Set<Circles> getCircleId() {
		return circleId;
	}

	public void setCircleId(Set<Circles> circleId) {
		this.circleId = circleId;
	}
	
	public Integer getFormAttached() {
		return formAttached;
	}
	public void setFormAttached(Integer formAttached) {
		this.formAttached = formAttached;
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
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getNSNaccount() {
		return NSNaccount;
	}
	public void setNSNaccount(String nSNaccount) {
		NSNaccount = nSNaccount;
	}
	
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
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


	public Manager getManagerId() {
		return managerId;
	}

	public void setManagerId(Manager managerId) {
		this.managerId = managerId;
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

	public Nodes getNodeId() {
		return nodeId;
	}

	public void setNodeId(Nodes nodeId) {
		this.nodeId = nodeId;
	}

}
