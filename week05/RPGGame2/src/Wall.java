/**
 * Created by georgezsiga on 4/10/17.
 */
public class Wall extends Tile {

  public Wall(int posX, int posY) {
    super("assets/wall.png", posX, posY);
    this.isWall = true;
  }
}
