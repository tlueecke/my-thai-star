package com.devonfw.application.mtsj.general.service.impl.connectivity;

import java.util.Optional;

import com.devonfw.application.mtsj.usermanagement.logic.api.to.UserCto;
import com.devonfw.application.mtsj.usermanagement.logic.api.to.UserEto;
import com.sap.cloud.sdk.cloudplatform.security.user.AbstractUserFacade;
import com.sap.cloud.sdk.cloudplatform.security.user.User;
import com.sap.cloud.sdk.cloudplatform.security.user.exception.UserAccessDeniedException;
import com.sap.cloud.sdk.cloudplatform.security.user.exception.UserAccessException;

// Note: via RequestContextAccessor we could get access to the request and actually retrieve the user!
public class CustomUserFacade extends AbstractUserFacade {

	@Override
	public Class<? extends User> getUserClass() {
		return UserCto.class;
	}

	@Override
	public Optional<User> resolveCurrentUser() throws UserAccessException {
		return Optional.of(newMockedUser());
	}

	@Override
	public Optional<User> getUserByName(String name) throws UserAccessDeniedException, UserAccessException {
		return Optional.of(newUser(name));
	}

	@Override
	protected User newMockedUser() {
		return newUser("TECHNICAL_USER");
	}

	private User newUser(String username) {
		UserCto user = new UserCto();
		UserEto userEto = new UserEto();
		userEto.setUsername(username);
		user.setUser(userEto);
		return user;
	}

}
