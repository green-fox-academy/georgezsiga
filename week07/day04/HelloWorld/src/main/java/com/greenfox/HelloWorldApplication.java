package com.greenfox;

import com.greenfox.colors.MyColor;
import com.greenfox.colors.RedColor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);

		ApplicationContext factory = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		HelloWorld hw = factory.getBean(HelloWorld.class);
		hw.setMessage("Hello World");
		hw.getMessage();

		MyColor rainbow	= factory.getBean(MyColor.class);
		rainbow.printColor();
	}
}
