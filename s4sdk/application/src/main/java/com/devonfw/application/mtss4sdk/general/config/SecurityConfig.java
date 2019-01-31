package com.devonfw.application.mtss4sdk.general.config;

// Example for Spring Boot security configuration

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
@EnableWebSecurity
@Profile("cloud")
public class SecurityConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(final HttpSecurity httpSecurity) throws Exception {
		// http://docs.spring.io/spring-security/oauth/apidocs/org/springframework/security/oauth2/provider/expression/OAuth2SecurityExpressionMethods.html
		final String hasGuestScope = "#oauth2.hasScopeMatching('MTS(\\S)+\\.Guest')";

		// When providing a configuration that extends ResourceServerConfigurerAdapter,
		// http.authorizeRequests() HAS to
		// be called somewhere, since some other thing relies on it. Normally, this is
		// done by
		// ResourceServerConfigurerAdapter itself (which is apparently overwritten by
		// this implementation).
		httpSecurity.sessionManagement()
				// session is created by approuter
				.sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
				// demand specific scopes depending on intended request
				.authorizeRequests()
				// enable OAuth2 checks
				.antMatchers("/api/**").access(hasGuestScope)
				// permit everything else
				.anyRequest().permitAll();
	}

	@Bean
	protected ResourceServerTokenServices resourceServerTokenServices() {
		return new com.sap.xs2.security.commons.SAPOfflineTokenServicesCloud();
	}
}
