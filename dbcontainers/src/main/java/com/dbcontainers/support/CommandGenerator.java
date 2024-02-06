package com.dbcontainers.support;


import java.util.List;
import java.util.logging.Logger;

import com.dbcontainers.dto.ContainerCondition;
import com.dbcontainers.Database;
import com.dbcontainers.dto.Command;

public class CommandGenerator {
  private final Logger logger = Logger.getLogger(CommandGenerator.class.getName());
   class CommandFormat {

      private static String mysqlCommand = "docker run --name dbcontainers -p %s:3306 -e %s -d mysql:%s";
      private static String mariadbCommand = "docker run --name dbcontainers -p %s:3306 -e %s -d mariadb:%s";
      private static String postgresCommand = "docker run --name dbcontainers -p %s:3306 -e %s -d postgres:%s";
      public static String getFormat(Database database){
        if(database == Database.MYSQL){
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

  public Command createRunCommand(ContainerCondition condition){

    logger.info(condition.toString());

    String password = getPassword(condition.getDatabase(), condition.getPassword());
    String name = getName(condition.getDatabase(), condition.getName());
    String envs = String.join(",", List.of(password, name));

    String command = createCommand(condition.getDatabase(), condition.getPort(), envs,
            condition.getVersion()
    );

    logger.info("create completion command : "+ command);
    return new Command(command);
  }

  private String createCommand(Database database, int port, String envs, String value){
    return String.format(CommandFormat.getFormat(database), port, envs, value);
  }

  private String getName(Database database, String name){
     if(database == Database.MYSQL || database == Database.MARIADB){
       return "MYSQL_DATABASE=" + name;
     }
    if(database == Database.POSTGRES){
      return "POSTGRES_DB=" + name;
    }
    throw new IllegalArgumentException();
  }

  private String getPassword(Database database, String password){
    if(database == Database.MYSQL || database == Database.MARIADB){
      return "MYSQL_ROOT_PASSWORD=" + password;
    }
    if(database == Database.POSTGRES){
      return "POSTGRES_PASSWORD=" + password;
    }
    throw new IllegalArgumentException();
  }
}
