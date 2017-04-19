package Screen;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by georgezsiga on 4/19/17.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Monitor {

  String aspectRatio() default "4:3";
  String classification() default "TFT";
}
