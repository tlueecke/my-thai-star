package com.devonfw.application.mtsj.usermanagement.service.api.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.devonfw.application.mtsj.general.common.api.Usermanagement;
import com.devonfw.application.mtsj.usermanagement.logic.api.to.PartnerEto;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Usermanagement}.
 */
@Path("/partnermanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PartnermanagementRestService {

	@GET
	@Path("/partner")
	public List<PartnerEto> findAllBusinessPartners();

}
