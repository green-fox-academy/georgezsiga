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
  String owner = "no owner";
  int vote;

  public Post(String title, String href) {
    this.title = title;
    this.href = href;
    this.timestamp = new Timestamp(System.currentTimeMillis());
    this.score = 0;
    this.vote = 0;
  }

  public Post(String title, String href, String owner) {
    this(title, href);
    this.owner = owner;
  }
}
