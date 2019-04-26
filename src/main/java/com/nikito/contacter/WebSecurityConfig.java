package com.nikito.contacter;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.jdbcAuthentication()
			.dataSource(dataSource)
				.passwordEncoder(passwordEncoder())
					.usersByUsernameQuery("select username, password, enabled from user where username = ?")
						.authoritiesByUsernameQuery("select username, role from user where username = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/register").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin().loginPage("/login")
			.defaultSuccessUrl("/addContact").permitAll()
			.and()
		.logout().permitAll();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){

		return new BCryptPasswordEncoder();
	}
}
