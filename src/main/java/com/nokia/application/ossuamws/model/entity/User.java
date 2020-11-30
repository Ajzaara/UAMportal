package com.nokia.application.ossuamws.model.entity;

	import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
	@Entity
	@Table(name="user_info")
	public class User implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 5407848652716692215L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="userid")
		private Integer userId;
		
		@Column(name="username")
		private String userName;
		
		@Column(name="password")
		private String password;
		
		@Column(name="firstname")
		private String firstName;
		
		@Column(name="lastname")
		private String lastName;
		
		@Column(name="is_active")
		private Integer isActive;
		
		@Column(name="is_admin")
		private Integer isAdmin;
		
		@Column(name="expiry_date")
		private LocalDateTime expiryDate;
		
		@CreationTimestamp
		@Column(name="create_timestamp")
		private LocalDateTime createTimestamp ;
		
		//@UpdateTimestamp
		@Column(name="modify_timestamp")
		private LocalDateTime modifyTimestamp ;
		
		//@UpdateTimestamp
		@Column(name="delete_timestamp")
		private LocalDateTime deleteTimestamp ;
		
		
		public LocalDateTime getExpiryDate() {
			return expiryDate;
		}

		public void setExpiryDate(LocalDateTime expiryDate) {
			this.expiryDate = expiryDate;
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

		public LocalDateTime getCreateTimestamp() {
			return createTimestamp;
		}

		public void setCreateTimestamp(LocalDateTime createTimestamp) {
			this.createTimestamp = createTimestamp;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Integer getIsActive() {
			return isActive;
		}

		public void setIsActive(Integer isActive) {
			this.isActive = isActive;
		}

		public Integer getIsAdmin() {
			return isAdmin;
		}

		public void setIsAdmin(Integer isAdmin) {
			this.isAdmin = isAdmin;
		}

	}