package com.birariro;

public class ContainerCondition {
  private final Database database;
  private final String version;
  private final String name;
  private final String password;
  private final Integer port;

  public ContainerCondition() {
    this.database = Database.MYSQL;
    this.version = "8.3.0";
    this.name = "testdb";
    this.password = "0000";
    this.port = 3306;
  }

  public ContainerCondition(Database database, String version, String name, String password, Integer port) {
    this.database = database;
    this.version = version;
    this.name = name;
    this.password = password;
    this.port = port;
  }

  public Database getDatabase() {
    return database;
  }

  public String getVersion() {
    return version;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public Integer getPort() {
    return port;
  }
}
