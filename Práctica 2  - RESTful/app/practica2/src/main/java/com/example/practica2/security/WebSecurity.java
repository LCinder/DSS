package com.example.practica2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
    private MyUserDetailService myUserDetailService;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailService);
		
        auth.inMemoryAuthentication()
                .withUser("jorge").password("12345").roles("admin")
                .and()
                .withUser("diego").password("12345").roles("user");
    }
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers("/products").hasAnyRole("admin", "user")
            .antMatchers("/users").hasRole("admin")
            .and().formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    
}
