package com.devonfw.application.mtss4sdk.bookingmanagement.logic.api.to;

import java.util.List;

import javax.validation.Valid;

import com.devonfw.application.mtss4sdk.ordermanagement.logic.api.to.OrderEto;
import com.devonfw.application.mtss4sdk.usermanagement.logic.api.to.UserEto;
import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Booking
 */
public class BookingCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  @Valid
  private BookingEto booking;

  private TableEto table;

  private List<InvitedGuestEto> invitedGuests;

  private OrderEto order;

  private List<OrderEto> orders;

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

  public OrderEto getOrder() {

    return this.order;
  }

  public void setOrder(OrderEto order) {

    this.order = order;
  }

  public List<OrderEto> getOrders() {

    return this.orders;
  }

  public void setOrders(List<OrderEto> orders) {

    this.orders = orders;
  }

  public UserEto getUser() {

    return this.user;
  }

  public void setUser(UserEto user) {

    this.user = user;
  }

}
