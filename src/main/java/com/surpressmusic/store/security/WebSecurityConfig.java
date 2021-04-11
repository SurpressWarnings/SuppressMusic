//package com.surpressmusic.store.security;
//
//import com.surpressmusic.store.services.UserDetailsImplService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//
//	@Autowired
//	UserDetailsImplService userDetailsService;
//
//	@Autowired
//	BCryptPasswordEncoder encoder;
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService)
//				.passwordEncoder(encoder);
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		http.authorizeRequests()
//				.antMatchers("/admin").hasRole("ADMIN")
//				.antMatchers("/", "/register", "/browse/**", "/search").permitAll()
////				.anyRequest().authenticated()
//				.and()
//				   .formLogin()
//		            .loginPage("/login")
//		            .defaultSuccessUrl("/browse")
//		            .failureUrl("/login?error=true")
//		            .permitAll()
//		        .and()
//		            .logout()
//		            .logoutSuccessUrl("/")
//		            .invalidateHttpSession(true)
//		            .permitAll()
//		        .and()
//		            .csrf()
//		            .disable();
//	}
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web
//				.ignoring()
//				.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//	}
//}
