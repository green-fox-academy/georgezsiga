/**
 * Created by georgezsiga on 4/5/17.
 */
public class Apple {
  public String apple;

  public Apple(String apple) {
    this.apple = apple;
  }

  public String getApple() {
    System.out.println(apple);
    return apple + apple;
  }
}
