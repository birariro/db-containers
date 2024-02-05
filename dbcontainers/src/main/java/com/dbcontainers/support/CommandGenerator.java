package com.dbcontainers.support;


import java.util.List;

import com.dbcontainers.ContainerCondition;
import com.dbcontainers.Database;

public class CommandGenerator {

   class Command {

      private static String mysqlCommand = "docker run --name dbcontainers -p %s:3306 -e %s -d mysql:%s";
      private static String mariadbCommand = "docker run --name dbcontainers -p %s:3306 -e %s -d mariadb:%s";
      private static String postgresCommand = "docker run --name dbcontainers -p %s:3306 -e %s -d postgres:%s";
      public static String getCommandFormat(Database database){
        if(database == Database.MYSQL || database == Database.MARIADB){
          return mysqlCommand;
        }
        if(database == Database.MARIADB){
          return mariadbCommand;
        }
        if(database == Database.POSTGRES){
          return postgresCommand;
        }
        throw new IllegalArgumentException();
      }
  }

  public String getRunCommand(ContainerCondition condition){

    String password = getPassword(condition.getDatabase(), condition.getPassword());
    String name = getName(condition.getDatabase(), condition.getName());
    String envs = String.join(",", List.of(password, name));

    return createCommand(condition.getDatabase(), condition.getPort(), envs,
        condition.getVersion());
  }
  private String createCommand(Database database, int port, String envs, String value){
    return String.format(Command.getCommandFormat(database), port, envs,
        value);
  }

  private String getName(Database database, String name){
     if(database == Database.MYSQL || database == Database.MARIADB){
       return "MYSQL_DATABASE="+name;
     }
    if(database == Database.POSTGRES){
      return "POSTGRES_DB="+name;
    }
    throw new IllegalArgumentException();
  }

  private String getPassword(Database database, String password){
    if(database == Database.MYSQL || database == Database.MARIADB){
      return "MYSQL_ROOT_PASSWORD="+password;
    }
    if(database == Database.POSTGRES){
      return "POSTGRES_PASSWORD="+password;
    }
    throw new IllegalArgumentException();
  }
}
