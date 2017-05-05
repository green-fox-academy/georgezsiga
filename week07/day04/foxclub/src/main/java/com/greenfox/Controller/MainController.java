package com.greenfox.Controller;

import com.greenfox.Model.Pikachu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
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
  public String homepage(Model model, Model list, Model action, Model age) {
    readPikachuFromFile();
    model.addAttribute("pikachu", pikachu);
    list.addAttribute("listOfTricks", pikachu.getListOfTricks());
    if (pikachu.getActionHistory().get(0).startsWith("Went to sleep")) {
      return "redirect:/sleep";
    } else {
      action.addAttribute("actionHistory", pikachu.getActionHistory());
      Period ageOfPikachu = Period.between(pikachu.getDob(), LocalDate.now());
      age.addAttribute("age", ageOfPikachu.getDays());
      writePikachuToFile();
      return "index";
    }
  }

  @RequestMapping("/sleep")
  public String sleep(Model action, Model age) {
    readPikachuFromFile();
    if (pikachu.getActionHistory().get(0).startsWith("Went to sleep")) {

    } else {
      String actionSleep = "Went to sleep on " + LocalDate.now() + " at " + LocalTime
          .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
      pikachu.addAction(actionSleep);
    }
    action.addAttribute("actionHistory", pikachu.getActionHistory());
    Period ageOfPikachu = Period.between(pikachu.getDob(), LocalDate.now());
    age.addAttribute("age", ageOfPikachu.getDays());
    writePikachuToFile();
    return "sleep";
  }

  @RequestMapping("/dead")
  public String dead() {
    return "dead";
  }

  @RequestMapping("/new")
  public String startAgain() {
    readPikachuFromFile();
    pikachu = new Pikachu("New Pikachu", "Banana", "Water");
    writePikachuToFile();
    return "redirect:/";
  }

  @RequestMapping("/wakeup")
  public String wakeUp() {
    String wakeUp = "Woke up on "+ LocalDate.now() + " at " + LocalTime
        .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
    pikachu.addAction(wakeUp);
    pikachu.setHappiness(pikachu.getHappiness()+10);
    pikachu.setWeight(pikachu.getWeight()-10);
    if (pikachu.isDead()) {
      String dead = "Pikachu died on "+ LocalDate.now() + " at " + LocalTime
          .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
      pikachu.addAction(dead);
      return "redirect:/dead";
    } else {
    writePikachuToFile();
    return "redirect:/";
    }
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
    pikachu.setHappiness(pikachu.getHappiness()+2);
    pikachu.setWeight(pikachu.getWeight()+5);
    action = "Drink has been changed from " + pikachu.getDrink() + " to " + drink + " on " + LocalDate.now() + " at " + LocalTime
        .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
    pikachu.addAction(action);
    pikachu.setHappiness(pikachu.getHappiness()+2);
    pikachu.setWeight(pikachu.getWeight()+5);
    pikachu.setFood(food);
    pikachu.setDrink(drink);
    writePikachuToFile();
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
    pikachu.setHappiness(pikachu.getHappiness()+2);
    writePikachuToFile();
    return "redirect:/";
  }

  @RequestMapping("/newtrickform")
  public String newTrickForm(String newTrick) {
    pikachu.getTricks().add(newTrick);
    String action = "Signed up for a course on " + newTrick + " at the Trick Center on " + LocalDate.now() + " at " + LocalTime
        .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
    pikachu.addAction(action);
    pikachu.setHappiness(pikachu.getHappiness()+2);
    writePikachuToFile();
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
