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
 * Created by zaborovsky on 21.12.2016.
 */
public class LogIn extends MobileBasePage {

    private static final By EMAIL = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_email']", true);
    private static final By PASSWORD = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/et_password']", true);
    private static final By LOGIN = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_login']", true);
    private static final By CREATE_ACCOUNT = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_create_account']", true);
    private static final By FACEBOOK = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_connect_facebook']", true);
    private static final By TWITTER = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_connect_twitter']", true);
    private static final By ALLOW_TW = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.twitter.android:id/ok_button']", true);
    private static final By VKONTAKTE = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_connect_vk']", true);
    private static final By ALLOW_VK = new ByLocator("//android.view.View[@content-desc=" +
            "'РАЗРЕШИТЬ']", true);

    private static final By RESET = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_forgot_password']", true);

    private static final By PRE_LOADER = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.intouch:id/progress_view']", true);




    public LogIn() {
        super(MobilePlatform.ANDROID);
    }

    public LogIn typeEmail(String email) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим email в элемент c xpath: '%s'", EMAIL.toString()));
        getSearchContext().findElement(EMAIL).sendKeys(email);
        return this;
    }

    public LogIn typePassword(String password) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим пароль в элемент c xpath: '%s'", PASSWORD.toString()));
        getSearchContext().findElement(PASSWORD).sendKeys(password + "\\n");
        return this;
    }

    public LogIn setUserData(UserData userData) {
        typeEmail(userData.getEmail());
        typePassword(userData.getPassword());
//        (AppiumExtDriver).sendKeyEvent(AndroidKeyCode.BACK);
        return this;
    }

    public ShowappPage loginFacebook() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране авторизации нажимаем на " +
                "Войти, элемент c xpath: '%s'", FACEBOOK.toString()));
        getSearchContext().findElement(FACEBOOK).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "после авторизации страница не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(ShowappPage.class);
    }

    public ShowappPage loginTwitter() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране авторизации нажимаем на " +
                "Войти, элемент c xpath: '%s'", TWITTER.toString()));
        getSearchContext().findElement(TWITTER).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "после авторизации страница не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.visibilityOfElementLocated(ALLOW_TW));
        getSearchContext().findElement(ALLOW_TW).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "после авторизации страница не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(ShowappPage.class);
    }

    public ShowappPage loginVkontakte() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране авторизации нажимаем на " +
                "Войти, элемент c xpath: '%s'", VKONTAKTE.toString()));
        getSearchContext().findElement(VKONTAKTE).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "после выбора авторизации через VK, не загрузилась страница разрешения доступа в течение %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.visibilityOfElementLocated(ALLOW_VK));
        getSearchContext().findElement(ALLOW_VK).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "после авторизации страница не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(ShowappPage.class);
    }

    public ResetPasswordPage resetPassword() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране авторизации нажимаем на " +
                "Забыли пароль?, элемент c xpath: '%s'", RESET.toString()));
        getSearchContext().findElement(RESET).click();
        return mobilePageFactory.createPage(ResetPasswordPage.class);
    }

    public ShowappPage login() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране авторизации нажимаем на " +
                "Войти, элемент c xpath: '%s'", LOGIN.toString()));
        getSearchContext().findElement(LOGIN).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "после авторизации страница не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(ShowappPage.class);
    }

}
