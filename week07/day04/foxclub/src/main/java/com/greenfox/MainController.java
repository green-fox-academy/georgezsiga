package com.greenfox;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by georgezsiga on 5/4/17.
 */
@Controller
public class MainController {

  @RequestMapping("/")
  public String homepage() {
    return "index";
  }
}
