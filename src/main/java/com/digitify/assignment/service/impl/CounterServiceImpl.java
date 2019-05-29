package com.digitify.assignment.service.impl;

import com.digitify.assignment.dao.ActionLogDao;
import com.digitify.assignment.exception.InternalServerException;
import com.digitify.assignment.model.ActionLog;
import com.digitify.assignment.service.CounterService;
import com.digitify.assignment.util.CommonUtils;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService {

  @Autowired
  ActionLogDao actionLogDao;

  private AtomicInteger counter = new AtomicInteger(50);
  private final static Logger LOG = LoggerFactory.getLogger(CounterServiceImpl.class);

  @Override
  public void incrementThreads(int producerIncrement, int consumerIncrement) {
    try {
      int i = 0;
      while (producerIncrement > i) {
        Thread producerThread = new Thread(() -> {
          while (counter.get() < 100) {
            counter.getAndIncrement();
            LOG.info("Counter incremented by producer Thread {} value {}",
                Thread.currentThread().getName(), counter.get());
          }
        });
        producerThread.start();
        i++;
      }
      int j = 0;
      while (consumerIncrement > j) {
        Thread consumerThread = new Thread(() -> {
          while (counter.get() > 0) {
            counter.getAndDecrement();
            LOG.info("Counter decremented by Consumer Thread {} value {}",
                Thread.currentThread().getName(), counter.get());
          }
        });
        consumerThread.start();
        j++;
      }

    } catch (Exception e) {
      LOG.error("An exception occurred", e);
      throw new InternalServerException(e.getMessage());
    }
  }

  @Override
  public void logRequest(HttpServletRequest request) {
    ActionLog actionLog = new ActionLog();
    StringBuilder stringBuilder = new StringBuilder("RequestMethod:").append(request.getMethod())
        .append(CommonUtils.getRequestParams(request));
    actionLog.setRequest(stringBuilder.toString());
    actionLogDao.saveOrUpdate(actionLog);

  }

  public static void main(String args[]) {
    CounterServiceImpl counterService = new CounterServiceImpl();
    counterService.incrementThreads(2, 2);
  }
}
