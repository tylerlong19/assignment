package com.digitify.assignment.interceptor;

import com.digitify.assignment.service.CounterService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class LoggingInterceptor extends HandlerInterceptorAdapter {

  @Autowired
  CounterService counterService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    counterService.logRequest(request);
    return true;
  }
}
