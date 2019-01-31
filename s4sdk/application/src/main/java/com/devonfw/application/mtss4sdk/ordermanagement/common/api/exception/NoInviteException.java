package com.devonfw.application.mtss4sdk.ordermanagement.common.api.exception;

import com.devonfw.application.mtss4sdk.bookingmanagement.dataaccess.api.BookingEntity;
import com.devonfw.application.mtss4sdk.ordermanagement.logic.api.to.OrderEto;

import net.sf.mmm.util.exception.api.NlsRuntimeException;

/**
 * This exception is thrown if the guest token of an {@link OrderEto} has no
 * {@link BookingEntity} related.
 *
 */
public class NoInviteException extends NlsRuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public NoInviteException() {
		super("The invitation does not exist");
	}
}
