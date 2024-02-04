package com.dbcontainers.constant;


public class Constant {

  public class Command {

    private static String runCommandFormat = "docker compose --env-file %s -f %s up --build -d";

    public static String getRunCommand(String envPath, String composePath){
      return String.format(runCommandFormat, envPath, composePath);
    }
  }

}
