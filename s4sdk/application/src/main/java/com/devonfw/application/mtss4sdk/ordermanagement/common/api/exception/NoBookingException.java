package com.devonfw.application.mtss4sdk.ordermanagement.common.api.exception;

import com.devonfw.application.mtss4sdk.bookingmanagement.dataaccess.api.BookingEntity;
import com.devonfw.application.mtss4sdk.ordermanagement.logic.api.to.OrderEto;

import net.sf.mmm.util.exception.api.NlsRuntimeException;

/**
 * This exception is thrown if the token of an {@link OrderEto} has no
 * {@link BookingEntity} related.
 *
 */
public class NoBookingException extends NlsRuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor.
	 *
	 * @param message the error message
	 */
	public NoBookingException() {
		super("The booking does not exist");
	}

}
