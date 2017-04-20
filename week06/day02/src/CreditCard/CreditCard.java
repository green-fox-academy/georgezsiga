package CreditCard;

/**
 * Created by georgezsiga on 4/18/17.
 */
public class CreditCard implements CreditCardy{

  final String format = "Name=%s CC#=%s CVV=%d";
  int sum;
  String ccNumber, codeAccount, name;
  int counter = 0;

  public CreditCard(String codeAccount) {
    this.ccNumber = randomCcNumber();
    this.sum = cumeSumCVV(codeAccount);
    this.codeAccount = codeAccount;
    this.counter ++;
    this.name = "ABC" + counter;

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
    return sum;
  }

  @Override
  public String getNameCardholder() {
    return name;
  }

  @Override
  public String getCodeAccount() {
    return codeAccount;
  }

  @Override
  public int cumeSumCVV(String codeAccount) {
    int sum = 0;
    for (int i = 0; i <codeAccount.length() ; i++) {
      sum = sum + codeAccount.charAt(i);
    }
    return sum;
  }

  @Override
  public String toString() {
    return String.format(format, getNameCardholder(), ccNumber, getSumCVV());
  }
}
