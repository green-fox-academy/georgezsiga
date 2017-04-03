/**
 * Created by georgezsiga on 4/3/17.
 */
public class PostIt {

  String backgroundColor;
  String text;
  String textColor;

  public PostIt(String backgroundColor, String text, String textColor) {
    this.backgroundColor = backgroundColor;
    this.text = text;
    this.textColor = textColor;
  }

  public static void main(String[] args) {
    PostIt nr1 = new PostIt("BLUE", "Szia", "RED");
    PostIt nr2 = new PostIt("RED", "Whatsup", "GREEN");
    PostIt nr3 = new PostIt("GREEN", "Ooooooo", "BLACK");
  }

}
