package com.digitify.assignment.dao;

import com.digitify.assignment.model.ActionLog;

public interface ActionLogDao {

  void saveOrUpdate(ActionLog actionLog);
}
