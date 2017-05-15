package com.greenfox.Controller;

import static org.junit.Assert.*;

import com.greenfox.GrootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by georgezsiga on 5/15/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GrootApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class GuardianControllerTest {

  @Test
  public void handleAllExceptions() throws Exception {
  }

  @Test
  public void exception() throws Exception {
  }

  @Test
  public void getPosts() throws Exception {
  }

}