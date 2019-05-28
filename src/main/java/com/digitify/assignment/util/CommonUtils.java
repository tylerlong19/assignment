package com.digitify.assignment.util;

import java.util.Enumeration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpServletRequest;

public class CommonUtils {

  public static String getHeaders(HttpServletRequest request) {
    Enumeration<String> headerNames = request.getHeaderNames();
    StringBuilder sb = new StringBuilder();
    while (headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      sb.append("Header Name - ").append(headerName).append(", Value - ").append(request.getHeader(headerName));
    }
    return  sb.toString();
  }


  public static String getRequestParams(HttpServletRequest request) {
    Enumeration<String> params = request.getParameterNames();
    StringBuilder sb = new StringBuilder();
    while(params.hasMoreElements()){
      String paramName = params.nextElement();
      sb.append("Parameter Name - ").append(paramName).append(", Value - ").append(request.getParameter(paramName));
    }
    return sb.toString();
  }
}
