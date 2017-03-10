package core.logger;

import org.apache.log4j.Level;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by zaborovsky on 20.12.2016.
 */
public class LevelLogger extends Level{
    private static final Map<Integer, LevelLogger> LEVEL_LOGGER;

    static {
        LEVEL_LOGGER = Collections.synchronizedMap(new HashMap<Integer, LevelLogger>());
    }

    public static final Level TEST_STARTED = new LevelLogger(FATAL_INT - 1, "TEST_STARTED", 0);
    public static final Level TEST_FINISHED = new LevelLogger(FATAL_INT - 2, "TEST_FINISHED", 0);
    public static final Level METHOD_STARTED = new LevelLogger(FATAL_INT - 3, "METHOD_STARTED", 0);
    public static final Level METHOD_SKIPPED = new LevelLogger(FATAL_INT - 4, "METHOD_SKIPPED", 0);
    public static final Level METHOD_FAILED = new LevelLogger(FATAL_INT - 5, "METHOD_FAILED", 0);
    public static final Level METHOD_SUCCESS = new LevelLogger(FATAL_INT - 6, "METHOD_SUCCESS", 0);
    public static final Level TEST_ERROR = new LevelLogger(FATAL_INT - 7, "TEST_ERROR", 0);
    public static final Level SCREEN_ACTION = new LevelLogger(FATAL_INT - 8, "SCREEN_ACTION", 0);
    public static final Level SCREEN_INFO = new LevelLogger(FATAL_INT - 9, "SCREEN_INFO", 0);
    public static final Level METHOD_DESCRIPTION = new LevelLogger(FATAL_INT - 10, "METHOD_DESCRIPTION", 0);
    public static final Level TEST_INFO = new LevelLogger(FATAL_INT - 11, "TEST_INFO", 0);

    protected LevelLogger(int level, String levelStr, int syslogEquivalent) {
        super(level, levelStr, syslogEquivalent);
        LEVEL_LOGGER.put(level, this);
    }
}
