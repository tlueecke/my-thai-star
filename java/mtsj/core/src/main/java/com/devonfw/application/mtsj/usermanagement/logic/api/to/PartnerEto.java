package com.devonfw.application.mtsj.usermanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractEto;

public class PartnerEto extends AbstractEto {

	private static final long serialVersionUID = -5553345230171831290L;

	private String businessPartner;
	private String firstName;
	private String lastName;
	private String businessPartnerCategory;

	public String getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(String businessPartner) {
		this.businessPartner = businessPartner;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBusinessPartnerCategory() {
		return businessPartnerCategory;
	}

	public void setBusinessPartnerCategory(String businessPartnerCategory) {
		this.businessPartnerCategory = businessPartnerCategory;
	}

}
