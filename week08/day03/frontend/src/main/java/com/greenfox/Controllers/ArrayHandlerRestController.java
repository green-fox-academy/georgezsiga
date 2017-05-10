package com.greenfox.Controllers;

import com.greenfox.Model.Arrays;
import com.greenfox.Model.DoUntil;
import com.greenfox.Model.Error;
import com.greenfox.Model.Result;
import com.greenfox.Model.Until;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by georgezsiga on 5/10/17.
 */
@RestController
public class ArrayHandlerRestController {

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

  @PostMapping("/arrays")
  public Result doUntil(@RequestBody Arrays incoming) {
    Result r = new Result(incoming.getWhat(), incoming.getNumbers());
    return r;
  }
}
