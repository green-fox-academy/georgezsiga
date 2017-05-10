package com.greenfox.Model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Created by georgezsiga on 5/10/17.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Logentry {

  @Column
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  LocalDateTime createdAt;
  String endpoint;
  String data;

  public Logentry(String endpoint, String data) {
    this.createdAt = LocalDateTime.now();
    this.endpoint = endpoint;
    this.data = data;
  }
}
