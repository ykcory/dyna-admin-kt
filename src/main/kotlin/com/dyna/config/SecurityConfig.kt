package com.dyna.config

import com.dyna.fliters.JwtAuthenticationFilter
import com.dyna.service.AuthUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val authUserDetailsService: AuthUserDetailsService,
    private val jwtAuthenticationFilter: JwtAuthenticationFilter
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { it.disable() }
        http.authorizeHttpRequests {
            it.requestMatchers("/auth/login", "/swagger-ui/**", "/v3/api-docs/**").permitAll().anyRequest()
                .authenticated()
        }

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }

    @Bean
    fun authenticationManager(passwordEncoder: PasswordEncoder): AuthenticationManager {

        val provider = DaoAuthenticationProvider()
        provider.setUserDetailsService(authUserDetailsService)
        provider.setPasswordEncoder(passwordEncoder)

        return ProviderManager(provider)

    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    /*@Bean
    fun userDetailsService(): UserDetailsService {
        val password = BCryptPasswordEncoder().encode("123456")

        val adminUser: UserDetails = User
            .withUsername("admin")
            .password(password)
            .roles("admin")
            .build()

        val user: UserDetails = User
            .withUsername("yangxiaodong")
            .password(password)
            .roles("user")
            .build()

        return InMemoryUserDetailsManager(adminUser, user)
    }



    */
}