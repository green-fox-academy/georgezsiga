import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/5/17.
 */
public class Sum {
  ArrayList<Integer> list;

  public Sum() {
    this.list = new ArrayList<>();
  }

  public void addIntegers(int a) {
    list.add(a);
  }

  public int sumList() {
    int sum = 0;
    for (Integer aint : list) {
      sum = sum + aint;
    }
    return sum;
  }

}
