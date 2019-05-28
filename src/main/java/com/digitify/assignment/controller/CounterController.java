package com.digitify.assignment.controller;

import com.digitify.assignment.exception.InternalServerException;
import com.digitify.assignment.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CounterController {

  @Autowired
  CounterService counterService;

  @RequestMapping(produces = "application/json", value = "/increment-threads", method = RequestMethod.POST)
  public ResponseEntity<?> incrementThreads(@RequestParam int producerIncrement, @RequestParam int consumerIncrement) {
    HttpHeaders headers = new HttpHeaders();
    try {
      counterService.incrementThreads(producerIncrement, consumerIncrement);
    } catch (InternalServerException e) {
      return new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

}
