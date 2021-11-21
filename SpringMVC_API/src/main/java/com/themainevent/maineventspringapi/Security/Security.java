package com.themainevent.maineventspringapi.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter  {

    // ///////////////////////////////////////////
    // Create in-memory user
    static InMemoryUserDetailsManager memAuth  = new InMemoryUserDetailsManager();
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        System.out.println("configure - A");

        UserDetails newUser = User.withUsername("admin")
                .password(passEncode().encode("pass"))
                .roles("ADMIN").build();
        memAuth.createUser(newUser);
        auth.userDetailsService(memAuth);

    }
    // ///////////////////////////////////////////
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        System.out.println("configure - B");

        http.authorizeRequests()
                .antMatchers("/ingredient/**").permitAll()
                .antMatchers("/inventory/**").permitAll()
                .antMatchers("/order/**").permitAll()
                .antMatchers("/user/**").permitAll()
                //.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .httpBasic();

    }
    // ///////////////////////////////////////////
    @Bean
    PasswordEncoder passEncode() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager getInMemoryUserDetailsManager() {
        System.out.println("*** Enter getnInMemoryUserDetailsManager()");
        return memAuth;
    }
}
