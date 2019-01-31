package com.devonfw.application.mtsj.dishmanagement.common.api;

import java.math.BigDecimal;

import com.devonfw.application.mtsj.general.common.api.ApplicationEntity;

public interface Ingredient extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public String getDescription();

  public void setDescription(String description);

  public BigDecimal getPrice();

  public void setPrice(BigDecimal price);

}
