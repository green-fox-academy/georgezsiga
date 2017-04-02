/**
 * Created by georgezsiga on 4/2/17.
 */
public class Account {
  int a;
  int b;

  public void setData(int a, int b) {
    this. a = a;
    this. b = b;
  }

  public void showData() {
    System.out.println("Valu of A = " +a);
    System.out.println("Valu of B = " +b);
  }
  public static void main(String args[]) {
    Account obj = new Account();
    obj.setData(2,3);
    obj.showData();
  }

}
