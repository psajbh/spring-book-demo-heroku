package com.jhart.dto;

//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

//@ToString
//@Getter
//@Setter
//@NoArgsConstructor
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
	

	
}
