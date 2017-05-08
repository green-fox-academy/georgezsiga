package com.greenfox.Controller;

import com.greenfox.Model.Pikachu;
import com.greenfox.Model.TypeOfPokemons;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by georgezsiga on 5/4/17.
 */
@Controller
public class MainController {

  Pikachu pikachu;
  ArrayList<Pikachu> poke = new ArrayList<>();

  @RequestMapping("/")
  public String homepage(@RequestParam(value = "name", required = false) String name, Model model, Model list, Model action,
      Model age) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        model.addAttribute("pikachu", p);
        list.addAttribute("listOfTricks", p.getListOfTricks());
        if (p.getActionHistory().get(0).startsWith("Went to sleep")) {
          return "redirect:/sleep?name=" + p.getName();
        } else {
          action.addAttribute("actionHistory", p.getActionHistory());
          Period ageOfPikachu = Period.between(p.getDob(), LocalDate.now());
          age.addAttribute("age", ageOfPikachu.getDays());
          writePokemonsToFile();
          return "index";
        }
      }
    }
    return "redirect:/login";
  }

  @RequestMapping("/login")
  public String login(@RequestParam(value = "error", required = false) String errormessage, Model pokemon, Model type, Model message) {
    readPokemonsFromFile();
    pokemon.addAttribute("pokemon", poke);
    type.addAttribute("type", TypeOfPokemons.values());
      message.addAttribute("message", errormessage);
    return "login";
  }

  @RequestMapping(value = "/loginform", method = RequestMethod.POST)
  public String loginform(@RequestParam(value="name", required = false) String name, @RequestParam(value = "callerid", required = false) String callerid) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
        if (p.getName().equals(name)) {
          return "redirect:/?name=" + name;
        }
    }
    return "redirect:/login?error=wrongcallerid";
  }

  @RequestMapping("/signupform")
  public String signupform(String type, String nameofpokemon, String newcallerid) {
    pikachu = new Pikachu(nameofpokemon, type, newcallerid);
    poke.add(pikachu);
    writePokemonsToFile();
    return "redirect:/?name=" + nameofpokemon;
  }

  @RequestMapping("/sleep")
  public String sleep(@RequestParam(value = "name", required = false) String name, Model model, Model action, Model age) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        if (p.getActionHistory().get(0).startsWith("Went to sleep")) {

        } else {
          String actionSleep = "Went to sleep on " + LocalDate.now() + " at " + LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
          p.addAction(actionSleep);
        }
        model.addAttribute("pikachu", p);
        action.addAttribute("actionHistory", p.getActionHistory());
        Period ageOfPikachu = Period.between(p.getDob(), LocalDate.now());
        age.addAttribute("age", ageOfPikachu.getDays());
        writePokemonsToFile();
      }
    }
    return "sleep";
  }

  @RequestMapping("/dead")
  public String dead(@RequestParam(value = "name", required = false) String name, Model model) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        model.addAttribute("pikachu", p);
      }
    }
    return "dead";
  }

  @RequestMapping("/new")
  public String startAgain(@RequestParam(value = "name", required = false) String name) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        poke.remove(p);
        writePokemonsToFile();
      }
    }
    return "redirect:/login";
  }

  @RequestMapping("/wakeup")
  public String wakeUp(@RequestParam(value = "name", required = false) String name) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        String wakeUp = "Woke up on " + LocalDate.now() + " at " + LocalTime
            .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
        p.addAction(wakeUp);
        p.setHappiness(p.getHappiness() + 10);
        p.setWeight(p.getWeight() - 10);
        if (p.isDead()) {
          String dead = "Pikachu died on " + LocalDate.now() + " at " + LocalTime
              .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
          p.addAction(dead);
          return "redirect:/dead?name=" + name;
        } else {
          writePokemonsToFile();

        }
      }
    }
    return "redirect:/?name=" + name;
  }

  @RequestMapping("/nutritionStore")
  public String nutritionStore(@RequestParam(value = "name", required = false) String name, Model model) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        model.addAttribute("pikachu", p);
      }
      }
    return "nutritionStore";
  }

  @RequestMapping("/nutritionform")
  public String nutritionForm(@RequestParam(value = "name", required = false) String name, Model model, String food, String drink) {
    if (food.equals("")) {
      food = "nothing";
    }
    if (drink.equals("")) {
      drink = "nothing";
    }
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        String action =
            "Food has been changed from " + p.getFood() + " to " + food + " on " + LocalDate
                .now()
                + " at " + LocalTime
                .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
        model.addAttribute("pikachu", p);
        p.addAction(action);
        p.setHappiness(p.getHappiness() + 2);
        p.setWeight(p.getWeight() + 5);
        action =
            "Drink has been changed from " + p.getDrink() + " to " + drink + " on "
                + LocalDate
                .now() + " at " + LocalTime
                .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
        p.addAction(action);
        p.setHappiness(p.getHappiness() + 2);
        p.setWeight(p.getWeight() + 5);
        p.setFood(food);
        p.setDrink(drink);
        writePokemonsToFile();
      }
    }
    return "redirect:/?name=" + name;
  }

  @RequestMapping("/trickCenter")
    public String trickCenter(@RequestParam(value = "name", required = false) String name, Model model, Model list) {
      readPokemonsFromFile();
      for (Pikachu p : poke) {
        if (p.getName().equals(name)) {
          model.addAttribute("pikachu", p);
          list.addAttribute("tricks", p.getTricks());
        }
      }
    return "trickCenter";
  }

  @RequestMapping("/trickform")
  public String trickForm(@RequestParam(value = "name", required = false) String name, String trick) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        String action =
            "Learned to " + trick + " at the Trick Center on " + LocalDate.now() + " at "
                + LocalTime
                .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
        p.addAction(action);
        p.addTrick(trick);
        p.setHappiness(p.getHappiness() + 2);
        writePokemonsToFile();
      }
    }
    return "redirect:/?name=" + name;
  }

  @RequestMapping("/newtrickform")
  public String newTrickForm(@RequestParam(value = "name", required = false) String name, String newTrick) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        p.getTricks().add(newTrick);
        String action =
            "Signed up for a course on " + newTrick + " at the Trick Center on " + LocalDate.now()
                + " at " + LocalTime
                .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
        p.addAction(action);
        p.setHappiness(p.getHappiness() + 2);
        writePokemonsToFile();
      }
    }
    return "redirect:/?name=" + name;
  }

  @RequestMapping("/actionHistory")
  public String actionHistory(@RequestParam(value = "name", required = false) String name, Model model, Model action) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        model.addAttribute("pikachu", p);
        action.addAttribute("actionHistory", p.getActionHistory());
      }
    }
    return "actionHistory";
  }

  public void writePokemonsToFile() {
    try {
      FileOutputStream f = new FileOutputStream(new File("pokemon.txt"));
      ObjectOutputStream o = new ObjectOutputStream(f);
      o.writeObject(poke);
      o.close();
    } catch (Exception e) {
      System.out.println("Houston, we have a problem");
    }
  }

  public void readPokemonsFromFile() {
    try {
      FileInputStream fi = new FileInputStream(new File("pokemon.txt"));
      ObjectInputStream oi = new ObjectInputStream(fi);
      poke = (ArrayList<Pikachu>) oi.readObject();
      oi.close();
    } catch (Exception e) {
      System.out.println(e);
      System.out.println("Houston, we have a problem");
    }
  }

}
