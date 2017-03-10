package autotest.android.pages;

import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 12.01.2017.
 */
public class DiscoverPage extends MobileBasePage{
    private static final By OPEN_MENU = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_menu']", true);
    private static final By OPEN_SEARCH = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_open_search']", true);


    public DiscoverPage() {
        super(MobilePlatform.ANDROID);
    }

    public MainMenuList openMainMenu() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем главное меню, нажимаем на " +
                "элемент c xpath: '%s'", OPEN_MENU.toString()));
        getSearchContext().findElement(OPEN_MENU).click();
        return mobilePageFactory.createPage(MainMenuList.class);
    }

    public SearchPage openSearchPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем главное меню, нажимаем на " +
                "элемент c xpath: '%s'", OPEN_SEARCH.toString()));
        getSearchContext().findElement(OPEN_SEARCH).click();
        return mobilePageFactory.createPage(SearchPage.class);
    }


}
