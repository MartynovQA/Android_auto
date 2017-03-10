package autotest.android.pages;

import autotest.android.utils.Utils;
import core.appium.driver.AppiumExtDriver;
import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 27.01.2017.
 */
public class CreateEventPage extends MobileBasePage {

    private static final By OPEN_MENU = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_menu']", true);

    private static final By SET_PHOTO = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_take_photo']", true);
    private static final By FROM_CAMERA = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_from_camera']", true);
    /*
    * locators for sgs4
    * */
    private static final By CAMERA_SHOT = new ByLocator("//android.view.View[@resource-id=" +
            "'com.mgrmobi.intouch:id/camera_control_button']", true);
    private static final By CAMERA_ACCEPT = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_accept_photo']", true);



    private static final By FROM_GALLERY = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_from_gallery']", true);
    private static final String SELECT_IMAGE_BY_ID = "//android.support.v7.widget.RecyclerView[@resource-id='com.mgrmobi.intouch:id/id_recycler_view']/" +
            "android.widget.FrameLayout[@index='%d']";


    private static final By ADD_TITLE = new ByLocator("//android.widget.TextView[@text=" +
            "'Введи название']", true);
    private static final By TYPE_TITLE = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_text']", true);
    private static final By SET_DATE = new ByLocator("//android.widget.TextView[@text=" +
            "'Выбери дату и время']", true);
    private static final By SET_LOCATION = new ByLocator("//android.widget.TextView[@text=" +
            "'Выбери место']", true);
    private static final By SEARCH_LOCATION = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_show_search']", true);

    private static final By SET_DESCRIPTION = new ByLocator("//android.widget.TextView[@text=" +
            "'Добавь описание']", true);
    private static final By TYPE_DESCRIPTION = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_text']", true);

    private static final By SET_AGE_RATING = new ByLocator("//android.widget.TextView[@text=" +
            "'Выбери минимальный возраст']", true);
    private static final By AGE_RATING_ALL = new ByLocator("//android.widget.RadioButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/rating_for_0']", true);
    private static final By AGE_RATING_4 = new ByLocator("//android.widget.RadioButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/rating_for_4']", true);
    private static final By AGE_RATING_12 = new ByLocator("//android.widget.RadioButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/rating_for_12']", true);
    private static final By AGE_RATING_16 = new ByLocator("//android.widget.RadioButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/rating_for_16']", true);
    private static final By AGE_RATING_18 = new ByLocator("//android.widget.RadioButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/rating_for_18']", true);

    private static final By SET_PRIVACY_STATUS = new ByLocator("//android.widget.TextView[@text=" +
            "'Укажи приватность']", true);
    private static final By SET_PUBLIC = new ByLocator("//android.widget.RadioButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/status_public']", true);
    private static final By SET_PRIVATE = new ByLocator("//android.widget.RadioButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/status_private']", true);

    private static final By SET_EVENT_SIZE = new ByLocator("//android.widget.TextView[@text=" +
            "'Выбери размер события']", true);
    private static final By BUY_TICKET_HERE = new ByLocator("//android.widget.TextView[@text=" +
            "'Укажи ссылку на сервис продажи билетов']", true);
    private static final By TYPE_LINK_FOR_TICKETS = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_text']", true);

    private static final By APPLY_BUTTON = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_apply']", true);
    private static final By PUBLISH_BUTTON = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_publish']", true);


    private static final By FINISH_BUTTON = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_finish']", true);

    public CreateEventPage() {
        super(MobilePlatform.ANDROID);
    }

