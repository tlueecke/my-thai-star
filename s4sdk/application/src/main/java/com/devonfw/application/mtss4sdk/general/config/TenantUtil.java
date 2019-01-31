package com.devonfw.application.mtss4sdk.general.config;

public class TenantUtil {
	public static final String SCHEMA_PREFIX = "TENANT_";
	public static final String DEFAULT_TENANT = "public";

	public static String createSchemaName(final String tenantId) {
		return tenantId.equals(DEFAULT_TENANT) ? DEFAULT_TENANT : SCHEMA_PREFIX + tenantId;
	}
}