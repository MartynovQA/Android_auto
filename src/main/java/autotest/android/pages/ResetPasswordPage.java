package autotest.android.pages;

import autotest.android.business_objects.UserData;
import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.condition.SearchContextConditions;
import core.condition.Waiter;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 23.01.2017.
 */
public class ResetPasswordPage extends MobileBasePage {

    private static final By EMAIL = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_email']", true);
    private static final By CODE = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_code']", true);
    private static final By PASSWORD = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_password']", true);
    private static final By RESET = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_reset']", true);
    private static final By HAS_CODE = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_already_has_code']", true);

    private static final By PRE_LOADER = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.intouch:id/progress_view']", true);


    public ResetPasswordPage() {
        super(MobilePlatform.ANDROID);
    }




    public ResetPasswordPage typeEmail(String email) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим email в элемент c xpath: '%s'", EMAIL.toString()));
        getSearchContext().findElement(EMAIL).sendKeys(email);
        return this;
    }

    public ResetPasswordPage typeCode(String code) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим код в элемент c xpath: '%s'", CODE.toString()));
        getSearchContext().findElement(CODE).sendKeys(code);
        return this;
    }

    public ResetPasswordPage typePassword(String password) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим пароль в элемент c xpath: '%s'", PASSWORD.toString()));
        getSearchContext().findElement(PASSWORD).sendKeys(password + "\\n");
        return this;
    }

    public ResetPasswordPage setUserData(UserData userData) {
        typeEmail(userData.getEmail());
        typePassword(userData.getPassword());
//        (AppiumExtDriver).sendKeyEvent(AndroidKeyCode.BACK);
        return this;
    }

    public ResetPasswordPage hasCode() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране восстановления пароля нажимаем на " +
                "У меня есть код, элемент c xpath: '%s'", HAS_CODE.toString()));
        getSearchContext().findElement(HAS_CODE).click();
        return this;
    }

    public LogIn resetPassword() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране восстановления пароля нажимаем на " +
                "Войти, элемент c xpath: '%s'", RESET.toString()));
        getSearchContext().findElement(RESET).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "после окончания регистрации не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(LogIn.class);
    }




}
