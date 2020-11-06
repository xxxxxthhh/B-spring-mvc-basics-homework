package com.thoughtworks.capacity.gtb.mvc.ExceptionHandler;

public class LoginException extends RuntimeException{
  public LoginException(Integer code, String message){
    super(message);
    Integer errorCode = code;
  }
}
