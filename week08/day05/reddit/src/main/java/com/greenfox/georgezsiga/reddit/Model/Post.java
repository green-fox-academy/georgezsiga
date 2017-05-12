package com.greenfox.georgezsiga.reddit.Model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by georgezsiga on 5/12/17.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Post {

  @javax.persistence.Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  String title;
  String href;
  Timestamp timestamp;
  int score;
  String owner;
  int vote;

  public Post(String title, String href, String owner) {
    this.title = title;
    this.href = href;
    this.timestamp = new Timestamp(System.currentTimeMillis() / 1000);
    this.score = 0;
    this.owner = owner;
    this.vote = 0;
  }
}
