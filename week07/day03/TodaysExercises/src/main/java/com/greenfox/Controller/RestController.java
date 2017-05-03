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
    BankAccount account = new BankAccount("Simba", "lion", 2000);
    accounts.add(account);
    model.addAttribute("animalAccount", accounts);
    return "exercise1";
  }

  @RequestMapping("/exercise4")
  public String exercise4(Model input) {
    input.addAttribute("string", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
    return "exercise4";
  }

}
