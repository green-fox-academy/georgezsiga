package com.greenfox.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by georgezsiga on 5/10/17.
 */
@Controller
public class MainController {

  @RequestMapping("/")
  public String homepage() {
    return "index";
  }

}
