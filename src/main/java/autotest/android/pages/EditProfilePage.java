package autotest.android.pages;

import autotest.android.business_objects.UserData;
import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 23.01.2017.
 */
public class EditProfilePage extends MobileBasePage {

    private static final By AVATAR_BACKGROUND = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/drawee_avatar_background']", true);
    private static final By AVATAR = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.intouch:id/drawee_avatar']", true);

    private static final By USERNAME = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_username']", true);
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

//    Calendar


    public EditProfilePage() {
        super(MobilePlatform.ANDROID);
    }

    public EditProfilePage typeUsername(String email) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим Username в элемент c xpath: '%s'", USERNAME.toString()));
        getSearchContext().findElement(USERNAME).sendKeys(email);
        return this;
    }

    public EditProfilePage typeFio(String email) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим фамилию и имя в элемент c xpath: '%s'", FIO.toString()));
        getSearchContext().findElement(FIO).sendKeys(email);
        return this;
    }

    public EditProfilePage typeAbout(String password) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим данные about в элемент c xpath: '%s'", ABOUT.toString()));
        getSearchContext().findElement(ABOUT).sendKeys(password + "\\n");
        return this;
    }

    public EditProfilePage setUserData(UserData userData) {
        typeUsername(userData.getUsername());
        typeFio(userData.getEmail());
        typeAbout(userData.getPassword());
        return this;
    }

}
