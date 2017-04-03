/**
 * Created by georgezsiga on 4/3/17.
 */
public class Sharpie {

  String color;
  float width;
  float inkAmount;

  @Override
  public String toString() {
    return "Sharpie " +
        "color= " + color +
        ", width= " + width +
        ", inkAmount= " + inkAmount;
  }

  public Sharpie(String color, float width) {
    this.color = color;
    this.width = width;
    inkAmount = 100;
  }

  public void use() {
    inkAmount -= 1;
  }

  public static void main(String[] args) {
    Sharpie blue = new Sharpie("blue", 12);
    blue.use();
    System.out.println(blue);
  }
}
