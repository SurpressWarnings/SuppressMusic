package com.surpressmusic.store.entity.user;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "user_details")
public class UserDetailsImpl implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_detail_id")
	private int id;

	private Boolean isAccountNonExpired;

	private Boolean isAccountNonLocked;

	private Boolean isCredentialsNonExpired;

	private Boolean isEnabled;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	private List<GrantedAuthority> authorities;

	public UserDetailsImpl(User user, List<GrantedAuthority> auths) {
		this.user = user;
		this.authorities = auths;
	}

	// Empty Constructor
	public UserDetailsImpl()
	{

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	private void setId(Integer id) { this.id = id; }

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public List<String> getAllUserInfoFields() {
		return Arrays.asList(firstName, lastName, streetAddress,
				city, state, zipcode, email, phoneNumber);
	}
}
