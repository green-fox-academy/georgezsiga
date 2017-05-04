package com.greenfox.Controller;

import com.greenfox.Model.Pikachu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
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
    readPikachuFromFile();
    model.addAttribute("pikachu", pikachu);
    list.addAttribute("listOfTricks", pikachu.getListOfTricks());
    writePikachuToFile();
    return "index";
  }

  @RequestMapping("/nutritionStore")
  public String nutritionStore() {
    return "nutritionStore";
  }

  @RequestMapping("/nutritionform")
  public String nutritionForm(String food, String drink) {
    if (food.equals("")) food = "nothing";
    if (drink.equals("")) drink = "nothing";
    String action = "Food has been changed from " + pikachu.getFood() + " to " + food + " on " + LocalDate.now() + " at " + LocalTime
        .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
    pikachu.addAction(action);
    action = "Drink has been changed from " + pikachu.getDrink() + " to " + drink + " on " + LocalDate.now() + " at " + LocalTime
        .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
    pikachu.addAction(action);
    pikachu.setFood(food);
    pikachu.setDrink(drink);
    return "redirect:/";
  }

  @RequestMapping("/trickCenter")
  public String trickCenter(Model list) {
    list.addAttribute("tricks", pikachu.getTricks());
    return "trickCenter";
  }

  @RequestMapping("/trickform")
  public String trickForm(String trick) {
    String action = "Learned to " + trick + " at the Trick Center on " + LocalDate.now() + " at " + LocalTime
        .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
    pikachu.addAction(action);
    pikachu.addTrick(trick);
    return "redirect:/";
  }

  @RequestMapping("/actionHistory")
  public String actionHistory(Model model) {
    model.addAttribute("actionHistory", pikachu.getActionHistory());
    return "actionHistory";
  }

  public void writePikachuToFile() {
    try {
      FileOutputStream f = new FileOutputStream(new File("pikachu.txt"));
      ObjectOutputStream o = new ObjectOutputStream(f);
      o.writeObject(pikachu);
      o.close();
    } catch (Exception e) {
      System.out.println("Houston, we have a problem");
    }
  }

  public void readPikachuFromFile() {
    try {
      FileInputStream fi = new FileInputStream(new File("pikachu.txt"));
      ObjectInputStream oi = new ObjectInputStream(fi);
      pikachu = (Pikachu) oi.readObject();
      oi.close();
    } catch (Exception e) {
      System.out.println("Houston, we have a problem");
    }
  }

}
