package config;

import utils.ConfigReader;

public class EnvironmentConfig {

    private static final ConfigReader CONFIG_READER = new ConfigReader("./src/test/resources/environment.json");

    public static String getBaseUrl() {
        return CONFIG_READER.getConfigValue("baseUrl");
    }
}
