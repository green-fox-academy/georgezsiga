package com.greenfox.Model;

/**
 * Created by georgezsiga on 5/15/17.
 */
public class Groot {

  String received;
  String translated;

  public Groot(String received) {
    this.received = received;
    this.translated = "I am Groot!";
  }

  public String getReceived() {
    return received;
  }

  public void setReceived(String received) {
    this.received = received;
  }

  public String getTranslated() {
    return translated;
  }

  public void setTranslated(String translated) {
    this.translated = translated;
  }
}
