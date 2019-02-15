package com.devonfw.application.mtsj.usermanagement.service.impl.rest.command;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.sap.cloud.sdk.cloudplatform.cache.CacheKey;
import com.sap.cloud.sdk.cloudplatform.logging.CloudLoggerFactory;
import com.sap.cloud.sdk.s4hana.connectivity.CachingErpCommand;
import com.sap.cloud.sdk.s4hana.datamodel.odata.helper.Order;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartner;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.BusinessPartnerService;

public class GetAllBusinessPartnersCommand extends CachingErpCommand<List<BusinessPartner>> {
	private static final Logger logger = CloudLoggerFactory.getLogger(GetAllBusinessPartnersCommand.class);

	private static final String CATEGORY_PERSON = "1";

	private final BusinessPartnerService service;

	private static final Cache<CacheKey, List<BusinessPartner>> cache = CacheBuilder.newBuilder().maximumSize(50)
			.expireAfterWrite(15, TimeUnit.MINUTES).build();

	public GetAllBusinessPartnersCommand(final BusinessPartnerService service) {
		super(GetAllBusinessPartnersCommand.class);
		this.service = service;
	}

	@Override
	protected CacheKey getCommandCacheKey() {
		return CacheKey.ofTenantIsolation();
	}

	@Override
	protected Cache<CacheKey, List<BusinessPartner>> getCache() {
		return cache;
	}

	@Override
	protected List<BusinessPartner> getFallback() {
		logger.warn("Fallback called due to ", getExecutionException());
		List<BusinessPartner> cachedResult = cache.getIfPresent(getCommandCacheKey());
		return cachedResult != null ? cachedResult : Collections.emptyList();
	}

	@Override
	protected List<BusinessPartner> runCacheable() throws Exception {
		logger.info("Retrieving all business partners ");
		List<BusinessPartner> partners = service.getAllBusinessPartner()
				.select(BusinessPartner.BUSINESS_PARTNER, BusinessPartner.LAST_NAME, BusinessPartner.FIRST_NAME)
				.filter(BusinessPartner.BUSINESS_PARTNER_CATEGORY.eq(CATEGORY_PERSON))
				.orderBy(BusinessPartner.LAST_NAME, Order.ASC).execute();
		logger.info("Retrieved " + partners.size());
		return partners;
	}

}
