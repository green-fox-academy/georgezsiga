package Controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by georgezsiga on 5/2/17.
 */
@RequiredArgsConstructor
@AllArgsConstructor
public class Greeting {

  @Getter long id;
  @Getter String content;

}
