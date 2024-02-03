package com.birariro.support;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConditionPrinter {

  public static void envPrint(String file){
    System.out.println("---------------------");
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      
      while ((line = reader.readLine()) != null) {
        String env = line.replaceFirst("DB_CONTAINERS_", "");
        System.out.println(env);
      }
      System.out.println("---------------------");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
