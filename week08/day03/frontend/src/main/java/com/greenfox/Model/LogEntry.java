package com.greenfox.Model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by georgezsiga on 5/10/17.
 */
@Getter
@Setter
public class LogEntry {

  LocalDateTime createdAt;
  String endpoint;
  String data;

}
