package com.example.practica2.security;

import com.example.practica2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Auth extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    JwtAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public PasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encode());
        /*auth.userDetailsService(userDetailsService).passwordEncoder(getEncoder());
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");*/
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }
    /*

            httpSecurity.httpBasic().and().authorizeRequests()
                .antMatchers("/").permitAll()
        .antMatchers("/products").hasAnyRole("ADMIN").and().formLogin();
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable()
        .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        /*.and().authorizeRequests().antMatchers("/users/**").permitAll()
        .anyRequest().permitAll()*/
                .and().authorizeRequests().antMatchers("/**").permitAll()
        /*.antMatchers(HttpMethod.GET, "/**").permitAll()
        .antMatchers(HttpMethod.POST, "/products/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/products/**").permitAll()
        .antMatchers(HttpMethod.DELETE, "/products/**").permitAll()
        .antMatchers(HttpMethod.POST, "/users/**").permitAll()
        .antMatchers(HttpMethod.PUT, "/users/**").permitAll()
        .antMatchers(HttpMethod.DELETE, "/users/**").permitAll().and()*/
        ; //.anyRequest().authenticated().and().formLogin()


        httpSecurity.headers()
                .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"))
                .addHeaderWriter(new StaticHeadersWriter("Access-Control-Request-Methods", "*"));

        httpSecurity.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        /*
                httpSecurity.httpBasic().and().authorizeRequests()
        .antMatchers(HttpMethod.GET, "/**").permitAll()
        .antMatchers(HttpMethod.POST, "/products/**").permitAll()
        .antMatchers(HttpMethod.PUT, "/products/**").permitAll()
        .antMatchers(HttpMethod.DELETE, "/products/**").permitAll()
        .antMatchers(HttpMethod.POST, "/users/**").permitAll()
        .antMatchers(HttpMethod.PUT, "/users/**").permitAll()
        .antMatchers(HttpMethod.DELETE, "/users/**").permitAll()//.hasRole("ADMIN")
        .and().csrf().disable()
         */
    }
}
