package core.appium.driver;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
//import io.appium.java_client.MobileElement;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import core.condition.SearchContextConditions;
import core.condition.Waiter;
import java.util.List;
/**
 * Created by zaborovsky on 21.12.2016.
 */
public class MobileRemoteElement implements SearchContext, WrapsDriver, WrapsElement, WebElement, Locatable {

    private RemoteWebElement mobileElement;

    public MobileRemoteElement(WebElement element) {
        this.mobileElement = (RemoteWebElement) element;
    }

    public RemoteWebElement getRemoteElement() {
        return mobileElement;
    }

    public void setId(String id) {
        mobileElement.setId(id);
    }

    public String getId() {
        return mobileElement.getId();
    }

    public void setParent(RemoteWebDriver parent) {
        mobileElement.setParent(parent);
    }

    public void clickTouch() {
        Waiter.waitContext(mobileElement.getWrappedDriver()).
                until(SearchContextConditions.elementToBeClickable(mobileElement));
        new TouchAction((MobileDriver)mobileElement.getWrappedDriver()).press(mobileElement).release().perform();
    }

    @Override
    public void click() {
        Waiter.waitContext(mobileElement.getWrappedDriver()).
                until(SearchContextConditions.elementToBeClickable(mobileElement));
        mobileElement.click();
    }

    public void clickWithout() {
        mobileElement.click();
    }

    @Override
    public void submit() {
        mobileElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        mobileElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        mobileElement.clear();
    }

    @Override
    public String getTagName() {
        return mobileElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return mobileElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return mobileElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return mobileElement.isEnabled();
    }

    @Override
    public String getText() {
        return mobileElement.getText();
    }

    @Override
    public boolean isDisplayed() {
        return mobileElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return mobileElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return mobileElement.getSize();
    }

//    @Override
//    public Rectangle getRect() {
//        return null;
//    }

    @Override
    public String getCssValue(String propertyName) {
        return mobileElement.getCssValue(propertyName);
    }

    @Override
    public Coordinates getCoordinates() {
        return mobileElement.getCoordinates();
    }

    @Override
    public List<WebElement> findElements(By by) {
        throw new UnsupportedOperationException("Not implement yet!");
    }

    @Override
    public WebElement findElement(By by) {
        throw new UnsupportedOperationException("Not implement yet!");
    }

    @Override
    public WebDriver getWrappedDriver() {
        return mobileElement.getWrappedDriver();
    }

    @Override
    public WebElement getWrappedElement() {
        return mobileElement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MobileRemoteElement)) return false;

        MobileRemoteElement that = (MobileRemoteElement) o;

        if (!mobileElement.equals(that.mobileElement)) return false;
        return true;
    }

//    @Override
//    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
//        return null;
//    }
}