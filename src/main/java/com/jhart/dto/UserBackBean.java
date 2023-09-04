package com.jhart.dto;

import java.util.Objects;

public class UserBackBean {

	private Long id;
	private String name;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private Boolean hasTasks;
	private String ldapId;
	
	public String getFullName() {
		return firstName + " " + lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getHasTasks() {
		return hasTasks;
	}

	public void setHasTasks(Boolean hasTasks) {
		this.hasTasks = hasTasks;
	}

	public String getLdapId() {
		return ldapId;
	}

	public void setLdapId(String ldapId) {
		this.ldapId = ldapId;
	}

	@Override
	public String toString() {
		return "UserBackBean [id=" + id + ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", email=" + email + ", hasTasks=" + hasTasks + ", ldapId=" + ldapId + "]";
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(email, firstName, hasTasks, id, lastName, ldapId, name, phone);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		UserBackBean other = (UserBackBean) obj;
//		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
//				&& Objects.equals(hasTasks, other.hasTasks) && Objects.equals(id, other.id)
//				&& Objects.equals(lastName, other.lastName) && Objects.equals(ldapId, other.ldapId)
//				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
//	}
//	

	
}
