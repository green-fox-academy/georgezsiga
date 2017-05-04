package com.greenfox.service;

import lombok.Getter;

/**
 * Created by georgezsiga on 5/4/17.
 */
public class TwitterService implements MessageService {

  @Getter
  String twitter;
  @Getter
  String message;

  @Override
  public void sendingMessage(String twitter, String message) {
    this.twitter = twitter;
    this.message = message;
    System.out.println(toString());
  }

  @Override
  public String toString() {
    return "TwitterService: " +
        "Twitter sent to: " + twitter +
        " with messsage: " + message;
  }
}
