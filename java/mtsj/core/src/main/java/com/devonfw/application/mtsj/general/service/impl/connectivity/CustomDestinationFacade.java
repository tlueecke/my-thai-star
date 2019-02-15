package com.devonfw.application.mtsj.general.service.impl.connectivity;

import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.devonfw.application.mtsj.general.service.impl.config.ApplicationContextProvider;
import com.sap.cloud.sdk.cloudplatform.connectivity.AbstractDestinationFacade;
import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.GenericDestination;
import com.sap.cloud.sdk.cloudplatform.connectivity.RfcDestination;
import com.sap.cloud.sdk.cloudplatform.connectivity.exception.DestinationAccessException;

public class CustomDestinationFacade extends AbstractDestinationFacade {

	@Inject
	private CustomDestinationConfiguration configuration;

	@Override
	public Class<? extends GenericDestination> getGenericDestinationClass() {
		return CustomDestination.class;
	}

	@Override
	public Class<? extends Destination> getDestinationClass() {
		return CustomDestination.class;
	}

	@Override
	public Class<? extends RfcDestination> getRfcDestinationClass() {
		return null;
	}

	@Override
	public Map<String, GenericDestination> getGenericDestinationsByName() throws DestinationAccessException {
		if (configuration == null) {
			ApplicationContextProvider.getApplicationContext().getAutowireCapableBeanFactory().autowireBean(this);
		}
		return configuration.getDestinations().stream()
				.map(prop -> new CustomDestination(prop.getName(), prop.getUrl()))
				.collect(Collectors.toMap(d -> d.getName(), d -> d));
	}

}
