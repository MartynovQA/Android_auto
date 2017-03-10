package core.properties;

import core.logger.LevelLogger;
import core.logger.ThreadLogger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
/**
 * Created by zaborovsky on 20.12.2016.
 */
public class PropertiesLoader {
    private final static String PATH = "./src/main/resources/test.properties";
    private static Properties properties;

    static {
        if (properties == null) {
            properties = new Properties();

//           TODO: сделать файл проперти
            String path = System.getProperty("test.properties.file");

            try {
                if (path == null) {
                    ThreadLogger.getThreadLogger().log(LevelLogger.INFO, String.format("Загружаются properties из %s", PATH));
                    properties.load(new FileReader(PATH));
                } else {
                    ThreadLogger.getThreadLogger().log(LevelLogger.INFO, String.format("Загружаются properties из %s", path));
                    properties.load(new FileReader(path));
                }
            } catch (IOException exc) {
                ThreadLogger.getThreadLogger().log(LevelLogger.INFO, String.format("Загрузка properties не удалась: %s",
                        exc.getMessage()));
                throw new RuntimeException(exc.getMessage());
            }

        }
    }

    public static synchronized String getProperty(String key) {
        return properties.getProperty(key);
    }

}
