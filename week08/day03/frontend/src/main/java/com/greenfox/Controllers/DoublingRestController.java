package com.greenfox.Controllers;

import com.greenfox.Model.Doubling;
import com.greenfox.Model.Error;
import com.greenfox.Model.Greeter;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by georgezsiga on 5/10/17.
 */

@org.springframework.web.bind.annotation.RestController
public class DoublingRestController {

  Doubling d = new Doubling();
  Error e = new Error();

  @ExceptionHandler(Exception.class)
  public String handleAllExceptions() {
    return "Error happend";
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public Error exception(MissingServletRequestParameterException er) {
    e.setError("Please provide an input!");
    return e;
  }

  @GetMapping("/doubling")
  public Doubling doubling(@RequestParam("input") Integer number) {
    d.setReceived(number);
    d.setResult(number * 2);
    return d;
  }

}
