package core.logger;

import org.apache.commons.collections4.FactoryUtils;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by zaborovsky on 06.01.2017.
 */

public class AppenderFactory {

    private static final String LAYOUT_FULL_PATTERN = "%d{DATE} %12p %C{2}.%M(%F:%L) - %m%n";
    private static final String LAYOUT_SIMPLE_PATTERN = "%d{DATE} - %m%n";
    private static final String PATH_FULL_PATTERN = "test-output/%s_%s_%s_full.log";
    private static final String PATH_SIMPLE_PATTERN = "test-output/%s_%s_%s_simple.log";
    private static final String DATE_FORMAT = "yyyyMMdd_HHmmss";

    private AppenderFactory() {

    }

    private static AppenderFactory instance = new AppenderFactory();

    public static AppenderFactory getInstance() {
        return instance;
    }

    public FileAppender createSimple(Level level, String className, String identifier, boolean isAppend) {
        String currentDate = new SimpleDateFormat(DATE_FORMAT).format(new Date());
        FileAppender fileAppender = FactoryUtils.instantiateFactory(FileAppender.class,
                new Class[]{Layout.class, String.class, Boolean.TYPE}, new Object[]{new PatternLayout(LAYOUT_SIMPLE_PATTERN),
                        new String(String.format(PATH_SIMPLE_PATTERN, className, currentDate, identifier.substring(24))),
                        new Boolean(isAppend)}).create();
        fileAppender.setThreshold(level);
        fileAppender.setName(identifier.substring(24));
        return fileAppender;
    }

    public FileAppender createFull(Level level, String className, String identifier, boolean isAppend) {
        String currentDate = new SimpleDateFormat(DATE_FORMAT).format(new Date());
        FileAppender fileAppender = FactoryUtils.instantiateFactory(FileAppender.class,
                new Class[]{Layout.class, String.class, Boolean.TYPE}, new Object[]{new PatternLayout(LAYOUT_FULL_PATTERN),
                        new String(String.format(PATH_FULL_PATTERN, className, currentDate, identifier.substring(24))),
                        new Boolean(isAppend)}).create();
        fileAppender.setThreshold(level);
        fileAppender.setName(identifier.substring(24));
        return fileAppender;
    }


}
