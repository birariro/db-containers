package com.dbcontainers;


import java.util.logging.Logger;

import com.dbcontainers.dto.Command;
import com.dbcontainers.dto.ContainerCondition;
import com.dbcontainers.support.CommandGenerator;
import com.dbcontainers.support.CommandExecutor;

public class ContainerExecutor {

  private final Logger logger = Logger.getLogger(ContainerExecutor.class.getName());
  private final ContainerCondition condition;

  public ContainerExecutor(ContainerCondition condition) {
    this.condition = condition;
  }

  public ContainerExecutor() {
    this(new ContainerCondition());
  }

  public void run() {

    Command command = new CommandGenerator().createRunCommand(condition);
    CommandExecutor.execute(command);
  }

  public ContainerCondition getCondition() {
    return condition;
  }
}

