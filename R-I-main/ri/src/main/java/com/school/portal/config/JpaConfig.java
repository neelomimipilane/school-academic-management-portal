package com.school.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * Enables Spring Data JPA auditing (@CreatedDate, @LastModifiedDate, @CreatedBy).
 * AuditorAware returns "system" by default; replace with security-context lookup
 * once Spring Security is added as a dependency.
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        // No Spring Security dependency yet — always returns "system".
        // TODO: replace with SecurityContextHolder lookup when spring-boot-starter-security is added.
        return () -> Optional.of("system");
    }
}
