package com.birariro;


import com.birariro.constant.Constant;
import com.birariro.support.Command;
import com.birariro.support.ConditionPrinter;
import com.birariro.support.Environmenter;

public class ContainerExecutor {


  public void run(Database database, String composePath) {

    Environmenter.setImage(database.getImage(),database.getVersion());
    String envPath = Constant.PATH.ENV;
    String filePath = Constant.PATH.RESOURCES + composePath;
    String command = "docker compose --env-file "+ envPath + " -f " + filePath + " up --build -d";
    Command.execute(command);
    ConditionPrinter.envPrint(envPath);

  }


}

