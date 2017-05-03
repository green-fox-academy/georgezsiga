package com.greenfox.Controller;

import com.greenfox.Model.BankAccount;
import java.util.ArrayList;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by georgezsiga on 5/3/17.
 */
@Controller
public class RestController {

  ArrayList<BankAccount> accounts = new ArrayList<>();

  @RequestMapping("/exercise1")
  public String exercise1(Model model) {
    BankAccount account = new BankAccount("Simba", "lion", "2000");
    accounts.add(account);
    model.addAttribute("animalAccount", accounts);
    return "exercise1";
  }

}
