package com.greenfox.Model;

/**
 * Created by georgezsiga on 5/7/17.
 */
public enum TypeOfPokemons {
  PIKACHU("pikachu"),
  CHARMANDER("charmander"),
  GROWLITHE("growlithe"),
  MACHOP("machop"),
  SNORLAX("snorlax"),
  BAYLEEF("bayleef"),
  FURRET("furret"),
  TEDDIURSA("teddiursa");

  private final String name;

  TypeOfPokemons(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
