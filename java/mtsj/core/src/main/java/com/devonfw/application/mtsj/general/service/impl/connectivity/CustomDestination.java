package com.devonfw.application.mtsj.general.service.impl.connectivity;

import java.net.URI;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Optional;

import com.sap.cloud.sdk.cloudplatform.connectivity.AbstractDestination;
import com.sap.cloud.sdk.cloudplatform.connectivity.AuthenticationType;
import com.sap.cloud.sdk.cloudplatform.connectivity.exception.DestinationAccessException;

public class CustomDestination extends AbstractDestination {

	public CustomDestination(String name, String destinationUrl) {
		super(name, "Custom configured destination", URI.create(destinationUrl), AuthenticationType.NO_AUTHENTICATION,
				null, null, null, false, null, null, null, null, new HashMap<>());
	}

	@Override
	public Optional<KeyStore> getTrustStore() throws DestinationAccessException {
		// not supported yet
		return Optional.empty();
	}

	@Override
	public Optional<KeyStore> getKeyStore() throws DestinationAccessException {
		// not supported yet
		return Optional.empty();
	}

}
