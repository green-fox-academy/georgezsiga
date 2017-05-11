package com.greenfox.Controller;

import com.greenfox.Model.Links;
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
import java.util.regex.Pattern;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

  public String randomNumber() {
    int a = (int) (Math.random() * 10);
    int b = (int) (Math.random() * 10);
    int c = (int) (Math.random() * 10);
    int d = (int) (Math.random() * 10);
    int e = (int) (Math.random() * 10);
    return Integer.toString(a) + Integer.toString(b) + Integer.toString(c) + Integer.toString(d)
        + Integer.toString(e);
  }

  @RequestMapping("/")
  public String homepage(@RequestParam(value = "name", required = false) String name,
      @RequestParam(value = "random", required = false) String random, Model model, Model list,
      Model action, Model age, Model links) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        if (p.getActionHistory().get(0).equals(random)) {
          p.getActionHistory().remove(0);
          if (p.getActionHistory().get(0).startsWith("Went to sleep")) {
            random = randomNumber();
            p.addAction(random);
            writePokemonsToFile();
            return "redirect:/sleep?name=" + p.getName() + "&random=" + random;
          } else {
            model.addAttribute("pikachu", p);
            list.addAttribute("listOfTricks", p.getListOfTricks());
            action.addAttribute("actionHistory", p.getActionHistory());
            Period ageOfPikachu = Period.between(p.getDob(), LocalDate.now());
            age.addAttribute("age", ageOfPikachu.getDays());
            links.addAttribute("links", Links.values());
            random = randomNumber();
            p.addAction(random);
            writePokemonsToFile();
            return "index";
          }
        } else {
          return "redirect:/login?error=logout";
        }

      }
    }
    return "redirect:/login";
  }

  @RequestMapping("/login")
  public String login(@RequestParam(value = "error", required = false) String errormessage,
      Model pokemon, Model type, Model message) {
    readPokemonsFromFile();
    pokemon.addAttribute("pokemon", poke);
    type.addAttribute("type", TypeOfPokemons.values());
    message.addAttribute("message", errormessage);
    return "login";
  }

  @RequestMapping(value = "/loginform", method = RequestMethod.POST)
  public String loginform(@RequestParam("name") String name,
      @RequestParam("callerid") String callerid) {
    Pattern spec = Pattern.compile("[^a-zA-Z0-9]");
    if (spec.matcher(name).find()) {
      return "redirect:/login?error=specialcharacter";
    } else {
      if (spec.matcher(callerid).find()) {
        return "redirect:/login?error=specialcharacter";
      }
    }
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name) && p.getCallerId().equals(callerid)) {
        String random = randomNumber();
        p.addAction(random);
        writePokemonsToFile();
        return "redirect:/?name=" + name + "&random=" + random;
      }
    }
    return "redirect:/login?error=wrongcallerid";
  }

  @RequestMapping(value = "/signupform", method = RequestMethod.POST)
  public String signupform(@RequestParam("type") String type,
      @RequestParam("nameofpokemon") String nameofpokemon,
      @RequestParam("newcallerid") String newcallerid) {
    Pattern spec = Pattern.compile("[^a-zA-Z0-9]");
    if (spec.matcher(nameofpokemon).find()) {
      return "redirect:/login?error=specialcharacter";
    } else {
      if (spec.matcher(newcallerid).find()) {
        return "redirect:/login?error=specialcharacter";
      }
    }
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(nameofpokemon)) {
        return "redirect:/login?error=nameistaken";
      } else {

      }
    }
    pikachu = new Pikachu(nameofpokemon, type, newcallerid);
    poke.add(pikachu);
    String random = randomNumber();
    pikachu.addAction(random);
    writePokemonsToFile();
    return "redirect:/?name=" + nameofpokemon + "&random=" + random;
  }

  @RequestMapping("/sleep")
  public String sleep(@RequestParam(value = "name") String name,
      @RequestParam(value = "random", required = false) String random, Model model,
      Model action, Model age) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        if (p.getActionHistory().get(0).equals(random)) {
          p.getActionHistory().remove(0);
          if (p.getActionHistory().get(0).startsWith("Went to sleep")) {

          } else {
            String actionSleep = "Went to sleep on " + LocalDate.now() + " at " + LocalTime
                .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
            p.addAction(actionSleep);
          }
          model.addAttribute("pikachu", p);
          action.addAttribute("actionHistory", p.getActionHistory());
          Period ageOfPikachu = Period.between(p.getDob(), LocalDate.now());
          age.addAttribute("age", ageOfPikachu.getDays());
          random = randomNumber();
          p.addAction(random);
          writePokemonsToFile();
        } else {
          return "redirect:/login?error=logout";
        }
      }
    }
    return "sleep";
  }

  @RequestMapping("/dead")
  public String dead(@RequestParam("name") String name,
      @RequestParam(value = "random") String random) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        if (p.getActionHistory().get(0).equals(random)) {
          poke.remove(p);
          writePokemonsToFile();
          return "redirect:/login";
        } else {
          return "redirect:/login?error=logout";
        }

      }
    }
    return "dead";
  }

  @RequestMapping("/about")
  public String about() {
    return "about";
  }

  @RequestMapping("/wakeup")
  public String wakeUp(@RequestParam("name") String name, @RequestParam("random") String random) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        if (p.getActionHistory().get(0).equals(random)) {
          p.getActionHistory().remove(0);
          String wakeUp = "Woke up on " + LocalDate.now() + " at " + LocalTime
              .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
          p.addAction(wakeUp);
          p.setHappiness(p.getHappiness() + 10);
          p.setWeight(p.getWeight() - 10);
          if (p.isDead()) {
            String dead = "Pikachu died on " + LocalDate.now() + " at " + LocalTime
                .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
            p.addAction(dead);
            random = randomNumber();
            p.addAction(random);
            writePokemonsToFile();
            return "redirect:/dead?name=" + name + "&random=" + random;
          } else {
            random = randomNumber();
            p.addAction(random);
            writePokemonsToFile();
          }
        } else {
          return "redirect:/login?error=logout";
        }
      }

    }
    return "redirect:/?name=" + name + "&random=" + random;
  }

  @RequestMapping("/nutritionStore")
  public String nutritionStore(@RequestParam("name") String name,
      @RequestParam("random") String random,
      Model model) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        if (p.getActionHistory().get(0).equals(random)) {
          p.getActionHistory().remove(0);
          model.addAttribute("pikachu", p);
          random = randomNumber();
          p.addAction(random);
          writePokemonsToFile();
        } else {
          return "redirect:/login?error=logout";
        }
      }

    }
    return "nutritionStore";
  }

  @RequestMapping(value = "/nutritionform", method = RequestMethod.POST)
  public String nutritionForm(@RequestParam("name") String name,
      @RequestParam("random") String random,
      Model model, String food, String drink) {
    if (food.equals("")) {
      food = "nothing";
    }
    if (drink.equals("")) {
      drink = "nothing";
    }
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        if (p.getActionHistory().get(0).equals(random)) {
          p.getActionHistory().remove(0);
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
          random = randomNumber();
          p.addAction(random);
          writePokemonsToFile();
        } else {
          return "redirect:/login?error=logout";
        }
      }

    }
    return "redirect:/?name=" + name + "&random=" + random;
  }

  @RequestMapping("/trickCenter")
  public String trickCenter(@RequestParam("name") String name,
      @RequestParam("random") String random,
      Model model, Model list) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        if (p.getActionHistory().get(0).equals(random)) {
          p.getActionHistory().remove(0);
          model.addAttribute("pikachu", p);
          list.addAttribute("tricks", p.getTricks());
          random = randomNumber();
          p.addAction(random);
          writePokemonsToFile();
        } else {
          return "redirect:/login?error=logout";
        }
      }

    }
    return "trickCenter";
  }

  @RequestMapping(value = "/trickform", method = RequestMethod.POST)
  public String trickForm(@RequestParam("name") String name, @RequestParam("random") String random,
      String trick) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        if (p.getActionHistory().get(0).equals(random)) {
          p.getActionHistory().remove(0);
          String action =
              "Learned to " + trick + " at the Trick Center on " + LocalDate.now() + " at "
                  + LocalTime
                  .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
          p.addAction(action);
          p.addTrick(trick);
          p.setHappiness(p.getHappiness() + 2);
          random = randomNumber();
          p.addAction(random);
          writePokemonsToFile();
        } else {
          return "redirect:/login?error=logout";
        }
      }

    }
    return "redirect:/?name=" + name + "&random=" + random;
  }

  @RequestMapping(value = "/newtrickform", method = RequestMethod.POST)
  public String newTrickForm(@RequestParam("name") String name,
      @RequestParam("random") String random,
      String newTrick) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        if (p.getActionHistory().get(0).equals(random)) {
          p.getActionHistory().remove(0);
          p.getTricks().add(newTrick);
          String action =
              "Signed up for a course on " + newTrick + " at the Trick Center on " + LocalDate.now()
                  + " at " + LocalTime
                  .of(LocalTime.now().getHour(), LocalTime.now().getMinute());
          p.addAction(action);
          p.setHappiness(p.getHappiness() + 2);
          random = randomNumber();
          p.addAction(random);
          writePokemonsToFile();
        } else {
          return "redirect:/login?error=logout";
        }
      }

    }
    return "redirect:/?name=" + name + "&random=" + random;
  }

  @RequestMapping("/actionHistory")
  public String actionHistory(@RequestParam("name") String name,
      @RequestParam("random") String random,
      Model model, Model action) {
    readPokemonsFromFile();
    for (Pikachu p : poke) {
      if (p.getName().equals(name)) {
        if (p.getActionHistory().get(0).equals(random)) {
          p.getActionHistory().remove(0);
          model.addAttribute("pikachu", p);
          action.addAttribute("actionHistory", p.getActionHistory());
          random = randomNumber();
          p.addAction(random);
          writePokemonsToFile();
        } else {
          return "redirect:/login?error=logout";
        }
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
