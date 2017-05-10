package com.greenfox.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Created by georgezsiga on 5/10/17.
 */
@Entity
@NoArgsConstructor
public class Logentry {

  @Column
  @Id
  @Getter
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  public Logentry() {
  }
}
