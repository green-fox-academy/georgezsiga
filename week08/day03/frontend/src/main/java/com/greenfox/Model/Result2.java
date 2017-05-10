package com.greenfox.Model;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by georgezsiga on 5/10/17.
 */
@Getter
@Setter
public class Result2 extends Result {

  int[] result;

  public Result2(ArrayList<Integer> numbers) {
  this.result = doubles(numbers);
  }

  public static int[] doubles(ArrayList<Integer> numbers) {
    int[] doubled = new int[4];
    doubled[0] = numbers.get(0)*2;
    doubled[1] = numbers.get(1)*2;
    doubled[2] = numbers.get(2)*2;
    doubled[3] = numbers.get(3)*2;
    return doubled;
  }
}
