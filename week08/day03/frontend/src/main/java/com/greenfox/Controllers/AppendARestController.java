package com.greenfox.Controllers;

import com.greenfox.Model.AppendA;
import com.greenfox.Model.Error;
import com.greenfox.Model.Greeter;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by georgezsiga on 5/10/17.
 */
@RestController
public class AppendARestController {

  Error e = new Error();

  @ExceptionHandler(Exception.class)
  public String handleAllExceptions() {
    return "Error happend";
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public Error exception(MissingServletRequestParameterException er) {

    return e;
  }

  @GetMapping("/appenda/{appendable}")
  public AppendA appendA(@PathVariable String appendable) {
    AppendA a = new AppendA(appendable);
    return a;
  }

}
