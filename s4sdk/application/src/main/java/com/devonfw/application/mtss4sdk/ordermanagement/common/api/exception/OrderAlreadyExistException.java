package com.devonfw.application.mtss4sdk.ordermanagement.common.api.exception;

import com.devonfw.application.mtss4sdk.bookingmanagement.dataaccess.api.BookingEntity;
import com.devonfw.application.mtss4sdk.ordermanagement.dataaccess.api.OrderEntity;

import net.sf.mmm.util.exception.api.NlsRuntimeException;

/**
 * This exception is thrown if a {@link BookingEntity} has already
 * {@link OrderEntity} related.
 *
 */
public class OrderAlreadyExistException extends NlsRuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public OrderAlreadyExistException() {
		super("The order for this booking already exist. Please cancel the order before create a new one.");
	}
}
