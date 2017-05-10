package com.greenfox.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by georgezsiga on 5/10/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class DoUntil {

  Integer result;

  public DoUntil(Integer until, String what) {
    if (what.equals("sum")) {
      this.result = count(until);
    } else if (what.equals("factor")) {
      this.result = factor(until);
    }
  }

  public static int count(int number) {
    if (number == 0) {
      return 0;
    } else {
      return number + count(--number);
    }
  }

  public static int factor(int number) {
    if (number == 1) {
      return 1;
    } else {
      return number * count(--number);
    }
  }
}

