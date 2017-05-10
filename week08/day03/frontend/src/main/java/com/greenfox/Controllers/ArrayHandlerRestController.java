package com.greenfox.Controllers;

import com.greenfox.Model.ArrayHandler;
import com.greenfox.Model.Arrays;
import com.greenfox.Model.Error;
import com.greenfox.Model.Result;
import com.greenfox.Model.Result2;
import com.greenfox.Model.Result3;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
  public Result results(@RequestBody ArrayHandler incoming) {
if (incoming.getWhat().equals("sum")) {
  Result3 r = new Result3("sum", incoming.getNumbers());
  return r;
} else if (incoming.getWhat().equals("multiply")) {
  Result3 r2 = new Result3("multiply", incoming.getNumbers());
  return r2;
} else {
  Result2 r3 = new Result2(incoming.getNumbers());
  return r3;
}
  }
}
