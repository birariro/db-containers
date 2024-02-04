package com.dbcontainers.sample;

import org.springframework.stereotype.Service;

import com.dbcontainers.DbContainersStarter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleService {

  private final DbContainersStarter dbContainersStarter;
  public void test(){
    System.out.println(dbContainersStarter != null);
    dbContainersStarter.run();
  }
}
