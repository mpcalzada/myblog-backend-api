package com.mcalzada.controller.not_found;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * {@link UserNotFoundAdvice}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@ControllerAdvice
public class UserNotFoundAdvice
{

  @ResponseBody
  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(UserNotFoundException ex)
  {
    return ex.getMessage();
  }
}
