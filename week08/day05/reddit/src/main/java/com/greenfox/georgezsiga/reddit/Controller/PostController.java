package com.greenfox.georgezsiga.reddit.Controller;

import com.greenfox.georgezsiga.reddit.Model.Posts;
import com.greenfox.georgezsiga.reddit.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by georgezsiga on 5/12/17.
 */
@RestController("/post")
public class PostController {

  Posts posts;

  @Autowired
  private PostRepository postRepository;

  @GetMapping("/posts")
  public Posts posts() {
    posts = new Posts();
    posts.setPosts(postRepository.findAll());
    return posts;
  }
}
