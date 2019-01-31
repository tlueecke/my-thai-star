package com.devonfw.application.mtss4sdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.devonfw.module.jpa.dataaccess.api.AdvancedRevisionEntity;
import com.devonfw.module.jpa.dataaccess.impl.data.GenericRepositoryFactoryBean;

@SpringBootApplication
@ComponentScan(basePackages = { "com.sap.cloud.sdk", "com.devonfw.application.mtss4sdk" }, basePackageClasses = {
		AdvancedRevisionEntity.class })
@ServletComponentScan({ "com.sap.cloud.sdk", "com.devonfw.application.mtss4sdk" })
@EnableJpaRepositories(repositoryFactoryBeanClass = GenericRepositoryFactoryBean.class)
public class Application extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
