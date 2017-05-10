package com.greenfox.Repository;

import com.greenfox.Model.Logentry;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by georgezsiga on 5/10/17.
 */
public interface LogentryRepository extends CrudRepository<Logentry, Long> {

}
