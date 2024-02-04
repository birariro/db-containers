package com.dbcontainers;


import java.net.URL;
import java.util.logging.Logger;

import com.dbcontainers.constant.Constant;
import com.dbcontainers.support.SystemCommander;
import com.dbcontainers.support.ConditionPrinter;
import com.dbcontainers.support.Environmenter;

public class ContainerExecutor {

  private final Logger logger = Logger.getLogger(ContainerExecutor.class.getName());
  private final ContainerCondition condition;
  private final String composePath;
  private final String env;

  public ContainerExecutor(ContainerCondition condition) {
    this.condition = condition;
    this.env = this.getClass().getResource("/env").getPath();
    this.composePath = this.getClass().getResource("/"+condition.getDatabase().getComposeFileName()).getPath();
    Environmenter.init(condition);
  }

  public ContainerExecutor() {
    this(new ContainerCondition());
  }

  public void run() {

    String command =  Constant.Command.getRunCommand(env, composePath);

    logger.info("command call: "+ command);
    ConditionPrinter.envPrint(env);

    SystemCommander.execute(command);
  }

  public ContainerCondition getCondition() {
    return condition;
  }
}

