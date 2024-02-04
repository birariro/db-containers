package com.dbcontainers;

public class DbContainersStarter {

    public DbContainersStarter() {
        System.out.println("bean db containers!");
    }
    public void run(){
        ContainerExecutor containerExecutor = new ContainerExecutor();
        containerExecutor.run();
    }
}
