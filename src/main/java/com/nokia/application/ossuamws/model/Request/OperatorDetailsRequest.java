package com.nokia.application.ossuamws.model.Request;

import java.util.HashSet;
import java.util.Set;
import com.nokia.application.ossuamws.model.entity.Circles;
import com.nokia.application.ossuamws.model.entity.EmployeePersonalInfo;
import com.nokia.application.ossuamws.model.entity.OSS;
import com.nokia.application.ossuamws.model.entity.Operator;
import com.nokia.application.ossuamws.model.entity.Vendor;


public class OperatorDetailsRequest {
	
	private EmployeePersonalInfo empId;
	private Operator operatorId;
	private String ossType;
	private Vendor vendorId; 
	private Set<Circles> circleId = new HashSet<Circles>();
	private Set<OSS> ossId = new HashSet<OSS>();
	
	
	
//	public Integer getId() {
//		return Id;
//	}
//	public void setId(Integer id) {
//		Id = id;
//	}
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
	public EmployeePersonalInfo getEmpId() {
		return empId;
	}
	public void setEmpId(EmployeePersonalInfo empId) {
		this.empId = empId;
	}
	
	
	public String getOssType() {
		return ossType;
	}
	public void setOssType(String ossType) {
		this.ossType = ossType;
	}
	

	@Override
	public String toString() {
		return "OperatorDetailsRequest [ empId=" + empId + ", operatorId=" + operatorId + ", ossType="
				+ ossType + ", vendorId=" + vendorId + ", circleId=" + circleId + ", ossId=" + ossId + "]";
	}
	

	
}
