package com.greenfox.georgezsiga.reddit.Controller;

import com.greenfox.georgezsiga.reddit.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by georgezsiga on 5/12/17.
 */
@Controller("/post")
public class PostController {

  @Autowired
  private PostRepository postRepository;

}
