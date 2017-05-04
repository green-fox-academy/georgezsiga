package com.greenfox.Model;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by georgezsiga on 5/4/17.
 */
@RequiredArgsConstructor
@AllArgsConstructor
public class Pikachu {

  @Getter
  String name;
  @Getter
  String food;
  @Getter
  String drink;
  @Getter
  ArrayList<String> listOfTricks;
  @Getter
  ArrayList<String> tricks;


  public Pikachu(String name, String food, String drink) {
    this.name = name;
    this.food = food;
    this.drink = drink;
    this.listOfTricks = new ArrayList<>();
    listOfTricks.add("You know no tricks yet. Go and learn some!");
    this.tricks = new ArrayList<>();
    tricks.add("Walk on the moon");
    tricks.add("Sleep");
    tricks.add("Eat");
  }

  public void setFood(String food) {
    this.food = food;
  }

  public void setDrink(String drink) {
    this.drink = drink;
  }

  public void addTrick(String trick) {
    if (listOfTricks.contains(trick)) {

    } else {
      if (listOfTricks.get(0).equals("You know no tricks yet. Go and learn some!")) {
        listOfTricks = new ArrayList<>();
        listOfTricks.add(trick);
        tricks.remove(trick);
      } else {
        listOfTricks.add(trick);
        tricks.remove(trick);
      }
    }
  }

  @Override
  public String toString() {
    if (listOfTricks.get(0).equals("You know no tricks yet. Go and learn some!")) {
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
