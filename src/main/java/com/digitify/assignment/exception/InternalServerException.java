package com.digitify.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InternalServerException extends RuntimeException {

  public InternalServerException() {
    super();
  }

  public InternalServerException(String message) {
    super(message);
  }

  public InternalServerException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
