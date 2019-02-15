package com.devonfw.application.mtsj.usermanagement.logic.api.to;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import com.devonfw.application.mtsj.bookingmanagement.logic.api.to.BookingEto;
import com.devonfw.application.mtsj.dishmanagement.logic.api.to.DishEto;
import com.devonfw.module.basic.common.api.to.AbstractCto;
import com.sap.cloud.sdk.cloudplatform.security.Authorization;
import com.sap.cloud.sdk.cloudplatform.security.user.User;
import com.sap.cloud.sdk.cloudplatform.security.user.UserAttribute;

/**
 * Composite transport object of User
 */
public class UserCto extends AbstractCto implements User {

	private static final long serialVersionUID = 1L;

	private UserEto user;

	private UserRoleEto userRole;

	private List<BookingEto> bookings;

	private List<DishEto> favourites;

	public UserEto getUser() {

		return this.user;
	}

	public void setUser(UserEto user) {

		this.user = user;
	}

	public UserRoleEto getUserRole() {

		return this.userRole;
	}

	public void setUserRole(UserRoleEto userRole) {

		this.userRole = userRole;
	}

	public List<BookingEto> getBookings() {

		return this.bookings;
	}

	public void setBookings(List<BookingEto> bookings) {

		this.bookings = bookings;
	}

	public List<DishEto> getFavourites() {

		return this.favourites;
	}

	public void setFavourites(List<DishEto> favourites) {

		this.favourites = favourites;
	}

	@Override
	public String getName() {
		return user.getUsername();
	}

	@Override
	public Optional<Locale> getLocale() {
		return Optional.empty();
	}

	@Override
	public boolean hasAuthorization(Authorization authorization) {
		return true;
	}

	@Override
	public Set<Authorization> getAuthorizations() {
		// TODO maybe map roles to authorizations, but what for?
		return Collections.emptySet();
	}

	@Override
	public Optional<UserAttribute> getAttribute(String name) {
		return Optional.empty();
	}

}
