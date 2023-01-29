package BandApp.resourceserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(authorize ->
                        // Here we set authentication for all endpoints.
                        authorize.anyRequest().authenticated()
                )
                // Here we enable accepting JWT tokens with HTTP requests.
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                // enables CORS (Cross-Origin Resource Sharing (CORS) for cross-site resource-serving.
                // In other words, enabling CORS allows requests to come in from ports other than the one on which this server is running
                .cors()
                .and()
                .build();
    }

}