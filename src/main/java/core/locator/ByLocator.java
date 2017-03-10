package core.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.internal.FindsByXPath;

import java.util.List;

/**
 * Created by zaborovsky on 22.12.2016.
 */
public class ByLocator extends By {
    private String xpath;

    public ByLocator(String xpath, boolean isGlobal) {
        if (isGlobal) {
            this.xpath = xpath;
        }
        else {
            this.xpath = xpath.replaceFirst("//", ".//").replaceAll("\\|\\s?//", "\\|.//");
        }
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        return ((FindsByXPath) context).findElementsByXPath(xpath);

    }

    @Override
    public WebElement findElement(SearchContext context) {
        return ((FindsByXPath) context).findElementByXPath(xpath);
    }

    @Override
    public String toString() {
        return xpath;
    }

    public String getXpath() {
        return xpath.replaceAll("\\./", "/");
    }
}









// toString for logs
// replace for
