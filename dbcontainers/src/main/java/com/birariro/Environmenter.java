package com.birariro;

import com.birariro.support.Command;

public class Environmenter {

  public void setPassword(String password){
    System.setProperty("DB_CONTAINERS_DATABASE_PASSWORD",password);
//    String command = "export DB_CONTAINERS_DATABASE_PASSWORD="+password;
//    Command.execute(command);
  }
  public void setName(String name){
    System.setProperty("DB_CONTAINERS_DATABASE_NAME",name);
//    String command = "export DB_CONTAINERS_DATABASE_NAME="+name;
//    Command.execute(command);
  }
  public void setPort(String port){
    System.setProperty("DB_CONTAINERS_DATABASE_PORT",port);
//    String command = "export DB_CONTAINERS_DATABASE_PORT="+port;
//    Command.execute(command);
  }
}
