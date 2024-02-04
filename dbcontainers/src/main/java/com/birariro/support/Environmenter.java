package com.birariro.support;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.birariro.ContainerCondition;
import com.birariro.constant.Constant.Path;

public class Environmenter {
    private final Logger logger = Logger.getLogger(Environmenter.class.getName());
    private final String filePath = Path.ENV;
    private Map<String, String> envMap;

    public Environmenter() {
        envMap = new HashMap<>();
        loadEnvFile();
    }

    public static Environmenter init(ContainerCondition condition){

        Environmenter environmenter = new Environmenter();

        environmenter.setImage(condition.getDatabase().getImage(), condition.getVersion());
        environmenter.setName(condition.getName());
        environmenter.setPassword(condition.getPassword());
        environmenter.setPort(String.valueOf(condition.getPort()));
        environmenter.saveEnvFile();
        return environmenter;
    }

    private void setImage(String image, String version) {
        setKeyValue("DB_CONTAINERS_DATABASE_IMAGE", image);
        setKeyValue("DB_CONTAINERS_DATABASE_IMAGE_VERSION", version);
    }
    private void setPassword(String password) {
        setKeyValue("DB_CONTAINERS_DATABASE_PASSWORD", password);
    }

    private void setName(String name) {
        setKeyValue("DB_CONTAINERS_DATABASE_NAME", name);
    }

    private void setPort(String port) {
        setKeyValue("DB_CONTAINERS_DATABASE_PORT", port);
    }

    private void setKeyValue(String key, String value) {
        if (envMap.containsKey(key)) {
            envMap.put(key, value);
        } else {
            logger.warning("Key not found: " + key);
        }
    }

    private void loadEnvFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    envMap.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveEnvFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : envMap.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
