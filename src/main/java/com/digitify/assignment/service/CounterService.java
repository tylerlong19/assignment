package com.digitify.assignment.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface CounterService {

  void incrementThreads(@RequestParam int producerIncrement, @RequestParam int consumerIncrement);

  void logRequest(HttpServletRequest request);
}
