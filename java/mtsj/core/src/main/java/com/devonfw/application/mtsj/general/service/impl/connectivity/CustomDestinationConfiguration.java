package com.devonfw.application.mtsj.general.service.impl.connectivity;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "s4destinations")
public class CustomDestinationConfiguration {

	private List<CustomDestinationProperties> destinations;

	public List<CustomDestinationProperties> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<CustomDestinationProperties> destinations) {
		this.destinations = destinations;
	}

}
