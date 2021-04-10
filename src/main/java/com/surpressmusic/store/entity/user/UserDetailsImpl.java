package com.surpressmusic.store.entity.user;

import com.surpressmusic.store.repositories.UserDetailsImplRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
	private Integer id;

	@Column(name = "isAccountNonExpired")
	private Boolean isAccountNonExpired;

	@Column(name = "isAccountNonLocked")
	private Boolean isAccountNonLocked;

	@Column(name = "isCredentialsNonExpired")
	private Boolean isCredentialsNonExpired;

	@Column(name = "isEnabled")
	private Boolean isEnabled;

	@OneToOne(cascade = {CascadeType.ALL})
	private User user;

	@Transient
	private List<GrantedAuthority> authorities;

	// Empty Constructor
	public UserDetailsImpl()
	{

	}

	public UserDetailsImpl(User user) {
		this.user = user;
		this.isAccountNonExpired = true;
		this.isAccountNonLocked = true;
		this.isCredentialsNonExpired = true;
		this.isEnabled = true;
	}

	public UserDetailsImpl(User user, List<GrantedAuthority> auths) {
		this.user = user;
		this.authorities = auths;
		this.isAccountNonExpired = true;
		this.isAccountNonLocked = true;
		this.isCredentialsNonExpired = true;
		this.isEnabled = true;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
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
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}

	private void setId(Integer id) { this.id = id; }


	public Integer getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
