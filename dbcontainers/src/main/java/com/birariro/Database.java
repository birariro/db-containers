package com.birariro;

public enum Database {
  MARIADB("mariadb","10.8.3"),
  MYSQL("mysql","8.3.0")
  ;

  String image;
  String version;

  Database(String image, String version) {
    this.image = image;
    this.version = version;
  }

  public String getImage() {
    return image;
  }

  public String getVersion() {
    return version;
  }
}
