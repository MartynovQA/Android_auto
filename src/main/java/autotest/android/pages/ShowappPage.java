package autotest.android.pages;

import core.appium.driver.AppiumExtDriver;
import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 09.01.2017.
 */
public class ShowappPage extends MobileBasePage {

    private static final By OPEN_MENU = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_menu']", true);
    private static final By MENU_PRESENT = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/menu_exit']", true);

    public ShowappPage() {
        super(MobilePlatform.ANDROID);
    }

    public MainMenuList openMainMenu() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем главное меню, нажимаем на " +
                "элемент c xpath: '%s'", OPEN_MENU.toString()));
        getSearchContext().findElement(OPEN_MENU).click();
//        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Меню " +
//                "не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
//                until(SearchContextConditions.visibilityOfElementLocated(MENU_PRESENT));
        return mobilePageFactory.createPage(MainMenuList.class);
    }

    public boolean isMainMenuPresent() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Проверяем есть ли главное меню, элемент c xpath: '%s'",
                OPEN_MENU));
        boolean result = ((AppiumExtDriver)getSearchContext()).isPresent(OPEN_MENU);
        if(result) {
            result =  getSearchContext().findElement(OPEN_MENU).isDisplayed();
        }
        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
        return result;
    }

    public boolean isMainMenuOpen() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Проверяем есть ли главное меню, элемент c xpath: '%s'",
                MENU_PRESENT));
        boolean result = ((AppiumExtDriver)getSearchContext()).isPresent(MENU_PRESENT);
        if(result) {
            result =  getSearchContext().findElement(MENU_PRESENT).isDisplayed();
        }
        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
        return result;
    }


}