    public MainMenuList openMainMenu() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем главное меню, нажимаем на " +
                "элемент c xpath: '%s'", OPEN_MENU.toString()));
        getSearchContext().findElement(OPEN_MENU).click();
        return mobilePageFactory.createPage(MainMenuList.class);
    }

    public CreateEventPage addPhotoButton() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", SET_PHOTO.toString()));
        getSearchContext().findElement(SET_PHOTO).click();
        return this;
    }

    public CreateEventPage addPhotoFromGallery() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", FROM_GALLERY.toString()));
        getSearchContext().findElement(FROM_GALLERY).click();
        return this;
    }

    public CreateEventPage selectPhotoFromGallery(int number) {
        By locator = new ByLocator(String.format(SELECT_IMAGE_BY_ID, number), true);
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выбираем фотографию под номером - '%d', xpath этого элемента: '%s'", number, locator.toString()));
        getSearchContext().findElement(locator).click();
        return this;
    }

    public CreateEventPage setTitle() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Переходим на экран ввода названия события, нажимаем на элемент c xpath: '%s'", ADD_TITLE.toString()));
        getSearchContext().findElement(ADD_TITLE).click();
        return this;
    }

    public CreateEventPage applyButton() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Нажимаем кнопку 'Применить', элемент c xpath: '%s'", APPLY_BUTTON.toString()));
        getSearchContext().findElement(APPLY_BUTTON).click();
        return this;
    }

    public CreateEventPage setLocation() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Нажимаем кнопку 'Установить локацию', элемент c xpath: '%s'", SET_LOCATION.toString()));
        getSearchContext().findElement(SET_LOCATION).click();
        return this;
    }

    public CreateEventPage setLocationInMiddle() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Нажимаем кнопку 'Установить локацию', элемент c xpath: '%s'", SET_LOCATION.toString()));
        ((AppiumExtDriver) getSearchContext()).clicInMiddle();
        return this;
    }

    public CreateEventPage searchLocation(String searchQuery) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", SEARCH_LOCATION.toString()));
        getSearchContext().findElement(SEARCH_LOCATION).click();
        getSearchContext().findElement(SEARCH_LOCATION).sendKeys(searchQuery);
     /* Далее идет махровый хардкод, сделано чтобы закостылить выбор из поиска т.к. гугловое апи было криво прокинруто
     * */
        Utils.sleep(2);

        ((AppiumExtDriver) getSearchContext()).tap(1, 450, 275, 150);
        return this;
    }



//    public CreateEventPage setLocation() {
//
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", SEARCH_LOCATION.toString()));
//        getSearchContext().findElement(SEARCH_LOCATION).click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        int width = ((Long) js.executeScript("return window.innerWidth || document.body.clientWidth")).intValue() ;
//        LLLogs.getLogger().info("width value calculated is :" +width);
//        int height = ((Long) js.executeScript("return window.innerHeight || document.body.clientHeight")).intValue() ;
//        LLLogs.getLogger().info("height value calculated is :" +height);
//        Dimension dimension  = new Dimension(width, height);
//     /* Далее идет махровый хардкод, сделано чтобы закостылить выбор из поиска т.к. гугловое апи было криво прокинруто
//     * */
//
//        ((AppiumExtDriver) getSearchContext()).tap(1, 450, 275, 150);
//        return this;
//    }



    public CreateEventPage setPrivate() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Устанавливаем событие приватны', элемент c xpath: '%s'", SET_PRIVATE.toString()));
        getSearchContext().findElement(SET_PRIVATE).click();
        return this;
    }

    public CreateEventPage typeTitle(String searchQuery) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим название события в элемент c xpath: '%s'", TYPE_TITLE.toString()));
        getSearchContext().findElement(TYPE_TITLE).click();
        getSearchContext().findElement(TYPE_TITLE).sendKeys(searchQuery);
        return this;
    }

    public CreateEventPage typeDescription(String titleQuery) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим описание события в элемент c xpath: '%s'", TYPE_DESCRIPTION.toString()));
        getSearchContext().findElement(TYPE_TITLE).click();
        getSearchContext().findElement(TYPE_TITLE).sendKeys(titleQuery + "\\n");
        return this;
    }

    public CreateEventPage typeTicketLink(String titleQuery) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", TYPE_LINK_FOR_TICKETS.toString()));
        getSearchContext().findElement(TYPE_LINK_FOR_TICKETS).click();
        getSearchContext().findElement(TYPE_LINK_FOR_TICKETS).sendKeys(titleQuery + "\\n");
        return this;
    }

    public CreateEventPage publishButton() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выбираем 'Опубликовать', элемент c xpath: '%s'", PUBLISH_BUTTON.toString()));
        String result = getSearchContext().findElement(PUBLISH_BUTTON).getText();
        logger.log(LevelLogger.SCREEN_INFO, String.format("Содержимое кнопки => %s", result));
        getSearchContext().findElement(PUBLISH_BUTTON).click();
        return this;
    }

    public String getPublishText() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем текст кнопки с Опубликовать, ее xpath '%s'.",
                PUBLISH_BUTTON.toString()));
        String result = getSearchContext().findElement(PUBLISH_BUTTON).getText();
        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
        return result;
    }

    public CreateEventPage finishButton() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выбираем 'Опубликовать', элемент c xpath: '%s'", FINISH_BUTTON.toString()));
        getSearchContext().findElement(FINISH_BUTTON).click();
        return this;
    }

    public UserPage openSubscribedByNumber() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", SET_PHOTO.toString()));
        getSearchContext().findElement(SET_PHOTO).click();
        return mobilePageFactory.createPage(UserPage.class);
    }
}
