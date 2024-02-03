package com.birariro;


import org.junit.jupiter.api.Test;

class ContainerExecutorTest {

  @Test
  public void mariadbTest(){

    ContainerExecutor containerExecutor = new ContainerExecutor();

    Database mariadb = Database.MARIADB;
    String filename = "docker-compose-mariadb.yml";

    containerExecutor.run(mariadb, filename);
  }
}