package com.devonfw.application.mtss4sdk.general.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

// s. comment in TenantIdentifierResolver
//@Configuration
//@Profile("cloud")
public class HibernateConfig {

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			MultiTenantConnectionProvider multiTenantConnectionProvider,
			CurrentTenantIdentifierResolver tenantIdentifierResolver) {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan("com.devonfw.application.mtss4sdk");

		em.setJpaVendorAdapter(this.jpaVendorAdapter());

		final Map<String, Object> jpaProperties = new HashMap<>();
		jpaProperties.put(Environment.MULTI_TENANT, MultiTenancyStrategy.SCHEMA);
		jpaProperties.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProvider);
		jpaProperties.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, tenantIdentifierResolver);
		jpaProperties.put(Environment.FORMAT_SQL, true);

		em.setJpaPropertyMap(jpaProperties);
		return em;
	}
}