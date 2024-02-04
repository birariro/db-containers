package com.dbcontainers.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class DbcontainersSampleApplication {

  public static void main(String[] args) {

    ConfigurableApplicationContext run = SpringApplication.run(DbcontainersSampleApplication.class, args);

    String[] beanNames = run.getBeanDefinitionNames();
    for (String beanName : beanNames) {
      if(beanName.toLowerCase().contains("dbcontainers"))
        System.out.println(beanName);
    }
  }

}
