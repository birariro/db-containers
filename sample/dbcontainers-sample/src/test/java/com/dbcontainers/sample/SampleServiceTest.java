package com.dbcontainers.sample;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleServiceTest {

  @Autowired
  SampleService sampleService;

  @Test
  public void test(){
    sampleService.test();
  }

}