package com.greenfox.georgezsiga.reddit.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by georgezsiga on 5/12/17.
 */
@CrossOrigin("*")
@org.springframework.stereotype.Controller
public class Controller {

  @RequestMapping("/")
  public String homepage() {
    return "index";
  }

}
