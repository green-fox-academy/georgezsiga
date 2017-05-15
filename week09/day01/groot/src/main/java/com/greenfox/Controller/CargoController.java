package com.greenfox.Controller;

import com.greenfox.Logic.Logic;
import com.greenfox.Model.Caliber50;
import com.greenfox.Model.Cargo;
import com.greenfox.Model.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by georgezsiga on 5/15/17.
 */
@RestController
public class CargoController {
  Error e;

  Logic logic = new Logic();

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
  public Cargo rocket() {
    return logic.getCargo();
  }

  @GetMapping("/rocket/fill")
  public Caliber50 rocketFill(@RequestParam("caliber") String caliber, @RequestParam("amount") int amount) {
    logic.addCaliber(caliber, amount);
    return logic.getCaliber50();
  }
}
