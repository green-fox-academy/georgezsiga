package com.greenfoxacademy.springVersion3.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by georgezsiga on 5/2/17.
 */
@RestController
public class HelloRESTController {

  @RequestMapping("/greeting")
  @ResponseBody
  public Greeting greeting(@RequestParam("name") String name) {
    Greeting greet = new Greeting(1, "hello" + " " + name);
    return greet;
  }

}
