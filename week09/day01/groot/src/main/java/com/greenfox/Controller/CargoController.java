package com.greenfox.Controller;

import com.greenfox.Model.Cargo;
import com.greenfox.Model.Error;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by georgezsiga on 5/15/17.
 */
@RestController
public class CargoController {
  Error e;

  @ExceptionHandler(Exception.class)
  public String handleAllExceptions() {
    return "Error happend";
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public Error exception(MissingServletRequestParameterException er) {
    e = new Error("I am Groot!");
    return e;
  }

  @GetMapping("/rocket")
  public Cargo groot() {
    Cargo cargo = new Cargo();
    return cargo;
  }
}
