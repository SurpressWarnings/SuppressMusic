package com.surpressmusic.store.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired 
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService)
				.passwordEncoder(tempPasswordEncoder());
				//.passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/", "/register").permitAll()
				.anyRequest().authenticated()
				.and()
				   .formLogin()
		            .loginPage("/login")
		            .defaultSuccessUrl("/mainmenu")
		            .failureUrl("/login?error=true")
		            .permitAll()
		        .and()
		            .logout()
		            .logoutSuccessUrl("/")
		            .invalidateHttpSession(true)
		            .permitAll()
		        .and()
		            .csrf()
		            .disable();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}
	
	
	// This is a work-around to store as passwords as plain text
	// THIS SHOULD NOT MAKE IT TO PRODUCTION - DELETE BEFORE SUBMITTING
	@Bean
	public PasswordEncoder tempPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
}
