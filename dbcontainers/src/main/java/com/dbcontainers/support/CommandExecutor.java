package com.dbcontainers.support;

import com.dbcontainers.dto.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class CommandExecutor {
    private static final Logger logger = Logger.getLogger(CommandExecutor.class.getName());
    public static void execute(Command command){

        String _command = command.value();
        try {

            String[] commands = _command.split(" ");
            ProcessBuilder processBuilder = new ProcessBuilder(commands);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                consoleStringCheck(line);
            }

            int exitCode = process.waitFor();

            if(exitCode != 0){
                throw new RuntimeException("command execute fail exit code : "+exitCode);
            }

            logger.info("command execute success.");

        } catch (IOException | InterruptedException o_O) {
            logger.severe(o_O.getMessage());
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
