/**
 * Created by georgezsiga on 4/10/17.
 */
public class Tile extends GameObject {
  boolean isWall;

  public boolean isWall() {
    return isWall;
  }

  public Tile(String filename, int posX, int posY) {
    super(filename, posX, posY);
  }

}
