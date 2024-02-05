package com.dbcontainers;


import java.util.logging.Logger;

import com.dbcontainers.support.CommandGenerator;
import com.dbcontainers.support.SystemCommander;

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

    logger.info(condition.toString());

    String command =  new CommandGenerator().getRunCommand(condition);
    logger.info("command : "+ command);

    SystemCommander.execute(command);
  }

  public ContainerCondition getCondition() {
    return condition;
  }
}

