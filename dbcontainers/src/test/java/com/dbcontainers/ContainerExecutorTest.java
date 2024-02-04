package com.dbcontainers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContainerExecutorTest {

  @Test
  @DisplayName("common compose run")
  public void commonTest(){

    ContainerExecutor containerExecutor = new ContainerExecutor();
    ContainerCondition condition = containerExecutor.getCondition();
    Assertions.assertEquals(Database.MYSQL, condition.getDatabase());

    containerExecutor.run();
  }

  @Test
  @DisplayName("mariadb condition compose run")
  public void mariadbTest(){

    ContainerCondition condition = new ContainerCondition(Database.MARIADB,"10.8.3","mariadbName", "0000", 8899);
    ContainerExecutor containerExecutor = new ContainerExecutor(condition);

    containerExecutor.run();
  }
  @Test
  @DisplayName("postgres condition compose run")
  public void postgresTest(){

    ContainerCondition condition = new ContainerCondition(Database.POSTGRES,"16.1","postgresDBName", "0000", 8899);
    ContainerExecutor containerExecutor = new ContainerExecutor(condition);

    containerExecutor.run();
  }
}