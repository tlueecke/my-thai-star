package io.oasp.application.mtsj.ordermanagement.logic.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.oasp.application.mtsj.bookingmanagement.logic.base.InvitationListener;
import io.oasp.application.mtsj.ordermanagement.logic.api.Ordermanagement;
import io.oasp.application.mtsj.ordermanagement.logic.api.to.OrderCto;
import io.oasp.application.mtsj.ordermanagement.logic.api.to.OrderSearchCriteriaTo;

/**
 * Implementation of the {@link InvitationListener} purging the orders when the corresponding invited guest does not
 * come.
 */
@Named
public class OrdermanagementInvitationListener implements InvitationListener {

  @Inject
  private Ordermanagement orderManagement;

  @Override
  public void invitationDeletedOrDeclined(Long invitedGuestId) {

    OrderSearchCriteriaTo guestOrderCriteria = new OrderSearchCriteriaTo();
    guestOrderCriteria.setInvitedGuestId(invitedGuestId);
    List<OrderCto> guestOrdersCto = this.orderManagement.findOrderCtos(guestOrderCriteria).getResult();
    for (OrderCto orderCto : guestOrdersCto) {
      this.orderManagement.deleteOrder(orderCto.getOrder().getId());
    }
  }

}
