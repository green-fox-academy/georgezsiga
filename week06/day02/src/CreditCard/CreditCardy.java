package CreditCard;

/**
 * Created by georgezsiga on 4/18/17.
 */
public interface CreditCardy {

  int getSumCVV();

  String getNameCardholder();

  String getCodeAccount();

  int cumeSumCVV(String codeAccount);

  String toString (); //String.format("Name=%s CC#=%s CVV=%d");
}
