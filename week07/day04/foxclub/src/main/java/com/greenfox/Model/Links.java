package com.greenfox.Model;

/**
 * Created by georgezsiga on 5/12/17.
 */
public enum Links {
  INFORMATION(" - Information - ", "/", " Well.. err.. the homepage "),
  NUTRITIONSTORE(" - Nutrition Store - ", "/nutritionStore",
      " You are what you eat. Give me Fooood!! "),
  TRICKCENTER(" - Trick Center - ", "/trickCenter", " Knowledge is power! Let`s learn something! "),
  ACTIONHISTORY(" - Action History - ", "/actionHistory",
      " Check out what your Poke did recently "),
  SLEEP(" - Go to sleep - ", "/sleep", " Even pokemons needs to sleep "),
  LOGIN(" - Logout - ", "/login", " If you have better things to do... ");

  private final String text;
  private final String link;
  private final String title;

  Links(String text, String link, String title) {
    this.text = text;
    this.link = link;
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public String getLink() {
    return link;
  }

  public String getTitle() {
    return title;
  }
}
