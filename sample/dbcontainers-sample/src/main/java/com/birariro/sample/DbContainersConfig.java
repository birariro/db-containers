package com.birariro.sample;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.birariro.DbContainersConfiguration;

@Configuration
@ConditionalOnProperty(name = "application.test", havingValue = "true", matchIfMissing = true)
public class DbContainersConfig {

  @Bean
  public DbContainersConfiguration dbContainersConfiguration(){
    return new DbContainersConfiguration();
  }
}
