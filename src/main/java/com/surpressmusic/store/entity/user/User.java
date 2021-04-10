package com.surpressmusic.store.entity.user;

import javax.persistence.*;

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

	@OneToOne
	@JoinColumn(name = "user_billing_id")
	private UserBilling userBilling;

	@OneToOne
	@JoinColumn(name = "user_details_id")
	private UserDetailsImpl userDetails;

   @OneToOne
	@JoinColumn(name="role_id")
	private Role role;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	// Empty Constructor
	public User() {}
	
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserBilling getUserBilling() {
		return userBilling;
	}

	public void setUserBilling(UserBilling userBilling) {
		this.userBilling = userBilling;
	}

	public UserDetailsImpl getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsImpl userDetails) {
		this.userDetails = userDetails;
	}
}
