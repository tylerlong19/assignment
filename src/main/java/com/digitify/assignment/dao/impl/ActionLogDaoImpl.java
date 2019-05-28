package com.digitify.assignment.dao.impl;

import com.digitify.assignment.dao.ActionLogDao;
import com.digitify.assignment.model.ActionLog;
import com.digitify.assignment.repository.ActionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ActionLogDaoImpl implements ActionLogDao {

  @Autowired
  private ActionLogRepository actionLogRepository;

  @Override
  public void saveOrUpdate(ActionLog actionLog) {
    actionLogRepository.save(actionLog);
  }
}
