package com.thoughtworks.capacity.gtb.mvc.ExceptionHandler;

public class LoginRegisterException extends RuntimeException {
  public LoginRegisterException(String message) {
      super(message);
  }
}
