package com.greenfoxacademy.springVersion3.Controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by georgezsiga on 5/2/17.
 */
@Controller
public class HelloWebController {

  AtomicLong atomicLong = new AtomicLong(0);

  @RequestMapping("/web/greeting")
  public String greeting(@RequestParam("name") String name, Model model, Model id) {
    model.addAttribute("name", name);
    id.addAttribute("id", atomicLong);
    long expectedvalue = atomicLong.get();
    long newValue = atomicLong.get() + 1;
    atomicLong.compareAndSet(expectedvalue, newValue);
    return "greeting";
  }

}
