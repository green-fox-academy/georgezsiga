package com.greenfoxacademy.springVersion3.Controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by georgezsiga on 5/2/17.
 */
@RequiredArgsConstructor
@AllArgsConstructor
public class Language {

  @Getter
  String content;

  @Getter
  String color;

  @Getter
  int size;
}
