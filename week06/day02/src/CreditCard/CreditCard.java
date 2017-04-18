package CreditCard;

/**
 * Created by georgezsiga on 4/18/17.
 */
public class CreditCard implements CreditCardy{

  final String format = "Name=%s CC#=%s CVV=%d";
  String ccNumber;

  public CreditCard() {
    this.ccNumber = randomCcNumber();

  }

  public String randomCcNumber() {
    String numbers = "0123456789";
    String ccNr = "";
    for (int i = 0; i < 16 ; i++) {
      int nr = (int) (Math.random()*10);
      ccNr = ccNr + numbers.charAt(nr);
    }
    return ccNr;
  }

  @Override
  public int getSumCVV() {
    return 0;
  }

  @Override
  public String getNameCardholder() {
    return null;
  }

  @Override
  public String getCodeAccount() {
    return null;
  }

  @Override
  public int cumeSumCVV(String codeAccount) {
    return 0;
  }

  @Override
  public String toString() {
    return String.format(format, getNameCardholder(), CreditCard(), cumeSumCVV());
  }
}
