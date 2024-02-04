package com.birariro;


import java.util.logging.Logger;

import com.birariro.constant.Constant;
import com.birariro.constant.Constant.Path;
import com.birariro.support.SystemCommander;
import com.birariro.support.ConditionPrinter;
import com.birariro.support.Environmenter;

public class ContainerExecutor {

  private final Logger logger = Logger.getLogger(ContainerExecutor.class.getName());
  private final ContainerCondition condition;
  private final String composePath;

  public ContainerExecutor(ContainerCondition condition) {
    this.condition = condition;
    this.composePath = Path.RESOURCES + condition.getDatabase().getComposeFileName();
    Environmenter.init(condition);
  }

  public ContainerExecutor() {
    this(new ContainerCondition());
  }

  public void run() {

    String envPath = Constant.Path.ENV;
    String command =  Constant.Command.getRunCommand(composePath);

    logger.info("command call: "+ command);
    ConditionPrinter.envPrint(envPath);

    SystemCommander.execute(command);
  }

  public ContainerCondition getCondition() {
    return condition;
  }
}

