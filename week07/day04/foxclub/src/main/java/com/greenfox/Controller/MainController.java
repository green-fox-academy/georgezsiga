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
  Pikachu pikachu = new Pikachu("Mr. Pikachu", "Strawberry", "Smoothie");

  @RequestMapping("/")
  public String homepage(Model model, Model list) {
    model.addAttribute("pikachu", pikachu);
    list.addAttribute("listOfTricks", pikachu.getListOfTricks());
    return "index";
  }

  @RequestMapping("/nutritionStore")
  public String nutritionStore(Model model, Model list) {
    model.addAttribute("pikachu", pikachu);
    list.addAttribute("listOfTricks", pikachu.getListOfTricks());
    return "nutritionStore";
  }

  @RequestMapping("/nutritionform")
  public String nutritionForm(String food, String drink) {
    pikachu.setFood(food);
    pikachu.setDrink(drink);
    return "redirect:/";
  }

  @RequestMapping("/trickCenter")
  public String trickCenter(Model model, Model list) {
    model.addAttribute("pikachu", pikachu);
    list.addAttribute("tricks", pikachu.getTricks());
    return "trickCenter";
  }

  @RequestMapping("/trickform")
  public String trickForm(String trick) {
    pikachu.addTrick(trick);
    return "redirect:/";
  }
}
