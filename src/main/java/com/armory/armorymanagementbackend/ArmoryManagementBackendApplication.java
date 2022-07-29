package com.armory.armorymanagementbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;

@SpringBootApplication
public class ArmoryManagementBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArmoryManagementBackendApplication.class, args);
    }

    @Configuration
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.cors().configurationSource(corsConfigurationSource())
                    .and().csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/api/**").permitAll()
                    .anyRequest().authenticated()
                    .and().sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            http.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);

        }

        @Bean
        public CorsConfigurationSource corsConfigurationSource() {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Arrays.asList(
                    "http://localhost:3000",
                    "localhost:3000"
            ));
            configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS"));
            configuration.setAllowCredentials(true);
            configuration.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/api/**", configuration);
            return source;
        }

    }

}
