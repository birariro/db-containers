package com.birariro.constant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Constant {
  public class Path {
    public static final String RESOURCES = "src/main/resources/";
    public static final String ENV = RESOURCES + "env";
  }
  public class Command {

    private static String runCommandFormat = "docker compose --env-file %s -f %s up --build -d";

    public static String getRunCommand(String file){
      return String.format(runCommandFormat, Path.ENV, file);
    }
  }

}
