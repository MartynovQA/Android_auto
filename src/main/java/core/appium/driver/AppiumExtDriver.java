package core.appium.driver;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import core.appium.enums.MobilePlatform;
import core.ios.IosLocator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.FindsByIosUIAutomation;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zaborovsky on 20.12.2016.
 */


public class AppiumExtDriver extends AppiumDriver implements FindsByIosUIAutomation, FindsByAndroidUIAutomator {

    public static final int IMPLICIT_WAIT_SECONDS = 2;
    public static final int EXPLICIT_WAIT_SECONDS = 5;
    private static ThreadLocal<AppiumExtDriver> driverStorage = new ThreadLocal<>();

    private AppiumExtDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);
        manage().timeouts().implicitlyWait(IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
        driverStorage.set(this);
    }

    public static AppiumExtDriver getDriver(MobilePlatform platform) {
        AppiumExtDriver driver;        //new URL("http://127.0.0.1:4723/wd/hub" "http://192.168.0.94:4444/wd/hub")
        if ((driver = driverStorage.get()) == null) {
            try {
                driver = new AppiumExtDriver(new URL("http://127.0.0.1:4723/wd/hub"), MobileCapabilitiesFactory.getCapabilities(platform));     //для локального запуска
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            //driver = new AppiumExtDriver(new UrlFactory().createUrl(), MobileCapabilitiesFactory.getCapabilities(platform));
        }
        return driver;
    }

    public static AppiumExtDriver getCurrentDriver() {
        return driverStorage.get();
    }

    public static void stopDriver(AppiumExtDriver driver) {
        if (driver != null) {
            driverStorage.remove();
            driver.quit();
        }
    }

    public void scrollToText(WebElement element, String text, boolean scrollDown) {
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        String id = ((MobileRemoteElement) element).getId();
        String direction;
        if (scrollDown) {
            direction = "down";
        } else {
            direction = "up";
        }
        scrollObject.put("text", text);
        scrollObject.put("element", id);
        scrollObject.put("direction", direction);
        executeScript("mobile: scrollTo", scrollObject);
    }

    public void scrollTo(WebElement element) {
        HashMap<String, String> scrollOpts = new HashMap<>();
        scrollOpts.put("element", ((MobileRemoteElement) element).getId());
        executeScript("mobile: scrollTo", scrollOpts);
    }

    public void clicInMiddle() {
        JavascriptExecutor js = this;
        int width = ((Long) js.executeScript("return window.innerWidth || document.body.clientWidth")).intValue() ;

        int height = ((Long) js.executeScript("return window.innerHeight || document.body.clientHeight")).intValue() ;

        Dimension dimension  = new Dimension(width, height);
    }


    @Override
    public List<WebElement> findElements(By by) {
        return Lists.transform(super.findElements(by), new Function<WebElement, WebElement>() {
            @Override
            public WebElement apply(WebElement element) {
                return new MobileRemoteElement(element);
            }
        });
    }

    @Override
    public WebElement findElement(By by) {
        MobileRemoteElement mobileElement;
        try {
            mobileElement = new MobileRemoteElement(super.findElement(by));
        } catch (NoSuchElementException exc) {
            sleep(3);
            mobileElement = new MobileRemoteElement(super.findElement(by));
        }
        return mobileElement;
    }

    public void swipe2(double startX, double startY, double endX, double endY) {
        JavascriptExecutor js = this;
        HashMap<String, Double> swipeObject = new HashMap<>();
        swipeObject.put("startX", startX);
        swipeObject.put("startY", startY);
        swipeObject.put("endX", endX);
        swipeObject.put("endY", endY);
        swipeObject.put("duration", 1.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public boolean isPresent(By by) {
        return findElements(by).size() > 0;
    }

    public boolean isPresentIos(IosLocator locator) {
        return findElementsByIosUIAutomation(locator.getLocator()).size() > 0;
    }

    /**
     * Только для IOS (Android не поддерживает js)
     * @param locator локатор элемента для которого необходимо установить значение
     * @param value устанавливаемое значение
     */
    public void setValue(IosLocator locator, String value) {
        executeScript(String.format("%s.setValue(\"%s\")", locator.getLocator(), value));
    }

    @Override
    public MobileElement scrollTo(String s) {
        return null;
    }

    @Override
    public MobileElement scrollToExact(String s) {
        return null;
    }

    @Override
    public WebElement findElementByIosUIAutomation(String using) {
        MobileRemoteElement mobileElement;
        try {
            mobileElement = new MobileRemoteElement(super.findElement("-ios uiautomation", using));
        } catch (NoSuchElementException exc) {
            sleep(3);
            mobileElement = new MobileRemoteElement(super.findElement("-ios uiautomation", using));
        }
        return mobileElement;
    }

    @Override
    public List<WebElement> findElementsByIosUIAutomation(String using) {
        return Lists.transform(super.findElements("-ios uiautomation", using), new Function<WebElement, WebElement>() {
            @Override
            public WebElement apply(WebElement element) {
                return new MobileRemoteElement(element);
            }
        });
    }

    @Override
    public WebElement findElementByAndroidUIAutomator(String using) {
        return super.findElement("-android uiautomator", using);
    }

    @Override
    public List<WebElement> findElementsByAndroidUIAutomator(String using) {
        return super.findElements("-android uiautomator", using);
    }

    private static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
