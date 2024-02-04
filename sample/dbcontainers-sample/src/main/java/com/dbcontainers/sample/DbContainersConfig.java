package com.dbcontainers.sample;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dbcontainers.DbContainersConfiguration;
import com.dbcontainers.DbContainersStarter;


@Configuration
@ConditionalOnProperty(name = "application.test", havingValue = "true", matchIfMissing = true)
public class DbContainersConfig {

  @Bean
  public DbContainersConfiguration dbContainersConfiguration(){
    return new DbContainersConfiguration();
  }
  @Bean
  public DbContainersStarter dbContainersStarter(){
    return new DbContainersStarter();
  }
}
