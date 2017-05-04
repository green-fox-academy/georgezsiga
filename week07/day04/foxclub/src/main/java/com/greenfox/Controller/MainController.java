package com.greenfox.Controller;

import com.greenfox.Model.Pikachu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by georgezsiga on 5/4/17.
 */
@Controller
public class MainController {

  @RequestMapping("/")
  public String homepage(Model model, Model list) {
    Pikachu pikachu = new Pikachu("Mr. Pikachu", "Strawberry", "Smoothie");
    model.addAttribute("pikachu", pikachu);
    list.addAttribute("listOfTricks", pikachu.getListOfTricks());
    return "index";
  }
}
