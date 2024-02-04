package com.dbcontainers;

public enum Database {
  MARIADB("mariadb","mysql.yml"),
  MYSQL("mysql","mysql.yml"),
  POSTGRES("postgres","postgres.yml")
  ;

  String image;
  String compose;

  Database(String image,String compose) {
    this.image = image;
    this.compose = compose;
  }

  public String getImage() {
    return image;
  }

  public String getComposeFileName() {
    return "docker-compose-" + compose;
  }
}
