package com.greenfox.Controller;

import com.greenfox.Repository.LogentryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by georgezsiga on 5/10/17.
 */
@Controller("/logentry")
public class LogentryController {

  @Autowired
  private LogentryRepository logentryRepository;

}
