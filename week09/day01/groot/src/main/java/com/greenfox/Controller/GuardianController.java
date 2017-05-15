package com.greenfox.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by georgezsiga on 5/15/17.
 */
@RestController
public class GuardianController {


  @GetMapping("/groot")
  public Posts getPosts() {
    posts = new Posts();
    posts.setPosts(postRepository.findAll());
    return posts;
  }
}
