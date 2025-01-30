package com.binary.carDealerApp.classCarDealerApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private AuthenticationProvider authenticationProvider;

    public SecurityConfig(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csfr -> csfr.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(ahr ->
                                ahr
                                    .requestMatchers(HttpMethod.GET,"/api/cars/all", "/api/dealers/all", "/api/cars/*", "/api/dealers/*")
                                    .permitAll()
                                    .requestMatchers(HttpMethod.POST, "/api/users/")
                                    .permitAll()
                                    .requestMatchers(HttpMethod.POST,"/api/cars/", "/api/dealers/create")
                                    .authenticated()
                                    .requestMatchers(HttpMethod.PUT, "/api/cars/*", "/api/dealers/update/*")
                                    .hasAnyRole("DEALER", "ADMIN")
                                    .requestMatchers(HttpMethod.DELETE, "/api/cars/*", "/api/dealers/delete/*")
                                    .hasAnyRole("DEALER", "ADMIN")
                        )
//                .httpBasic(Customizer.withDefaults());
                .sessionManagement(ses -> {
                    ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .authenticationProvider(authenticationProvider);

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder().encode("userPass"))
//                .roles("USER")
//                .build();
//        UserDetails dealer = User.builder()
//                .username("dealer")
//                .password(passwordEncoder().encode("dealerPass"))
//                .roles("DEALER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("adminPass"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(admin, dealer, user);
//    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
}
