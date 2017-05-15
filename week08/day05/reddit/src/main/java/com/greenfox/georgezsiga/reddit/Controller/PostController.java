package com.greenfox.georgezsiga.reddit.Controller;

import com.greenfox.georgezsiga.reddit.Model.Post;
import com.greenfox.georgezsiga.reddit.Model.Posts;
import com.greenfox.georgezsiga.reddit.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by georgezsiga on 5/12/17.
 */
@RestController("/post")
@CrossOrigin("*")
public class PostController {

  Posts posts;

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
    postRepository.save(post);
    return post;
  }

  @PutMapping("/posts/{id}/upvote")
  public Post upVote(@PathVariable Long id) {
    postRepository.findOne(id).upVote();
    postRepository.save(postRepository.findOne(id));
    return postRepository.findOne(id);
  }

  @PutMapping("/posts/{id}/downvote")
  public Post DownVote(@PathVariable Long id) {
    postRepository.findOne(id).downVote();
    postRepository.save(postRepository.findOne(id));
    return postRepository.findOne(id);
  }
}
