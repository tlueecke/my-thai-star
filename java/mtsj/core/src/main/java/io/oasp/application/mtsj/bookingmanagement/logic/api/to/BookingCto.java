package io.oasp.application.mtsj.bookingmanagement.logic.api.to;

import java.util.List;

import io.oasp.application.mtsj.general.common.api.to.AbstractCto;
import io.oasp.application.mtsj.usermanagement.logic.api.to.UserEto;

/**
 * Composite transport object of Booking
 */
public class BookingCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private BookingEto booking;

  private TableEto table;

  private List<InvitedGuestEto> invitedGuests;

  private UserEto user;

  public BookingEto getBooking() {

    return this.booking;
  }

  public void setBooking(BookingEto booking) {

    this.booking = booking;
  }

  public TableEto getTable() {

    return this.table;
  }

  public void setTable(TableEto table) {

    this.table = table;
  }

  public List<InvitedGuestEto> getInvitedGuests() {

    return this.invitedGuests;
  }

  public void setInvitedGuests(List<InvitedGuestEto> invitedGuests) {

    this.invitedGuests = invitedGuests;
  }

  public UserEto getUser() {

    return this.user;
  }

  public void setUser(UserEto user) {

    this.user = user;
  }

}
