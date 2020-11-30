package com.nokia.application.ossuamws.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name="Operator")
//@SecondaryTables(
//    @SecondaryTable(name="operator_details", pkJoinColumns={
//        @PrimaryKeyJoinColumn(name="operatorId", referencedColumnName="operator_id") }
//))
public class Operator  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6590346927608288045L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="operator_id")
	private Integer operatorId;	
	
	@Column(name="op_name")
	private String operatorName;

	public String getOpName() {
		return operatorName;
	}
	public void setOpName(String opName) {
		this.operatorName = opName;
	}

	public Operator() {
	}
	
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	public Operator(Integer operatorId, String operatorName) {
		this.operatorId = operatorId;
		this.operatorName = operatorName;
	}
	public Operator(Integer operatorId) {
		this.operatorId = operatorId;
	}
	
}
