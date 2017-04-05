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
    inkAmount = 10;
    this.name = color;
  }


  public float use() {
    if (inkAmount > 0) {
      inkAmount -= 1;
      return inkAmount;
    } else {
      System.out.println("Out of ink");
      return 0;
    }
  }

  public int getInkAmount() {
    return inkAmount;
  }
}
