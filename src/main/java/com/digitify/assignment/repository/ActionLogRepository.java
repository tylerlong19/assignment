package com.digitify.assignment.repository;

import com.digitify.assignment.model.ActionLog;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

public interface ActionLogRepository extends CrudRepository<ActionLog, Serializable> {

}
