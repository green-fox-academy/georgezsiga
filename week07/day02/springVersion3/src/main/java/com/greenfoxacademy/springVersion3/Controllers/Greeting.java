package com.greenfoxacademy.springVersion3.Controllers;

import java.util.concurrent.atomic.AtomicLong;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by georgezsiga on 5/2/17.
 */
@RequiredArgsConstructor
@AllArgsConstructor
public class Greeting {

  @Getter
  long id;
  @Getter
  String content;

  @Override
  public String toString() {
    return id + " " + content;
  }
}
