/**
 * Created by georgezsiga on 4/5/17.
 */
public class Sharpie {

  String color;
  float width;
  int inkAmount;
  String name;

  public Sharpie(String color, float width) {
    this.color = color;
    this.width = width;
    inkAmount = 0;
    this.name = color;
  }

  public void use() {
    inkAmount -= 1;
  }
}
