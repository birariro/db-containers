package com.dbcontainers.support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class SystemCommander {
    private static final Logger logger = Logger.getLogger(SystemCommander.class.getName());
    public static void execute(String command){
        try {
            String[] commands = command.split(" ");
            ProcessBuilder processBuilder = new ProcessBuilder(commands);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                consoleStringCheck(line);
            }

            int exitCode = process.waitFor();
            logger.info("command execute success. Exit Code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    private static void consoleStringCheck(String line){
        if(line.contains("Error response from daemon: dial unix docker.raw.sock: connect: connection refused")){
            logger.warning(line);
            throw new RuntimeException("check running docker daemon");
        }
        if(line.contains("Cannot connect to the Docker daemon at")){
            logger.warning(line);
            throw new RuntimeException("check running docker daemon");
        }
        if(line.contains("You have to remove (or rename) that container to be able to reuse that name.")){
            logger.warning(line);
            throw new RuntimeException("duplicate container name");
        }
        logger.info(line);
    }
}
