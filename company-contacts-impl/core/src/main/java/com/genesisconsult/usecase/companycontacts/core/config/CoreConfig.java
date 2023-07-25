package com.genesisconsult.usecase.companycontacts.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.genesisconsult.usecase.companycontacts.core.repo")
@EntityScan("com.genesisconsult.usecase.companycontacts.core.domain")
@ComponentScan(basePackages = {
        "com.genesisconsult.usecase.companycontacts.core.repo",
        "com.genesisconsult.usecase.companycontacts.core.service.impl"
})
public class CoreConfig {
}