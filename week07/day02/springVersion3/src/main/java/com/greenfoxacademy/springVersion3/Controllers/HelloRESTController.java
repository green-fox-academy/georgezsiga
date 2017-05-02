package com.greenfoxacademy.springVersion3.Controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by georgezsiga on 5/2/17.
 */
@RestController
public class HelloRESTController {
  AtomicLong atomicLong = new AtomicLong(1);

  @RequestMapping("/greeting")
  @ResponseBody
  public Greeting greeting(@RequestParam("name") String name) {

    Greeting greet = new Greeting(atomicLong.get(),"hello" + " " + name);
    long expectedvalue = atomicLong.get();
    long newValue = atomicLong.get() + 1;
    atomicLong.compareAndSet(expectedvalue, newValue);
    return greet;
  }

}
