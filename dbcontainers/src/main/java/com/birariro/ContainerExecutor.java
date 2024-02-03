package com.birariro;


import com.birariro.support.Command;

public class ContainerExecutor {

  private final String DIR = "src/main/resources/";
  public void run(Database database, String composePath) {

    String envPath = DIR + "env";
    String filePath = DIR + composePath;
    String command = "docker compose --env-file "+ envPath + " -f " + filePath + " up --build -d";
    Command.execute(command);
  }
}

