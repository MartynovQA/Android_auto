package autotest.android.pages;

import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 09.01.2017.
 */
public class IntroPage extends MobileBasePage{


    private static final By REGISTRATION = new ByLocator("//android.widget.Button[@resource-id=" + "'com.mgrmobi.intouch:id/button_signup']", true);
    private static final By MAIN_LOGIN = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_login']", true);

    public IntroPage() {
        super(MobilePlatform.ANDROID);
    }



    public LogIn openLoginPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем страницу авторизации, нажимаем на " +
                "Войти, элемент c xpath: '%s'", MAIN_LOGIN.toString()));
        getSearchContext().findElement(MAIN_LOGIN).click();
        return mobilePageFactory.createPage(LogIn.class);
    }

    public Registration openRegistrationPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем страницу регистрации, нажимаем на кнопку " +
                "Регистрация, элемент c xpath: '%s'", REGISTRATION.toString()));
        getSearchContext().findElement(REGISTRATION).click();
        return mobilePageFactory.createPage(Registration.class);
    }
}
