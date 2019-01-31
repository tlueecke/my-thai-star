package com.devonfw.application.mtss4sdk.bookingmanagement.logic.api.to;

import com.devonfw.application.mtss4sdk.general.common.api.to.AbstractSearchCriteriaTo;

/**
 * used to find {@link com.devonfw.application.mtsj.bookingmanagement.common.api.Table}s.
 */
public class TableSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Integer seatsNumber;

  /**
   * The constructor.
   */
  public TableSearchCriteriaTo() {

    super();
  }

  public Integer getSeatsNumber() {

    return this.seatsNumber;
  }

  public void setSeatsNumber(Integer seatsNumber) {

    this.seatsNumber = seatsNumber;
  }

}
