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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import java.util.List;
import com.example.SpringSecurity.Services.StudentsServices;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import com.example.SpringSecurity.Security.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private StudentsServices studentsServices;
    
    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/students", "/dummy").authenticated()
                .requestMatchers("/hello", "/auth/login", "/auth/register", "/add").permitAll()
                .anyRequest().authenticated()
            )
            // .formLogin(form -> form
            //     .permitAll()
            //     .defaultSuccessUrl("/dummy", true)
            // )
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

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
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authprovider = new DaoAuthenticationProvider(studentsServices);
        authprovider.setPasswordEncoder(passwordEncoder());

        return authprovider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(List.of(authenticationProvider()));
    }

}