import java.util.ArrayList;

/**
 * Created by georgezsiga on 4/5/17.
 */
public class Sum {

  ArrayList<Integer> list;
  int sum;

  public Sum(ArrayList<Integer> name) {
    this.list = name;
  }

  public Sum() {
  }

  public ArrayList<Integer> getList() {
    return list;
  }

  public void addIntegers(int a) {
    list.add(a);
  }

  public int sumList() {
    for (Integer aint : list) {
      sum = sum + aint;
    }
    return sum;
  }
}
