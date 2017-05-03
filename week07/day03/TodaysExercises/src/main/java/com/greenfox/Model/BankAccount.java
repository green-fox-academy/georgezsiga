package com.greenfox.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by georgezsiga on 5/3/17.
 */
@RequiredArgsConstructor
@AllArgsConstructor
public class BankAccount {

  @Getter String name;
  @Getter String animalType;
  @Getter double balance;
  @Getter String goodOrBad;
}
