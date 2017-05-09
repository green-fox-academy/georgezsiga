package com.greenfox.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by georgezsiga on 5/9/17.
 */
@Controller("/todo")
public class ToDoController {

  @RequestMapping("/")
  @ResponseBody
  public String home(Model model) {

    return "This is my first todo";
  }

  @RequestMapping("/list")
  @ResponseBody
  public String list(Model model) {

    return "This is my first todo";
  }
}
