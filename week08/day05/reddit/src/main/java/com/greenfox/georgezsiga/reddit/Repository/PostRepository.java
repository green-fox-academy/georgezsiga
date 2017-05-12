package com.greenfox.georgezsiga.reddit.Repository;

import com.greenfox.georgezsiga.reddit.Model.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by georgezsiga on 5/12/17.
 */
public interface PostRepository extends CrudRepository<Post, Long> {

}
