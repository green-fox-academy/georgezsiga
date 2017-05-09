package com.greenfox.Controller;

import com.greenfox.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by georgezsiga on 5/9/17.
 */
@Controller("/todo")
public class ToDoController {

  @Autowired
  private Repository repository;

  @RequestMapping("/")
  public String home(Model model) {

    return "todolist";
  }

  @RequestMapping("/list")
  public String list(Model model) {

    return "todolist";
  }
}
