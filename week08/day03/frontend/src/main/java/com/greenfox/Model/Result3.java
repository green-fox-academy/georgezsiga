package com.greenfox.Model;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by georgezsiga on 5/10/17.
 */
@Getter
@Setter
public class Result3 extends Result {

  Integer result;

  public Result3(String what, ArrayList<Integer> numbers) {
   if (what.equals("sum")) {
     this.result = sum(numbers);
   } else if (what.equals("multiply")) {
     this.result = multiply(numbers);
   }
  }

  public static int sum(ArrayList<Integer> numbers) {
    int total = 0;
    for (int i = 0; i < numbers.size(); i++) {
      total = total + numbers.get(i);
    }
    return total;
  }

  public static int multiply(ArrayList<Integer> numbers) {
    int total =1;
    for (int n : numbers) {
      total = total * n;
    }
    return total;
  }

}
