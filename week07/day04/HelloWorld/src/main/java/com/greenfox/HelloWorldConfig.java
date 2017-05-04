package com.greenfox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by georgezsiga on 5/4/17.
 */
@Configuration
public class HelloWorldConfig {

  @Bean
  @Primary
  public HelloWorld getHelloWorld() {
    return new HelloWorld();
  }
}
