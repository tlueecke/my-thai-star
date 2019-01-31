package com.devonfw.application.mtss4sdk.usermanagement.common.api;

import com.devonfw.application.mtss4sdk.general.common.api.ApplicationEntity;

public interface User extends ApplicationEntity {

  public String getUsername();

  public void setUsername(String username);

  public String getPassword();

  public void setPassword(String password);

  public String getEmail();

  public void setEmail(String email);

  public Long getUserRoleId();

  public void setUserRoleId(Long userRoleId);

}
