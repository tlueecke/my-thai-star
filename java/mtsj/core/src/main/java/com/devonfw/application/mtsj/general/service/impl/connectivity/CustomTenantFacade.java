package com.devonfw.application.mtsj.general.service.impl.connectivity;

import java.util.Optional;

import com.sap.cloud.sdk.cloudplatform.tenant.Tenant;
import com.sap.cloud.sdk.cloudplatform.tenant.TenantFacade;
import com.sap.cloud.sdk.cloudplatform.tenant.exception.TenantAccessException;
import com.sap.cloud.sdk.cloudplatform.tenant.exception.TenantNotAvailableException;

import io.vavr.control.Try;

public class CustomTenantFacade implements TenantFacade {

	private static final CustomTenant TENANT = new CustomTenant();

	@Override
	public Class<? extends Tenant> getTenantClass() {
		return CustomTenant.class;
	}

	@Override
	public Optional<Tenant> resolveCurrentTenant() throws TenantAccessException {

		return Optional.of(TENANT);
	}

	@Override
	public Tenant getCurrentTenant() throws TenantNotAvailableException, TenantAccessException {
		return TENANT;
	}

	@Override
	public Optional<Tenant> getCurrentTenantIfAvailable() throws TenantAccessException {
		return Optional.of(TENANT);
	}

	@Override
	public Try<Tenant> tryGetCurrentTenant() {
		return Try.success(TENANT);
	}

}
