package com.greenfoxacademy.springVersion3.Controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by georgezsiga on 5/2/17.
 */
@RestController
public class MultiLanguage {
  AtomicLong atomicLong = new AtomicLong(0);

  @RequestMapping("/languages")
  @ResponseBody
  public String greeting(@RequestParam("name") String name) {
    String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
        "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
        "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
        "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};
    String output = "";

    for (String hello: hellos) {
      output = output + atomicLong.get() + " " + hello + " " + name + "\n";
      long expectedvalue = atomicLong.get();
      long newValue = atomicLong.get() + 1;
      atomicLong.compareAndSet(expectedvalue, newValue);
    }
return output;
  }

}
