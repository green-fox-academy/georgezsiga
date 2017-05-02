package com.greenfoxacademy.springVersion3.Controllers;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by georgezsiga on 5/2/17.
 */
@Controller
public class MultiLanguage {

  AtomicLong atomicLong = new AtomicLong(1);
  ArrayList<Greeting> entries = new ArrayList<>();
  String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj",
      "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
      "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló",
      "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
      "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry",
      "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
      "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae",
      "Sholem Aleychem", "Sawubona"};

  public String getRandomColor() {
    String letters = "0123456789ABCDEF";
    String color = "#";
    for (int i = 0; i < 6; i++ ) {
      color += letters.charAt((int) Math.random() * 16);
    }
    return color;
  }

  @RequestMapping("/languages")
  public String languages(@RequestParam("name") String name, Model list, Model color) {

    for (String hello : hellos) {
      Greeting greet = new Greeting(atomicLong.get(),hello + " " + name);
      entries.add(greet);
      long expectedvalue = atomicLong.get();
      long newValue = atomicLong.get() + 1;
      atomicLong.compareAndSet(expectedvalue, newValue);
    }
    list.addAttribute("entries", entries);
    color.addAttribute("color", "blue");
    return "languages";
  }
}
