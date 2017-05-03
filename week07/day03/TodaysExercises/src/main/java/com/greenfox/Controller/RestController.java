package com.greenfox.Controller;

import com.greenfox.Model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by georgezsiga on 5/3/17.
 */
@Controller
public class RestController {

  @RequestMapping("/exercise1")
  public String exercise1(Model model) {
    BankAccount account = new BankAccount("Simba", "lion", "2000");
    model.addAttribute("animalAccount", account);
    return "exercise1";
  }

}
