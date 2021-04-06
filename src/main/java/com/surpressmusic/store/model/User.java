package com.surpressmusic.store.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer id;

	@Column(name="user_name", nullable = false)
	private String username;

	@Column(name="password", nullable = false)
	private String password;

	@Column(name="first_name", nullable = false)
	private String firstName;

	@Column(name="last_name", nullable = false)
	private String lastName;

	@Column(name="cc_number")
	private String ccNumber;

//	@ManyToMany(cascade = CascadeType.MERGE)
//	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),   inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private Set<Role> roles;
   
	@Column(name="roles")
	private String roles;  
   
	public User(String username, String password){
		this.roles = "USER";
		this.username = username;
		this.password = password;
	}
	
	// Empty Constructor
	public User()
	{
		
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}	
}
