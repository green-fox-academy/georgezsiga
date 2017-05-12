package com.greenfox.georgezsiga.reddit.Controller;

import com.greenfox.georgezsiga.reddit.Model.Post;
import com.greenfox.georgezsiga.reddit.Model.Posts;
import com.greenfox.georgezsiga.reddit.Repository.PostRepository;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by georgezsiga on 5/12/17.
 */
@RestController("/post")
public class PostController {

  Posts posts;
  Post post;

  @Autowired
  private PostRepository postRepository;

  @GetMapping("/posts")
  public Posts getPosts() {
    posts = new Posts();
    posts.setPosts(postRepository.findAll());
    return posts;
  }

  @PostMapping("/posts")
  public Post postPosts(@RequestBody Post post) {
    post.setTimestamp(new Timestamp(System.currentTimeMillis()));
    postRepository.save(post);
    return post;
  }
}
