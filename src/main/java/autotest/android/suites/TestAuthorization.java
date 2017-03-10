package autotest.android.suites;

import autotest.android.business_objects.UserData;
import autotest.android.pages.*;
import autotest.android.pages.page_enum.MainMenu;
import autotest.android.utils.Utils;
import core.appium.driver.AppiumExtDriver;
import core.logger.LevelLogger;
import core.test_case.BaseTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by zaborovsky on 17.01.2017.
 */
public class TestAuthorization extends BaseTestCase {

    @Test(invocationCount = 1)
    public void authEmail() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);
        if (showappPage.isMainMenuPresent()){
            MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
            if (!(showappPage.isMainMenuOpen())) {
                mainMenuList = showappPage.openMainMenu();
            }
            while (!(showappPage.isMainMenuOpen())){
                showappPage.openMainMenu();
                Utils.sleep(2);
                showappPage.openMainMenu();
            }
            mainMenuList.selectMainMenu(MainMenu.Exit);
        }

        IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
        LogIn login = introPage.openLoginPage();
        UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
        login.setUserData(test_adult);
        showappPage = login.login();
        MainMenuList mainMenuList = showappPage.openMainMenu();
    }

    @Test(invocationCount = 1)
    public void authFacebook() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);

        if (showappPage.isMainMenuPresent()){
            MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
            if (!(showappPage.isMainMenuOpen())) {
                mainMenuList = showappPage.openMainMenu();
            }
            while (!(showappPage.isMainMenuOpen())){
                showappPage.openMainMenu();
                Utils.sleep(2);
                showappPage.openMainMenu();
            }
            mainMenuList.selectMainMenu(MainMenu.Exit);
        }
        IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
        LogIn login = introPage.openLoginPage();
        showappPage = login.loginFacebook();


        logger.log(LevelLogger.SCREEN_ACTION, "Конец теста");
    }

    @Test(invocationCount = 1)
    public void authTwitter() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);
        if (showappPage.isMainMenuPresent()){
            MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
            if (!(showappPage.isMainMenuOpen())) {
                mainMenuList = showappPage.openMainMenu();
            }
            while (!(showappPage.isMainMenuOpen())){
                showappPage.openMainMenu();
                Utils.sleep(2);
                showappPage.openMainMenu();

            }
            mainMenuList.selectMainMenu(MainMenu.Exit);
        }

        IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
        LogIn login = introPage.openLoginPage();
        showappPage = login.loginTwitter();

        logger.log(LevelLogger.SCREEN_ACTION, "Конец теста");
    }

    @Test(invocationCount = 1)
    public void loginVK() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);
        if (showappPage.isMainMenuPresent()){
            MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
            if (!(showappPage.isMainMenuOpen())) {
                mainMenuList = showappPage.openMainMenu();
            }
            while (!(showappPage.isMainMenuOpen())){
                showappPage.openMainMenu();
                Utils.sleep(2);
                showappPage.openMainMenu();

            }
            mainMenuList.selectMainMenu(MainMenu.Exit);
        }
        IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
        LogIn login = introPage.openLoginPage();
        showappPage = login.loginVkontakte();
        logger.log(LevelLogger.SCREEN_ACTION, "Конец теста");
    }

    @Test(invocationCount = 1)
    public void registration() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);
        if (showappPage.isMainMenuPresent()){
            MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
            if (!(showappPage.isMainMenuOpen())) {
                mainMenuList = showappPage.openMainMenu();
            }
            while (!(showappPage.isMainMenuOpen())){
                showappPage.openMainMenu();
                Utils.sleep(2);
                showappPage.openMainMenu();

            }
            mainMenuList.selectMainMenu(MainMenu.Exit);
        }
        IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
        UserData test_adult = new UserData("dafuq12321360122","dafuq12321360122@grr.la", "dafuq12321360122");
        Registration registration = introPage.openRegistrationPage();
        registration.setUserData(test_adult);
        registration = registration.registration().grantLocationPermission();
        showappPage = registration.scrollToPosition("Готово").doneButton().finishRegistration();
//        MainMenuList mainMenuList = showappPage.openMainMenu();
    }

    @Test(invocationCount = 1)
    public void resetPassword() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);
        if (showappPage.isMainMenuPresent()){
            MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
            if (!(showappPage.isMainMenuOpen())) {
                mainMenuList = showappPage.openMainMenu();
            }
            Utils.sleep(4);
            mainMenuList.selectMainMenu(MainMenu.Exit);
        }
        IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
        UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
        LogIn logIn = introPage.openLoginPage();
        ResetPasswordPage resetPasswordPage = logIn.resetPassword();
        resetPasswordPage.hasCode();
//        TODO: Заменить акк на гугловый. Доделать загрузку пароля из гугловой почты.
        resetPasswordPage.typeCode("999372");
//        Utils.sleep(3);
        resetPasswordPage.setUserData(test_adult);

        logIn = resetPasswordPage.resetPassword();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        AppiumExtDriver.stopDriver(AppiumExtDriver.getCurrentDriver());
        //AppiumExtDriver.getCurrentDriver().closeApp();
    }
}
