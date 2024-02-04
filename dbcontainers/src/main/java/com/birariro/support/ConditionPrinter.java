package com.birariro.support;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class ConditionPrinter {
  public static void envPrint(String file){

    Logger logger = Logger.getLogger(ConditionPrinter.class.getName());

    String print = "---------------------\n";

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      
      while ((line = reader.readLine()) != null) {
        String env = line.replaceFirst("DB_CONTAINERS_", "");
        print += env + "\n";
      }
      print += "---------------------\n";

      logger.info(print);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
