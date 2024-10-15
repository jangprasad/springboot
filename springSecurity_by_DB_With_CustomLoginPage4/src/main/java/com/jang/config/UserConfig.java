package com.jang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfig {

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService()  //return databse ka jo hme select kiya h
    {
        return myUserDetailService;
    }
   /* @Bean
    public UserDetailsService userDetailsService()
    {
        UserDetails admin = User.builder()
                .username("jang")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .build();
        UserDetails user = User.builder()
                .username("raju")
                .password(passwordEncoder().encode("321"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,user);  //USE for store temprore memory

    }*/
    // THIRD DEMO

   @Bean
 public AuthenticationProvider authenticationProvider() //provide auhencation for login // last step
 {
     DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
     provider.setUserDetailsService(myUserDetailService);
     provider.setPasswordEncoder(passwordEncoder());
     return provider;
 }




    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/home","register/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasRole("USER")
                        .anyRequest()
                        .authenticated())
               // .formLogin(form->form.permitAll())   //user for show the login form
                .formLogin(form->form
                        .loginPage("/login")
                        .successHandler(new SuccessHandler()) //login sucess then goto this class
                        .permitAll())
                .build();



    }



}
