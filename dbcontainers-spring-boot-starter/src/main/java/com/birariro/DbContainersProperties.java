package com.birariro;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dbcontainers")
public class DbContainersProperties {
  private boolean enable = true;

}
