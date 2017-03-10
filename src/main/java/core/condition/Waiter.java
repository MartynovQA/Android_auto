package core.condition;


import core.appium.driver.AppiumExtDriver;
import org.apache.commons.collections4.PredicateUtils;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;
/**
 * Created by zaborovsky on 23.12.2016.
 */
public class Waiter<T extends SearchContext> extends FluentWait<T> {
    private final static long DEFAULT_SLEEP_TIMEOUT = 500;
    private final static long TIMEOUT = 10;

    public Waiter(T context, long timeOutInSeconds) {
        this(context, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, DEFAULT_SLEEP_TIMEOUT);
    }

    public Waiter(T context, long timeOutInSeconds, long sleepInMillis) {
        this(context, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, sleepInMillis);
    }

    public Waiter(T context, Clock clock, Sleeper sleeper, long timeOutInSeconds,
                  long sleepTimeOut) {
        super(context, clock, sleeper);
        withTimeout(timeOutInSeconds, TimeUnit.SECONDS);
        pollingEvery(sleepTimeOut, TimeUnit.MILLISECONDS);
        ignoring(NotFoundException.class);
    }

    public static<T extends SearchContext> FluentWait waitContext(T context, long timeOutInSeconds) {
        if (PredicateUtils.instanceofPredicate(AppiumExtDriver.class).evaluate(context)) {
            return new WebDriverWait((AppiumExtDriver) context, timeOutInSeconds);
        }
        return new Waiter(context, timeOutInSeconds);
    }

    public static <T extends SearchContext>FluentWait<T> waitContext(T context) {
        return waitContext(context, TIMEOUT);
    }
}
