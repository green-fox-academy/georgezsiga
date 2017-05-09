package com.greenfox.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by georgezsiga on 5/9/17.
 */
@Entity
@NoArgsConstructor
public class ToDo {

  @Column
  @Id
  @Getter
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id;

  @Column
  @Getter
  String title;

  @Column

  boolean isUrgent = false;

  @Column

  boolean isDone = false;

  public boolean getIsUrgent() {
    return isUrgent;
  }

  public boolean getIsDone() {
    return isDone;
  }

  public ToDo(String title) { this.title = title;
  }


}
