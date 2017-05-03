package com.greenfox.Controller;

import com.greenfox.Model.BankAccount;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by georgezsiga on 5/3/17.
 */
@Controller
public class RestController {

  ArrayList<BankAccount> accounts = new ArrayList<>();

  @RequestMapping("/exercise1")
  public String exercise1(Model model) {
    BankAccount account = new BankAccount("Simba", "lion", 2000, "Good guy");
    accounts.add(account);
    model.addAttribute("animalAccount", accounts);
    return "exercise1";
  }

  @RequestMapping("/exercise4")
  public String exercise4(Model input) {
    input.addAttribute("string", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
    return "exercise4";
  }

  @RequestMapping("/exercise5")
  public String exercise5(Model model, Model color) {
    BankAccount account = new BankAccount("Simba", "lion", 2000, "Good guy");
    accounts.add(account);
    account = new BankAccount("Mufasa", "lion", 20000, "Good guy");
    accounts.add(account);
    account = new BankAccount("Pumbaa", "pig", 100, "Bad guy");
    accounts.add(account);
    account = new BankAccount("Rafiki", "monkey", 11000, "Bad guy");
    accounts.add(account);
    account = new BankAccount("Zazu", "parrot", 500, "Good guy");
    accounts.add(account);
    model.addAttribute("animalAccount", accounts);
    color.addAttribute("color", "yellow");
    return "exercise5";
  }

  @RequestMapping("/exercise9")
  public String exercise9(Model model, Model color) {
    BankAccount account = new BankAccount("Simba", "lion", 2000, "Good guy");
    accounts.add(account);
    account = new BankAccount("Mufasa", "lion", 20000, "Good guy");
    accounts.add(account);
    account = new BankAccount("Pumbaa", "pig", 100, "Bad guy");
    accounts.add(account);
    account = new BankAccount("Rafiki", "monkey", 11000, "Bad guy");
    accounts.add(account);
    account = new BankAccount("Zazu", "parrot", 500, "Good guy");
    accounts.add(account);
    model.addAttribute("animalAccount", accounts);
    color.addAttribute("color", "yellow");
    return "exercise9";
  }

  @RequestMapping("/exercise10")
  public String exercise10(Model model, Model color) {
    model.addAttribute("animalAccount", accounts);
    color.addAttribute("color", "yellow");
    return "exercise10";
  }

  @RequestMapping("/hit")
  public String hitTheButton(@RequestParam("id") int id) {
    double oldBalance = accounts.get(id).getBalance();
    double newBalance = oldBalance + 10;
    accounts.get(id).setBalance(newBalance);
    return "redirect:/exercise10";
  }

  @RequestMapping("/form")
  public String sendTheForm(String name, String animalType, double balance, String goodOrBad) {
    BankAccount account = new BankAccount(name, animalType, balance, goodOrBad);
    accounts.add(account);
    return "redirect:/exercise10";
  }
}
