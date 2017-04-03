/**
 * Created by georgezsiga on 4/3/17.
 */
public class Counter {
  int value;
  int initialValue;


  public Counter() {
    value = 0;
    this.initialValue = value;
  }

  public Counter(int value) {
    this.value = value;
    this.initialValue = value;
  }

  public void add(int number) {
    this.value = value + number;

  }

  public void add() {
    value +=1;
  }

  public int get() {
    return value;
  }

  public void reset() {
  value = initialValue;
  }
}
