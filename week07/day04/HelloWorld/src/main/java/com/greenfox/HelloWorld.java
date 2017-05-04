package com.greenfox;

/**
 * Created by georgezsiga on 5/4/17.
 */
public class HelloWorld {
  private String message;

  public void setMessage(String message){
    this.message  = message;
  }

  public String getMessage(){
    System.out.println("Your message: " + message);
    return message;
  }
}
