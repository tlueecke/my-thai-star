package io.oasp.application.mtsj.general.gui.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Delegates all angular routes to the index.html supporting the HTML5 history feature as well as application links send
 * via mail.
 */
@Controller
public class ViewController {

  /**
   * @return the forward to index.html
   */
  @RequestMapping({ "/booking/**", "/restaurant", "/menu", "/bookTable", "/orders", "/reservations" })
  public String index() {

    return "forward:/index.html";
  }
}
