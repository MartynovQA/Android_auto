package core.condition;

import core.appium.driver.AppiumExtDriver;
import core.ios.IosLocator;
import core.logger.LevelLogger;
import core.logger.ThreadLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import java.util.List;

/**
 * Created by zaborovsky on 22.12.2016.
 */
public class SearchContextConditions {
    private final static Logger logger = ThreadLogger.getThreadLogger();

    /**
     * @return the given element if it is visible and has non-zero size, otherwise null.
     */
    private static WebElement elementIfVisible(WebElement element) {
        return element.isDisplayed() ? element : null;
    }
    /**
     * Only IOS
     * An expectation for checking that an element is present on the DOM of a page
     * and visible. Visibility means that the element is not only displayed but
     * also has a height and width that is greater than 0.
     *
     * @param locator used to find the element
     * @return the WebElement once it is located and visible
     */
    public static SearchContextCondition<WebElement> visibilityOfElementLocated(
            final IosLocator locator) {
        return new SearchContextCondition<WebElement>() {
            @Override
            public WebElement apply(SearchContext context) {
                try {
                    return elementIfVisible(findElementForContext(locator, context));
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return "visibility of element located by " + locator;
            }
        };
    }

    /**
     * An expectation for checking that an element, known to be present on the DOM
     * of a page, is visible. Visibility means that the element is not only
     * displayed but also has a height and width that is greater than 0.
     *
     * @param element the WebElement
     * @return the (same) WebElement once it is visible
     */
    public static SearchContextCondition<WebElement> visibilityOf(
            final WebElement element) {
        return new SearchContextCondition<WebElement>() {
            @Override
            public WebElement apply(SearchContext context) {
                return elementIfVisible(element);
            }

            @Override
            public String toString() {
                return "visibility of " + element;
            }
        };
    }

    /**
     * An expectation for checking an element is visible and enabled such that you
     * can click it.
     *
     * @param element the WebElement
     * @return the (same) WebElement once it is clickable (visible and enabled)
     */
    public static SearchContextCondition<WebElement> elementToBeClickable(
            final WebElement element) {
        return new SearchContextCondition<WebElement>() {

            public SearchContextCondition<WebElement> visibilityOfElement =
                    SearchContextConditions.visibilityOf(element);

            @Override
            public WebElement apply(SearchContext context) {
                WebElement element = visibilityOfElement.apply(context);
                try {
                    if (element != null && element.isEnabled()) {
                        return element;
                    } else {
                        return null;
                    }
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return "element to be clickable: " + element;
            }
        };
    }

    /**
     * Only IOS
     * An expectation for checking that an element is either invisible or not
     * present on the DOM.
     *
     * @param locator used to find the element
     */
    public static SearchContextCondition<Boolean> invisibilityOfElementLocated(
            final IosLocator locator) {
        return new SearchContextCondition<Boolean>() {
            @Override
            public Boolean apply(SearchContext context) {
                try {
                    return !(findElementForContext(locator, context).isDisplayed());
                } catch (NoSuchElementException e) {
                    // Returns true because the element is not present in DOM. The
                    // try block checks if the element is present but is invisible.
                    return true;
                } catch (StaleElementReferenceException e) {
                    // Returns true because stale element reference implies that element
                    // is no longer visible.
                    return true;
                }
            }

            @Override
            public String toString() {
                return "element to no longer be visible: " + locator;
            }
        };
    }

    private static WebElement findElementForContext(By by, SearchContext context) {
        try {
            return context.findElement(by);
        } catch (NoSuchElementException e) {
            throw e;
        } catch (WebDriverException e) {
            logger.log(LevelLogger.WARN,
                    String.format("WebDriverException thrown by findElement(%s)", by), e);
            throw e;
        }
    }

    private static List<WebElement> findElementsForContext(By by, SearchContext context) {
        try {
            return context.findElements(by);
        } catch (WebDriverException e) {
            logger.log(LevelLogger.WARN,
                    String.format("WebDriverException thrown by findElement(%s)", by), e);
            throw e;
        }
    }

    /**
     * An expectation for checking that an element is either invisible or not
     * present on the DOM.
     *
     * @param locator used to find the element
     */
    public static SearchContextCondition<Boolean> invisibilityOfElementLocated(
            final By locator) {
        return new SearchContextCondition<Boolean>() {
            @Override
            public Boolean apply(SearchContext context) {
                try {
                    return !(findElementForContext(locator, context).isDisplayed());
                } catch (NoSuchElementException e) {
                    // Returns true because the element is not present in DOM. The
                    // try block checks if the element is present but is invisible.
                    return true;
                } catch (StaleElementReferenceException e) {
                    // Returns true because stale element reference implies that element
                    // is no longer visible.
                    return true;
                }
            }

            @Override
            public String toString() {
                return "element to no longer be visible: " + locator;
            }
        };
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page
     * and visible. Visibility means that the element is not only displayed but
     * also has a height and width that is greater than 0.
     *
     * @param locator used to find the element
     * @return the WebElement once it is located and visible
     */
    public static SearchContextCondition<WebElement> visibilityOfElementLocated(
            final By locator) {
        return new SearchContextCondition<WebElement>() {
            @Override
            public WebElement apply(SearchContext context) {
                try {
                    return elementIfVisible(findElementForContext(locator, context));
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return "visibility of element located by " + locator;
            }
        };
    }

    private static WebElement findElementForContext(IosLocator locator, SearchContext context) {
        try {
            return ((AppiumExtDriver)context).findElementByIosUIAutomation(locator.getLocator());
        } catch (NoSuchElementException e) {
            throw e;
        } catch (WebDriverException e) {
            logger.log(LevelLogger.WARN,
                    String.format("WebDriverException thrown by findElement(%s)", locator), e);
            throw e;
        }
    }

}
