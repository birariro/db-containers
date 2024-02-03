package com.birariro.support;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import com.birariro.constant.Constant;

public class Environmenter {
    private static final String filePath = Constant.PATH.ENV;
    private static Map<String, String> envMap;

    static {
        envMap = new HashMap<>();
        loadEnvFile();
    }
    public static void setImage(String image, String version) {
        setKeyValue("DB_CONTAINERS_DATABASE_IMAGE", image);
        setKeyValue("DB_CONTAINERS_DATABASE_IMAGE_VERSION", version);
    }
    public static void setPassword(String password) {
        setKeyValue("DB_CONTAINERS_DATABASE_PASSWORD", password);
    }

    public static void setName(String name) {
        setKeyValue("DB_CONTAINERS_DATABASE_NAME", name);
    }

    public static void setPort(String port) {
        setKeyValue("DB_CONTAINERS_DATABASE_PORT", port);
    }

    private static void setKeyValue(String key, String value) {
        if (envMap.containsKey(key)) {
            envMap.put(key, value);
            saveEnvFile();
        } else {
            System.out.println("Key not found: " + key);
        }
    }

    private static void loadEnvFile() {
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

    private static void saveEnvFile() {
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
