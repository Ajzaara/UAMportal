package com.nokia.application.ossuamws.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nodes")
public class Nodes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2994578606901506451L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "node_id")
	private Integer nodeId;
	
	@Column(name = "node_name")
	private String NodeName;
	
	@Column(name="is_active")
	private Integer isActive;

//	@OneToOne( mappedBy="nodeId")
//    private Employee emp;
//	
	
	public String getNodeName() {
		return NodeName;
	}

	public void setNodeName(String nodeName) {
		NodeName = nodeName;
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	
	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Nodes(Integer nodeId, String nodeName, Integer isActive) {
		this.nodeId = nodeId;
		this.NodeName = nodeName;
		this.isActive = isActive;
	}

	public Nodes() {
	}

	public Nodes(Integer nodeId) {
		super();
		this.nodeId = nodeId;
	}

}
