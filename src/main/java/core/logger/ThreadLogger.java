package core.logger;

import org.apache.log4j.Logger;
/**
 * Created by zaborovsky on 20.12.2016.
 */
public class ThreadLogger {
    private static ThreadLocal<Logger> storageLogger = new ThreadLocal<>();

    public static void setThreadLogger(Logger logger) {
        storageLogger.set(logger);
    }

    public static Logger getThreadLogger() {
        if ((storageLogger.get()) == null) {
            storageLogger.set(Logger.getLogger(String.valueOf(Thread.currentThread().getId())));
        }
        return storageLogger.get();
    }
}
