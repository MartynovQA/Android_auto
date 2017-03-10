package autotest.android.pages;

import core.appium.driver.AppiumExtDriver;
import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.condition.SearchContextConditions;
import core.condition.Waiter;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by zaborovsky on 12.01.2017.
 */
public class EventPage extends MobileBasePage {
    private static final By OPEN_MENU = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_menu']", true);
    private static final By EVENT_NAME = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_event_name']", true);
    private static final By BUTTON_GOING = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_going']", true);
    private static final By GOING_FIELD = new ByLocator("//android.view.View[@resource-id=" +
            "'com.mgrmobi.intouch:id/id_widget_going_users']", true);

    private static final By OPEN_MORE_MENU = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_more']", true);
    private static final By EDIT_EVENT = new ByLocator("//android.widget.TextView[@text=" +
            "'Изменить']", true);
    private static final By SHARE_EVENT = new ByLocator("//android.widget.TextView[@text=" +
            "'Поделиться…']", true);
    private static final By ADD_TO_FAVORITE = new ByLocator("//android.widget.TextView[@text=" +
            "'Добавить в Избранное']", true);

    private static final By TEXT_DATE = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_date_header']", true);
    private static final By START_EVENT_DATE = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_date_start']", true);
    private static final By FINISH_EVENT_DATE = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_date_finish']", true);
    private static final By LOCATION = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_location_name']", true);
    private static final By AUTHOR_NAME = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_event_author_name']", true);
    private static final By EVENT_DESCRIPTION = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_location_name']", true);
    private static final By ADD_COMMENT = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_add_comment']", true);
    private static final By TYPE_COMMENT = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_location_name']", true);
    private static final By SEND_COMMENT = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_send_comment']", true);
    private static final By COMMENT_AUTOCOMPLITE = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/comment_autocomplete']", true);


    private static final By COMMENT_HOLDER = new ByLocator("//android.widget.LinearLayout[@resource-id=" +
            "'com.mgrmobi.intouch:id/holder_comment_text']", true);
    private static final String TEXT_COMMENT = "//android.widget.TextView[@resource-id='com.mgrmobi.intouch:id/text_comment']";


    private static final By PRE_LOADER = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.intouch:id/progress_view']", true);

    private static final By BODY = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.intouch:id/id_event_cover_drawee']", true);
    private static final String ITEM_XPATH_PATTERN = "//android.widget.FrameLayout[android.widget.LinearLayout/" +
            "android.widget.LinearLayout/android.widget.TextView[@text='%s']]";

    public EventPage() {
        super(MobilePlatform.ANDROID);
    }

    public MainMenuList openMainMenu() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем главное меню, нажимаем на " +
                "элемент c xpath: '%s'", OPEN_MENU.toString()));
        getSearchContext().findElement(OPEN_MENU).click();
        return mobilePageFactory.createPage(MainMenuList.class);
    }

    public EventPage openMoreMenu() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем дополнительное меню, нажимаем на " +
                "элемент c xpath: '%s'", OPEN_MORE_MENU.toString()));
        getSearchContext().findElement(OPEN_MORE_MENU).click();
        return this;
    }

    public CreateEventPage openEditEventPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем дополнительное меню, нажимаем на " +
                "элемент c xpath: '%s'", EDIT_EVENT.toString()));
        getSearchContext().findElement(EDIT_EVENT).click();
        return mobilePageFactory.createPage(CreateEventPage.class);
    }


    public EventPage scrollToPosition(String text) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Прокручиваем список пунктов меню, до появления " +
                "пункта с текстом - '%s', элемент c xpath: '%s'", text, BODY.toString()));
        WebElement scroll = getSearchContext().findElement(BODY);
        ((AppiumExtDriver) getSearchContext()).scrollToText(scroll, text, true);
        return this;
    }

    public <T extends MobileBasePage> T selectItem(String position, Class cl) {
        By locator = new ByLocator(String.format(ITEM_XPATH_PATTERN, position), true);
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выбираем пункт - '%s',нажимаем на элемент c xpath: '%s'",
                position, locator.toString()));
        getSearchContext().findElement(locator).click();
        return (T)mobilePageFactory.createPage(cl);
    }


    public String getEventName() {
        String eventName = getSearchContext().findElement(EVENT_NAME).getText();
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем имя события, элемент с xpath: '%s'", EVENT_NAME.toString()));
        return eventName;
    }

    public String getEventStart() {
        String eventName = getSearchContext().findElement(START_EVENT_DATE).getText();
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем время начала события, элемент с xpath: '%s'", EVENT_NAME.toString()));
        return eventName;
    }

    public EventPage pressGoingButton() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране авторизации нажимаем на " +
                "Войти, элемент c xpath: '%s'", BUTTON_GOING.toString()));
        getSearchContext().findElement(BUTTON_GOING).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "после авторизации страница не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return this;
    }

    public EventPage addComment(String searchQuery) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Нажимаем в элемент c xpath: '%s', перехеодим на экран комментариев", ADD_COMMENT.toString()));
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", TYPE_COMMENT.toString()));
        getSearchContext().findElement(ADD_COMMENT);
        getSearchContext().findElement(COMMENT_AUTOCOMPLITE).sendKeys(searchQuery);
        getSearchContext().findElement(SEND_COMMENT).click();
        return this;
    }
}
