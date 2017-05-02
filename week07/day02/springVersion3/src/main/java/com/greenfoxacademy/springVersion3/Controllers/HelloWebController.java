package com.greenfoxacademy.springVersion3.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by georgezsiga on 5/2/17.
 */
@Controller
public class HelloWebController {

  @RequestMapping("/web/greeting")
  public String greeting(Model model) {
    model.addAttribute("name", " World");
    return "greeting";
  }

}
