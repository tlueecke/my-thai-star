package io.oasp.application.mtsj.bookingmanagement.logic.impl;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import io.oasp.application.mtsj.SpringBootApp;
import io.oasp.application.mtsj.bookingmanagement.logic.api.Bookingmanagement;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * Tests for {@link Bookingmanagement} component.
 *
 */
@SpringApplicationConfiguration(classes = SpringBootApp.class)
@WebAppConfiguration
public class BookingmanagementTest extends ComponentTest {

  @Inject
  private Bookingmanagement management;

  @Before
  public void initMocks() {

    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void declineInvite() {

    assertThat(this.management.findInvitedGuest(0L).getAccepted()).isTrue();
    this.management.declineInvite("GB_20170510_02350266501Z");
    assertThat(this.management.findInvitedGuest(0L).getAccepted()).isFalse();
  }

  @Test
  public void deleteInvitedGuestNotifiesListener() {

    assertThat(this.management.findInvitedGuest(1L)).isNotNull();
    this.management.deleteInvitedGuest(1L);
    assertThat(this.management.findInvitedGuest(1L)).isNull();
  }
}
