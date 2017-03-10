package autotest.android.pages;

import core.appium.driver.AppiumExtDriver;
import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 16.01.2017.
 */
public class UserPage extends MobileBasePage {

    public UserPage() {
        super(MobilePlatform.ANDROID);
    }

    private static final By OPEN_MENU = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_menu']", true);

//    Profile User Information

    private static final By USER_AVATAR = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.intouch:id/drawee_user_avatar']", true);
    private static final By USER_NAME = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_user_nickname'] and [@text='%s']", true);
    private static final By SUBSCRIBE_BUTTON = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_follow']", true);

    private static final By COUNTERS_HOLDER = new ByLocator("//android.view.View[@resource-id=" +
            "'com.mgrmobi.intouch:id/counters_holder']", true);

    private static final By HOSTEVENT = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/counter_host'] and", true);
    private static final By FOLLOWERS = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/counter_followers'] ", true);
    private static final By FOLLOWINGS = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/counter_followings']", true);

    private static final By COUNTER_HOSTEVENT = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/counter_host'] and [@text='%s']", true);
    private static final By COUNTER_FOLLOWERS = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/counter_followers'] and [@text='%s']", true);
    private static final By COUNTER_FOLLOWINGS = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/counter_followings'] and [@text='%s']", true);

    private static final By EVENT_NAME = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_event_name']", true);
    private static final By BUTTON_GOING = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_going']", true);

    private static final By PRE_LOADER = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.intouch:id/progress_view']", true);

    private static final String OPEN_EVENT = "//android.support.v7.widget.RecyclerView[@resource-id='com.mgrmobi.intouch:id/id_recycler_view']/" +
            "android.widget.LinearLayout[@index='%d']";
    private static final By COMPLAIN_USER = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_complain_to_user']", true);


    public MainMenuList openMainMenu() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем главное меню, нажимаем на " +
                "элемент c xpath: '%s'", OPEN_MENU.toString()));
        getSearchContext().findElement(OPEN_MENU).click();
        return mobilePageFactory.createPage(MainMenuList.class);
    }

    public boolean isAvatarPresent() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Проверяем есть ли логотип, элемент c xpath: '%s'",
                USER_AVATAR));
        boolean result = ((AppiumExtDriver)getSearchContext()).isPresent(USER_AVATAR);
        if(result) {
            result =  getSearchContext().findElement(USER_AVATAR).isDisplayed();
        }
        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
        return result;
    }

    public boolean isCountersPresent() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Проверяем есть ли логотип, элемент c xpath: '%s'",
                COUNTERS_HOLDER));
        boolean result = ((AppiumExtDriver)getSearchContext()).isPresent(COUNTERS_HOLDER);
        if(result) {
            result =  getSearchContext().findElement(COUNTERS_HOLDER).isDisplayed();
        }
        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
        return result;
    }

    public UserPage subscribe() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем главное меню, нажимаем на " +
                "элемент c xpath: '%s'", SUBSCRIBE_BUTTON.toString()));
        getSearchContext().findElement(SUBSCRIBE_BUTTON).click();
        return this;
    }

    public SubscribersPage openSubscribersPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем главное меню, нажимаем на " +
                "элемент c xpath: '%s'", FOLLOWERS.toString()));
        getSearchContext().findElement(FOLLOWERS).click();
        return mobilePageFactory.createPage(SubscribersPage.class);
    }


    public SubscribedPage openSubscribedPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем главное меню, нажимаем на " +
                "элемент c xpath: '%s'", FOLLOWINGS.toString()));
        getSearchContext().findElement(FOLLOWINGS).click();
        return mobilePageFactory.createPage(SubscribedPage.class);
    }

    public EventPage selectEvent(int number) {
        By locator = new ByLocator(String.format(OPEN_EVENT, number), true);
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем событие под номером - '%d', xpath этого элемента: '%s'", number, locator.toString()));
        getSearchContext().findElement(locator).click();
        return mobilePageFactory.createPage(EventPage.class);
    }



    public ComplainPage complainUserButton() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем редактирование профиля, нажимаем на " +
                "элемент c xpath: '%s'", COMPLAIN_USER.toString()));
        getSearchContext().findElement(COMPLAIN_USER).click();
        return mobilePageFactory.createPage(ComplainPage.class);
    }
}
