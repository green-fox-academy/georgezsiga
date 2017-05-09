package com.greenfox.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.NoArgsConstructor;

/**
 * Created by georgezsiga on 5/9/17.
 */
@Entity
@NoArgsConstructor
public class ToDo {

  @Column
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id;

  @Column
  String title;

  @Column
  boolean isUrgent = false;

  @Column
  boolean isDone = false;


  public ToDo(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return title;
  }
}
