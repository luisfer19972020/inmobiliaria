package com.inmobiliaria.administracionservice;

import com.inmobiliaria.administracionservice.models.service.JpaUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JpaUserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/img/**", "/uploads/**")
                .permitAll()
                .antMatchers("/admin").hasAnyRole("ADMIN","SECRETARIA","AGENTE")
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/admin", true)
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error_403");
    }
}
