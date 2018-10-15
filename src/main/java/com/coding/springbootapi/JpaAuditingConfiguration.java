package com.coding.springbootapi;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*To enable JPA Auditing */
@Configuration
@EnableJpaAuditing()
//@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class JpaAuditingConfiguration {
	
//	@Bean
//	public AuditorAware<String> auditorProvider() {
//		return () -> Optional.ofNullable("chathuranga");
//	}
}