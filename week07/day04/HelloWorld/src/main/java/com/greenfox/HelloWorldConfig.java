package com.greenfox;

import com.greenfox.colors.GreenColor;
import com.greenfox.colors.MyColor;
import com.greenfox.colors.RedColor;
import org.springframework.beans.factory.annotation.Qualifier;
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

  @Bean
  @Primary
  public MyColor getGreen() {
    return new GreenColor();
  }

  @Bean
  @Qualifier("red")
  public MyColor getRed() {
    return new RedColor();
  }
}
