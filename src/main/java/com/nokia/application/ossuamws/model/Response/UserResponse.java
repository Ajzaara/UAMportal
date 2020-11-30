package com.nokia.application.ossuamws.model.Response;

import java.time.LocalDateTime;

public class UserResponse {
		
		private Integer userId;
		private String userName;
		private String firstName;
		private String lastName;
		private Integer isActive;
		private LocalDateTime expiryDate;
		private LocalDateTime createTimestamp ;
		private LocalDateTime modifyTimestamp ;
		private LocalDateTime deleteTimestamp ;
		

		public LocalDateTime getExpiryDate() {
			return expiryDate;
		}

		public void setExpiryDate(LocalDateTime expiryDate) {
			this.expiryDate = expiryDate;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public Integer getIsActive() {
			return isActive;
		}

		public void setIsActive(Integer isActive) {
			this.isActive = isActive;
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

		
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserName() {
			return userName;
		}
		public void setUsername(String userName) {
			this.userName = userName;
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
				
	}
