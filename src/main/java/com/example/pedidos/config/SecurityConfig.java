package com.example.pedidos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
            .csrf(ServerHttpSecurity.CsrfSpec::disable)  // Desactivar CSRF
            .authorizeExchange(exchanges -> exchanges
                .pathMatchers("/public/**").permitAll()  // Permitir acceso público
                .pathMatchers("/api/pedidos/**").authenticated()  // Requiere autenticación
                .anyExchange().permitAll()
            )
            .httpBasic(httpBasicSpec -> {})  // Habilitar HTTP Basic Auth sin llamar a build()
            .formLogin(ServerHttpSecurity.FormLoginSpec::disable) // Deshabilitar login por formulario
            .build();
    }

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("USER")
                .build();
        return new MapReactiveUserDetailsService(user);
    }
}
