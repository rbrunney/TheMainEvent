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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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
                .antMatchers("/ingredient/**").hasRole("admin")
                .antMatchers("/inventory/**").hasRole("admin")
                .antMatchers("/menuItem/add").hasRole("admin")
                .antMatchers("/menuItem/delete/{name}").hasRole("admin")
                .antMatchers("/menuItem/update/{oldMenu}").hasRole("admin")
                .antMatchers("/menuItem/search/{name}").hasAnyRole("admin", "user")
                .antMatchers("/order/add").hasAnyRole("user", "admin")
                .antMatchers("/order/delete/{name}").hasRole("admin")
                .antMatchers("/order/update/{oldName}/{newName}").hasRole("admin")
                .antMatchers("/order/search/{name}").hasRole("admin")
                .antMatchers("/orderDetails/add").permitAll()
                .antMatchers("/orderDetails/delete/{name}").hasRole("admin")
                .antMatchers("/orderDetails/update/**").permitAll()
                .antMatchers("/orderDetails/search/{name}").hasRole("admin")
                .antMatchers("/user/add").permitAll()
                .antMatchers("/user/checkUser/**").permitAll()
                .antMatchers("/user/delete/{name}").hasRole("admin")
                .antMatchers("/user/search/{name}").hasRole("admin")
                .antMatchers("/user/update/{oldName}/{newName}").hasAnyRole("admin", "user")
                .antMatchers("/email/**").permitAll()
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

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
