package autotest.android.pages;

import autotest.android.business_objects.UserData;
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
 * Created by zaborovsky on 21.12.2016.
 */
public class Registration extends MobileBasePage {
//    private static final By EMAIL = new ByLocator"//android.widget.EditText[@resource-id="+"com.mgrmobi.intouch:id/et_email";

    private static final By USERNAME = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_username']", true);
    private static final By EMAIL = new ByLocator("//android.widget.EditText[@resource-id=" +
        "'com.mgrmobi.intouch:id/et_email']", true);
    private static final By PASSWORD = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_password']", true);
    private static final By REGISTRATION_BUTTON = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_signup']", true);

    private static final By FIO = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_name']", true);
    private static final By ABOUT = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_about']", true);
    private static final By GENDER_MALE = new ByLocator("//android.widget.RadioButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/radio_button_male']", true);
    private static final By GENDER_FEMALE = new ByLocator("//android.widget.RadioButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/radio_button_female']", true);
    private static final By BIRTHDAY = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_birthdate']", true);
    private static final By INTERESTS = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/interests_autocomplete']", true);
    private static final By CITY = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_city']", true);
    private static final By LINK = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_link']", true);

    private static final By DONE_BUTTON = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_done']", true);
    private static final By GRANT_LOCATION_PERMISSION = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_grant_location_permission']", true);


    private static final By SKIP_BUTTON = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_action']", true);

    private static final By PRE_LOADER = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.intouch:id/progress_view']", true);

    private static final By BODY = new ByLocator("//android.widget.ScrollView[@resource-id=" +
            "'com.mgrmobi.intouch:id/scroll_profile_data']", true);


    public Registration() {
        super(MobilePlatform.ANDROID);
    }

    public Registration typeUsername(String email) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим Username в элемент c xpath: '%s'", USERNAME.toString()));
        getSearchContext().findElement(USERNAME).sendKeys(email);
        return this;
    }

    public Registration typeEmail(String email) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим email в элемент c xpath: '%s'", EMAIL.toString()));
        getSearchContext().findElement(EMAIL).sendKeys(email);
        return this;
    }

    public Registration typePassword(String password) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим пароль в элемент c xpath: '%s'", PASSWORD.toString()));
        getSearchContext().findElement(PASSWORD).sendKeys(password + "\\n");
        return this;
    }

    public Registration setUserData(UserData userData) {
        typeUsername(userData.getUsername());
        typeEmail(userData.getEmail());
        typePassword(userData.getPassword());
        return this;
    }

    public Registration registration() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране регистрации нажимаем на кнопку" +
                "Регистрации, элемент c xpath: '%s'", REGISTRATION_BUTTON.toString()));
        getSearchContext().findElement(REGISTRATION_BUTTON).click();
        return this;
    }

    public Registration doneButton() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране регистрации нажимаем на кнопку" +
                "Регистрации, элемент c xpath: '%s'", DONE_BUTTON.toString()));
        getSearchContext().findElement(DONE_BUTTON).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "после авторизации страница не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return this;
    }

    public Registration grantLocationPermission() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране авторизации нажимаем на " +
                "Определить местоположение, элемент c xpath: '%s'", GRANT_LOCATION_PERMISSION.toString()));
        getSearchContext().findElement(GRANT_LOCATION_PERMISSION).click();
        return this;
    }

    public Registration scrollToPosition(String text) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Прокручиваем список пунктов меню, до появления " +
                "пункта с текстом - '%s', элемент c xpath: '%s'", text, BODY.toString()));
        WebElement scroll = getSearchContext().findElement(BODY);
        ((AppiumExtDriver) getSearchContext()).scrollToText(scroll, text, true);
        return this;
    }

    public ShowappPage finishRegistration() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране авторизации нажимаем на " +
                "Войти, элемент c xpath: '%s'", SKIP_BUTTON.toString()));
        getSearchContext().findElement(SKIP_BUTTON).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "после окончания регистрации не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(ShowappPage.class);
    }


}
