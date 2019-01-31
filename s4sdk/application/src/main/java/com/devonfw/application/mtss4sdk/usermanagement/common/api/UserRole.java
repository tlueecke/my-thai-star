package com.devonfw.application.mtss4sdk.usermanagement.common.api;

import com.devonfw.application.mtss4sdk.general.common.api.ApplicationEntity;

public interface UserRole extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public Boolean getActive();

  public void setActive(Boolean active);

}
