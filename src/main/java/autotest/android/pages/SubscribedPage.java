package autotest.android.pages;

import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 27.01.2017.
 */
public class SubscribedPage extends MobileBasePage {

    private static final By OPEN_MENU = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_menu']", true);
    private static final By SEARCH_BUTTON = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_show_search']", true);
    private static final By SEARCH_BAR = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_search']", true);
    private static final String SUBSCRIBER_BY_NUMBER = "//android.support.v7.widget.RecyclerView[@resource-id='com.mgrmobi.intouch:id/id_recycler_view']/" +
            "android.widget.LinearLayout[@index='%d']/android.widget.ImageView[@resource-id='com.mgrmobi.intouch:id/drawee_avatar']";
    private static final String SUBSCRIBER_NICK_BY_NUMBER = "//android.support.v7.widget.RecyclerView[@resource-id='com.mgrmobi.intouch:id/id_recycler_view']/" +
            "android.widget.LinearLayout[@index='%d']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.mgrmobi.intouch:id/text_user_nickname']";
    private static final String SUBSCRIBE_BY_NUMBER = "//android.support.v7.widget.RecyclerView[@resource-id='com.mgrmobi.intouch:id/id_recycler_view']/" +
            "android.widget.LinearLayout[@index='%d']/android.widget.ImageButton[@resource-id='com.mgrmobi.intouch:id/button_connect_user']";


    private static final String OPEN_EVENT = "//android.support.v7.widget.RecyclerView[@resource-id='com.mgrmobi.intouch:id/id_recycler_view']/" +
            "android.widget.LinearLayout[@index='%d']";

    public SubscribedPage() {
        super(MobilePlatform.ANDROID);
    }

    public MainMenuList openMainMenu() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем главное меню, нажимаем на " +
                "элемент c xpath: '%s'", OPEN_MENU.toString()));
        getSearchContext().findElement(OPEN_MENU).click();
        return mobilePageFactory.createPage(MainMenuList.class);
    }

    public SubscribedPage search(String searchQuery) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", SEARCH_BAR.toString()));
        getSearchContext().findElement(SEARCH_BUTTON).click();
        getSearchContext().findElement(SEARCH_BAR).sendKeys(searchQuery + "\\n");
        return this;
    }

    public UserPage openSubscribedByNumber(int number) {
        By locator = new ByLocator(String.format(SUBSCRIBER_BY_NUMBER, number), true);
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем подписчика под номером - '%d', xpath этого элемента: '%s'", number, locator.toString()));
        getSearchContext().findElement(locator).click();
        return mobilePageFactory.createPage(UserPage.class);
    }

    public SubscribedPage unsubscribeByNumber(int number) {
        By locator = new ByLocator(String.format(SUBSCRIBE_BY_NUMBER, number), true);
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Отписываемся от подписчика под номером - '%d', xpath этого элемента: '%s'", number, locator.toString()));
        getSearchContext().findElement(locator).click();
        return this;
    }

    public String getSubscribedNickByNumber(int number) {
        By locator = new ByLocator(String.format(SUBSCRIBER_NICK_BY_NUMBER, number), true);
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем имя подписчика под номером - '%d', xpath этого элемента: '%s'", number+1, locator.toString()));
        String nick = getSearchContext().findElement(locator).getText();
        return nick;
    }

}
