package com.greenfox;

import com.greenfox.configuration.MessageConfiguration;
import com.greenfox.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by georgezsiga on 5/4/17.
 */
@Component
public class MessageProceeder {

  MessageService service;

  public MessageProceeder() {
    ApplicationContext factory = new AnnotationConfigApplicationContext(MessageConfiguration.class);
    MessageService service = (MessageService) factory.getBean("EmilService");
    this.service = service;
  }

  public void processMessage(String s, String s1) {
    service.sendingMessage(s, s1);
  }
}
