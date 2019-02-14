package com.devonfw.application.mtss4sdk.general.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
@Profile("!cloud")
public class LocalCsrfHandlingFilter extends GenericFilterBean {

	private static final Set<String> XSRF_REQUESTS = new HashSet<>(Arrays.asList("POST", "PUT", "PATCH", "DELETE"));

	private final Map<String, String> issuedTokens = new HashMap<>();

	private static final String TOKEN = "X-CSRF-Token";

	public LocalCsrfHandlingFilter() {
		System.out.println("Filter registered");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession();
		if (XSRF_REQUESTS.contains(httpServletRequest.getMethod())) {
			String token = httpServletRequest.getHeader(TOKEN);
			String sessionToken = issuedTokens.get(session.getId());
			if (token == null || sessionToken == null || !sessionToken.equals(token)) {
				httpServletResponse.setStatus(403);
				httpServletResponse.addHeader(TOKEN, "REQUIRED");
				return;
			}
		}
		if ("Fetch".equals(httpServletRequest.getHeader(TOKEN))) {
			String token = UUID.randomUUID().toString();
			issuedTokens.put(session.getId(), token);
			httpServletResponse.setHeader(TOKEN, token);
		}
		chain.doFilter(request, response);
	}

}
