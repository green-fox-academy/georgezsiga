package com.greenfox.Controllers;

import com.greenfox.Model.Doubling;
import com.greenfox.Model.Error;
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
public class RestController {

  Doubling d = new Doubling();
  Error e = new Error();

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public Error exception() {
    e.setError("Please provide an input!");
    return e;
  }

  @GetMapping("/doubling")
  public Doubling doubling(@RequestParam("input") Integer number) {
    d.setReceived(number);
    d.setResult(number*2);
  return d;
  }

//  @RequestMapping(value = "/greeter", method = RequestMethod.GET)
//  @ResponseBody
//  public String greeter(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "title", required = false) String title) {
//
//    if (name == null || title == null)
//      return "{\n"
//          + "  \"error\": \"Please provide a name, and title!\"\n"
//          + "}";
//    return "{\n"
//        + "  \"welcome_message\": \"Oh, hi there "
//        + name
//        + ", my dear "
//        + title
//        + "!\"\n"
//        + "}";
//  }
//
//  @RequestMapping(value = "/appenda/{appendable}", method = RequestMethod.GET)
//  @ResponseBody
//  public String appenda(@PathVariable String appendable) {
//    if (appendable == null) {
//
//    }
//    return "{\n"
//        + "  \"appended\": \""
//        + appendable
//        + "a\"\n"
//        + "}";
//  }

//  @RequestMapping(value = "/dountil/{what}", method = RequestMethod.GET)
//  @ResponseBody
//  public String dountil(@PathVariable String what) {
//
//    return "{\n"
//        + "  \"appended\": \""
//        + appendable
//        + "a\"\n"
//        + "}";
//  }
}
