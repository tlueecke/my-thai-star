package io.oasp.application.mtsj.bookingmanagement.logic.base;

import io.oasp.application.mtsj.bookingmanagement.common.api.Booking;
import io.oasp.application.mtsj.bookingmanagement.common.api.InvitedGuest;

/**
 * Listener interface which can be implemented by depending components in order to get notified about changes to
 * entities for the booking management.
 */
public interface BookingManagementListener {

    /**
     * {@link Booking} was deleted
     * 
     * @param bookingId
     */
    void bookingDeleted(Long bookingId);

    /**
     * An {@link InvitedGuest} was deleted or declined the invitation.
     * 
     * @param invitedGuestId
     */
    void invitationDeletedOrDeclined(Long invitedGuestId);

}
