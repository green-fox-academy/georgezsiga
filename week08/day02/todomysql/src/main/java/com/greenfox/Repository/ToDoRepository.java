package com.greenfox.Repository;

import com.greenfox.Model.ToDo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by georgezsiga on 5/9/17.
 */
public interface ToDoRepository extends CrudRepository<ToDo, Long> {

}
