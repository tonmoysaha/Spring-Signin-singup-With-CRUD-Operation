package com.spring.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(userBuilder.username("opi").password("opi").roles("common","son"))
		.withUser(userBuilder.username("ma").password("ma").roles("common" , "ma"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
		.antMatchers("/").hasRole("common")
		.antMatchers("/parents/**").hasRole("ma")
		.antMatchers("/childrens/**").hasRole("son")
		.and().formLogin().loginPage("/mylogin").loginProcessingUrl("/authenticattheuser").permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/accessdenied");
	}
	
	
}

