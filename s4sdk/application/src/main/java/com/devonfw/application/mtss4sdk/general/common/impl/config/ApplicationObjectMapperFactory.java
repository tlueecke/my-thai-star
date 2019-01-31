package com.devonfw.application.mtss4sdk.general.common.impl.config;

import javax.inject.Named;

import org.springframework.data.domain.Pageable;

import com.devonfw.module.json.common.base.ObjectMapperFactory;
import com.devonfw.module.json.common.base.type.PageableJsonDeserializer;
import com.devonfw.module.json.common.base.type.PageableJsonSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * The MappingFactory class to resolve polymorphic conflicts within the issue_6
 * application.
 */
@Named("ApplicationObjectMapperFactory")
public class ApplicationObjectMapperFactory extends ObjectMapperFactory {

	/**
	 * The constructor.
	 */
	public ApplicationObjectMapperFactory() {

		super();
		SimpleModule module = getExtensionModule();
		// register spring-data Pageable
		module.addSerializer(Pageable.class, new PageableJsonSerializer());
		module.addDeserializer(Pageable.class, new PageableJsonDeserializer());
	}
}
