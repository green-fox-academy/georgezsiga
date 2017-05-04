package com.greenfox.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by georgezsiga on 5/4/17.
 */
@RequiredArgsConstructor
@AllArgsConstructor
public class Pikachu implements Serializable {

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
  @Getter
  ArrayList<String> actionHistory;
  @Getter
  LocalDate dob;
  @Getter
  LocalTime time;


  public Pikachu(String name, String food, String drink) {
    this.name = name;
    this.food = food;
    this.drink = drink;
    this.listOfTricks = new ArrayList<>();
    listOfTricks.add("You doesn`t know any tricks yet. Go and learn some!");
    this.tricks = new ArrayList<>();
    tricks.add("Walk on the moon");
    tricks.add("Sleep");
    tricks.add("Eat");
    this.actionHistory = new ArrayList<>();
    this.dob = LocalDate.now();
    this.time = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
    actionHistory.add(name + " was born on " + dob + " at " + time);
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
      if (listOfTricks.get(0).equals("You doesn`t know any tricks yet. Go and learn some!")) {
        listOfTricks = new ArrayList<>();
        listOfTricks.add(trick + " - learned it on " + LocalDate.now());
        tricks.remove(trick);
      } else {
        listOfTricks.add(trick + " - learned it on " + LocalDate.now());
        tricks.remove(trick);
      }
    }
  }

  public void addAction(String action) {
    actionHistory.add(0, action);
  }

  @Override
  public String toString() {
    if (listOfTricks.get(0).equals("You doesn`t know any tricks yet. Go and learn some!")) {
      return "This is " + name +
          ". Currently eats " + food +
          " and drinks " + drink +
          ". He doesn`t know any tricks.";
    }
    return "This is " + name +
        ". Currently eats " + food +
        " and drinks " + drink +
        ". He knows " + listOfTricks.size() + " tricks.";
  }

}
