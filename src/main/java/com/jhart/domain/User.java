package com.jhart.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true)
	private String name;
	
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private Date dateCreated;
	private String ldapId;
	// never able to resolve the orphenRemoval issue, doesn't seem to be a problem 
	//User.java is the parent (the one side is the parent)
	//https://codippa.com/how-to-resolve-a-collection-with-cascadeall-delete-orphan-was-no-longer-referenced-by-the-owning-entity-instance
	//http://cristian.sulea.net/blog/hibernate-exception-a-collection-with-cascade-all-delete-orphan-was-no-longer-referenced-by-the-owning-entity-instance/
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval= true, mappedBy="user")
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Todo> todos;
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
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getLdapId() {
		return ldapId;
	}
	public void setLdapId(String ldapId) {
		this.ldapId = ldapId;
	}
	public Set<Todo> getTodos() {
		return todos;
	}
	public void setTodos(Set<Todo> todos) {
		this.todos = todos;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", email=" + email + ", dateCreated=" + dateCreated + ", ldapId=" + ldapId + ", todos="
				+ todos + "]";
	}
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(dateCreated, email, firstName, id, lastName, ldapId, name, phone, todos);
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
//		User other = (User) obj;
//		return Objects.equals(dateCreated, other.dateCreated) && Objects.equals(email, other.email)
//				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
//				&& Objects.equals(lastName, other.lastName) && Objects.equals(ldapId, other.ldapId)
//				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
//				&& Objects.equals(todos, other.todos);
//	}
	
	
}
