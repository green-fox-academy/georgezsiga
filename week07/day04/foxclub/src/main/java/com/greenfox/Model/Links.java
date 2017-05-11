package com.greenfox.Model;

/**
 * Created by georgezsiga on 5/12/17.
 */
public enum Links {
  INFORMATION("Information", "/", ""),
  NUTRITIONSTORE("Nutrition Store", "/", ""),
  TRICKCENTER("Trick Center", "/", ""),
  ACTIONHISTORY("Action History", "/", ""),
  SLEEP("Go to sleep", "/", ""),
  LOGIN("Logout", "/", "");

  private final String name;

  TypeOfPokemons(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
