package com.greenfox.Controllers;

import com.greenfox.Model.Error;
import com.greenfox.Model.Greeter;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by georgezsiga on 5/10/17.
 */
@RestController
public class GreeterRestController {

  Error e = new Error();

  @ExceptionHandler(Exception.class)
  public String handleAllExceptions() {
    return "Error happend";
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public Error exception(MissingServletRequestParameterException er) {
    e.setError("Please provide a " + er.getParameterName() + "!");
    return e;
  }

  @GetMapping("/greeter")
  public Greeter greeter(@RequestParam("name") String name, @RequestParam("title") String title) {
    Greeter g = new Greeter(name, title);
    return g;
  }

}
