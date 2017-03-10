package core.ios;

/**
 * Created by zaborovsky on 23.12.2016.
 */

/**
 * Dump для создания локаторов с помощью findElementByIosUIAutomation
 */
public class IosLocator {

    private static final String LOCATOR_CONTAINER = "%s.%s";
    private static final String ROOT = "UIATarget.localTarget().frontMostApp().";
    private String locator;

    public IosLocator(String locator) {
        this.locator = ROOT + locator;
    }

    public IosLocator(IosLocator other) {
        this.locator = other.getLocator();
    }

    public IosLocator(IosLocator parent, String locator) {
        this.locator = String.format(LOCATOR_CONTAINER, parent.getLocator(), locator);
    }


    public String getLocator() {
        return locator;
    }

    public static IosLocator build(IosLocator parent, String locator) {
        return new IosLocator(String.format(LOCATOR_CONTAINER, parent.getLocator(), locator));
    }

    @Override
    public String toString() {
        return locator;
    }

}