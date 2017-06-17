package io.oasp.application.mtsj.bookingmanagement.logic.base;

import io.oasp.application.mtsj.bookingmanagement.common.api.InvitedGuest;

/**
 * Listener interface which can be implemented by depending components in order to be notified about changes to the
 * invitations.
 */
public interface InvitationListener {

  /**
   * An {@link InvitedGuest} was deleted or declined the invitation.
   *
   * @param invitedGuestId
   */
  void invitationDeletedOrDeclined(Long invitedGuestId);

}
