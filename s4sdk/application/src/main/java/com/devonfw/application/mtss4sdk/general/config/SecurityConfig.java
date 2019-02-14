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

	private static final String[] UNSECURED_RESOURCES = new String[] { "/login", "/security/**", "/services/rest/login",
			"/services/rest/logout", "/services/rest/dishmanagement/**", "/services/rest/imagemanagement/**",
			"/services/rest/ordermanagement/v1/order", "/services/rest/bookingmanagement/v1/booking",
			"/services/rest/bookingmanagement/v1/booking/cancel/**",
			"/services/rest/bookingmanagement/v1/invitedguest/accept/**",
			"/services/rest/bookingmanagement/v1/invitedguest/decline/**",
			"/services/rest/ordermanagement/v1/order/cancelorder/**" };

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

//		httpSecurity
//				// .userDetailsService(this.userDetailsService)
//				.csrf().disable().exceptionHandling().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests().antMatchers("**")
//				.permitAll().antMatchers(HttpMethod.POST, "/login").permitAll()
//				.anyRequest().authenticated()
//				.and()
		// the api/login requests are filtered with the JWTLoginFilter
//				.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
//						UsernamePasswordAuthenticationFilter.class)
		// other requests are filtered to check the presence of JWT in header
//				.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
		;
	}

	@Bean
	protected ResourceServerTokenServices resourceServerTokenServices() {
		return new com.sap.xs2.security.commons.SAPOfflineTokenServicesCloud();
	}
}
