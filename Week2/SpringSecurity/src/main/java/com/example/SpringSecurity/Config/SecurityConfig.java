package com.example.SpringSecurity.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.SpringSecurity.Services.StudentsServices;
@Configuration
@EnableWebSecurity
public class SecurityConfig {




    @Autowired
    private StudentsServices studentsServices;

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/students", "/dummy").authenticated()
                .requestMatchers("/hello").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .permitAll()
                .defaultSuccessUrl("/dummy", true)
            )
            .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // UserDetails user = User.withUsername("sampathkumar")
        //         .password(passwordEncoder.encode("1234"))
        //         .roles("USER")
        //         .build();

        // UserDetails admin = User.withUsername("sampath")
        //         .password(passwordEncoder.encode("1234"))
        //         .roles("ADMIN")
        //         .build();

        // return new InMemoryUserDetailsManager(user, admin);

        return studentsServices;
    }

@Bean
public DaoAuthenticationProvider authenticateProvider() {

    DaoAuthenticationProvider authprovider =
            new DaoAuthenticationProvider(userDetailsService(passwordEncoder()));

    authprovider.setPasswordEncoder(passwordEncoder());

    return authprovider;
}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}