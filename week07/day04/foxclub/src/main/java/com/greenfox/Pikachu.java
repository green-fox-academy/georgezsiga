package com.greenfox;

import java.util.ArrayList;
import lombok.Getter;

/**
 * Created by georgezsiga on 5/4/17.
 */
public class Pikachu {

  @Getter String name;
  @Getter String food;
  @Getter String drink;
  @Getter
  ArrayList<String> listOfTricks;

  public Pikachu(String name, String food, String drink) {
    this.name = name;
    this.food = food;
    this.drink = drink;
    this.listOfTricks = new ArrayList<>();
  }

  @Override
  public String toString() {
    if (listOfTricks.size() == 0) {
      return "This is " + name +
          ". Currently living on " + food +
          " and " + drink +
          ". He knows 0 tricks.";
    }
    return "This is " + name +
        ". Currently living on " + food +
        " and " + drink +
        ". He knows " + listOfTricks.size() + " tricks.";
  }
}
