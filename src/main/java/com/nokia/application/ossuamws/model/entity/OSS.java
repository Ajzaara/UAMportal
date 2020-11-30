package com.nokia.application.ossuamws.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OSS")
public class OSS implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2393596712020324020L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oss_id")
	private Integer ossId;
	
	@Column(name = "oss_name")
	private String ossName;
	
	@Column(name = "is_Active")
	private Integer isActive;

	public Integer getOssId() {
		return ossId;
	}

	public void setOssId(Integer ossId) {
		this.ossId = ossId;
	}

	public String getOssName() {
		return ossName;
	}

	public void setOssName(String ossName) {
		this.ossName = ossName;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public OSS() {
	}

	public OSS(Integer ossId) {
		this.ossId = ossId;
	}

}
