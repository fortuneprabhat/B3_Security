package com.security.B3_Security.Configurations;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { //Method Chaining //super.configure(auth);
	 * auth.inMemoryAuthentication() .withUser("user") .password("user")
	 * .roles("USER") .and() .withUser("admin") .password("admin") .roles("ADMIN");
	 * }
	 * 
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Bean public PasswordEncoder getPasspordEncoder() {
	 * 
	 * return NoOpPasswordEncoder.getInstance(); }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception { //
	 * TODO Auto-generated method stub http.authorizeRequests()
	 * //.antMatchers("/**").hasRole("ADMIN") .antMatchers("/**").hasRole("ADMIN")
	 * .antMatchers("/user").hasRole("USER") .antMatchers("/").permitAll() .and()
	 * .formLogin();
	 * 
	 * }
	 */
	
	
	//https://docs.spring.io/spring-security/site/docs/4.0.x/reference/html/appendix-schema.html
	@Autowired
	DataSource dataSource;
	
	@Bean public PasswordEncoder getPasspordEncoder() {
		return NoOpPasswordEncoder.getInstance(); 
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.withDefaultSchema();
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/**").hasRole("ADMIN")
		.antMatchers("/user").hasRole("USER") 
		.antMatchers("/").permitAll()
		.and()
		.formLogin();
	}
}
