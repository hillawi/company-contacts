package com.genesisconsult.usecase.companycontacts.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(scanBasePackages = {
        "com.genesisconsult.usecase.companycontacts.core.config",
        "com.genesisconsult.usecase.companycontacts.rest.config",
        "com.genesisconsult.usecase.companycontacts.rest.controller",
        "com.genesisconsult.usecase.companycontacts.rest.mapper",
        "com.genesisconsult.usecase.companycontacts.rest.handler"},
        exclude = {ErrorMvcAutoConfiguration.class})
public class CompanyContactsApp {

    public static void main(String[] args) {
        SpringApplication.run(CompanyContactsApp.class, args);
    }

}