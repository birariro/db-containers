package com.birariro;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(DbContainersProperties.class)
@ConditionalOnProperty(name = "dbcontainers.enable", havingValue = "true", matchIfMissing = true)
public class DbContainersConfiguration {


  public DbContainersConfiguration() {
    System.out.println("hello db containers!");
  }

  @Bean
  public DbContainersStarter dbContainersStarter() {
    return new DbContainersStarter();
  }
}
