package com.greenfox.Controller;

import com.greenfox.Model.ToDo;
import com.greenfox.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by georgezsiga on 5/9/17.
 */
@Controller("/todo")
public class ToDoController {

  @Autowired
  private ToDoRepository toDoRepository;

  @RequestMapping("/")
  public String home(Model model) {
    model.addAttribute("todo", toDoRepository.findAll());
    return "todolist";
  }

  @RequestMapping("/list")
  public String list(@RequestParam(value = "isActive", required = false) Boolean active, Model model) {
    if (active != null) {
      model.addAttribute("todo", toDoRepository.findByisDone(active));
      return "todolist";
    }
    model.addAttribute("todo", toDoRepository.findAll());
    return "todolist";
  }

  @RequestMapping("/add")
  public String add() {
    return "add";
  }

  @RequestMapping("/addform")
  public String addform(String title, Model model) {
    toDoRepository.save(new ToDo(title));
    return "redirect:/";
  }

  @RequestMapping("/{id}/delete")
  public String delete(@PathVariable long id) {
    toDoRepository.delete(id);
    return "redirect:/";
  }

}
