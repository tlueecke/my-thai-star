package com.devonfw.application.mtsj.usermanagement.service.impl.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.devonfw.application.mtsj.usermanagement.logic.api.to.PartnerEto;
import com.devonfw.application.mtsj.usermanagement.service.api.rest.PartnermanagementRestService;
import com.devonfw.application.mtsj.usermanagement.service.impl.rest.command.GetAllBusinessPartnersCommand;
import com.devonfw.module.beanmapping.common.api.BeanMapper;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartner;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.BusinessPartnerService;

@Named("PartnermanagementRestService")
public class PartnermanagementRestServiceImpl implements PartnermanagementRestService {

	@Inject
	private BusinessPartnerService businessPartnerService;

	@Inject
	private BeanMapper beanMapper;

	@Override
	public List<PartnerEto> findAllBusinessPartners() {
		// Note: for simplity no paginated result is returned. This should easily be
		// implementable however based on skip() and top() methods of fluent api
		GetAllBusinessPartnersCommand command = new GetAllBusinessPartnersCommand(businessPartnerService);
		List<BusinessPartner> partners = command.execute();
		return beanMapper.mapList(partners, PartnerEto.class);
	}

}
