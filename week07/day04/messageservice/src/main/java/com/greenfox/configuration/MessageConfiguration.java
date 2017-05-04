package com.greenfox.configuration;

import com.greenfox.service.EmilService;
import com.greenfox.service.MessageService;
import com.greenfox.service.TwitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by georgezsiga on 5/4/17.
 */
@Configuration
public class MessageConfiguration {

  @Bean("EmilService")
  public MessageService getEmail() {
    return new EmilService();
  }

  @Bean("TwitterService")
  public MessageService getTwitter() {
    return new TwitterService();
  }
}
