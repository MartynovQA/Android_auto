package autotest.android.suites;

import autotest.android.business_objects.UserData;
import autotest.android.pages.*;
import autotest.android.pages.page_enum.MainMenu;
import core.appium.driver.AppiumExtDriver;
import core.logger.LevelLogger;
import core.test_case.BaseTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
/**
 * Created by zaborovsky on 23.01.2017.
 */
public class TestProfile extends BaseTestCase{
    SoftAssert softAssert = new SoftAssert();

    @Test(invocationCount = 1)
    public void checkProfile() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);
        if (!(showappPage.isMainMenuPresent())){
            IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
            LogIn login = introPage.openLoginPage();
            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
            login.setUserData(test_adult);
            showappPage = login.login();
        }
        if (showappPage.isMainMenuOpen()) {
            MainMenuList mainMenuList = showappPage.openMainMenu();
        }
        MainMenuList mainMenuList = showappPage.openMainMenu();
        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
        softAssert.assertTrue(profilePage.isAvatarPresent(), "No avatar");

    }

    @Test(invocationCount = 1)
    public void checkSubscribers() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);
        if (!(showappPage.isMainMenuPresent())){
            IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
            LogIn login = introPage.openLoginPage();
            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
            login.setUserData(test_adult);
            showappPage = login.login();
        }
        if (showappPage.isMainMenuOpen()) {
            MainMenuList mainMenuList = showappPage.openMainMenu();
        }
        MainMenuList mainMenuList = showappPage.openMainMenu();
        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
//        EventPage eventPage = profilePage.selectEvent(0);
        SubscribersPage subscribersPage = profilePage.openSubscribersPage();
        subscribersPage.subscribeByNumber(4);

    }

    @Test(invocationCount = 1)
    public void searchSubscriber() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);
        if (!(showappPage.isMainMenuPresent())){
            IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
            LogIn login = introPage.openLoginPage();
            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
            login.setUserData(test_adult);
            showappPage = login.login();
        }
//        if (showappPage.isMainMenuOpen()) {
//            MainMenuList mainMenuList = showappPage.openMainMenu();
//        }
        MainMenuList mainMenuList = showappPage.openMainMenu();
        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
        SubscribersPage subscribersPage = profilePage.openSubscribersPage();
        String str = "BBTouch1";
        subscribersPage.search(str+"\n");
        String nick = subscribersPage.getSubscriberNickByNumber(0);
        nick.indexOf("BB");
        softAssert.assertEquals(subscribersPage.getSubscriberNickByNumber(0), str, "Wrong user found");
//        Utils.sleep(5);
    }

    @Test(invocationCount = 1)
    public void enterIntoSubscriber() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);
        if (!(showappPage.isMainMenuPresent())){
            IntroPage introPage =   mobilePageFactory.createPage(IntroPage.class);
            LogIn login = introPage.openLoginPage();
            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
            login.setUserData(test_adult);
            showappPage = login.login();
        }
//        if (showappPage.isMainMenuOpen()) {
//            MainMenuList mainMenuList = showappPage.openMainMenu();
//        }
        MainMenuList mainMenuList = showappPage.openMainMenu();
        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
        SubscribersPage subscribersPage = profilePage.openSubscribersPage();
        subscribersPage.openSubscriberByNumber(0);
    }

    @Test(invocationCount = 1)
    public void subscribeFromProfile() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);
        if (!(showappPage.isMainMenuPresent())){
            IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
            LogIn login = introPage.openLoginPage();
            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
            login.setUserData(test_adult);
            showappPage = login.login();
        }
        if (showappPage.isMainMenuOpen()) {
            MainMenuList mainMenuList = showappPage.openMainMenu();
        }
        MainMenuList mainMenuList = showappPage.openMainMenu();
        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
//        EventPage eventPage = profilePage.selectEvent(0);
        SubscribersPage subscribersPage = profilePage.openSubscribersPage();
        UserPage userPage = subscribersPage.openSubscriberByNumber(1);
        userPage.subscribe();
    }

    @Test(invocationCount = 1)
    public void favoriteEvents() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);
        if (!(showappPage.isMainMenuPresent())){
            IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
            LogIn login = introPage.openLoginPage();
            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
            login.setUserData(test_adult);
            showappPage = login.login();
        }
        if (showappPage.isMainMenuOpen()) {
            MainMenuList mainMenuList = showappPage.openMainMenu();
        }
        MainMenuList mainMenuList = showappPage.openMainMenu();
        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
//        EventPage eventPage = profilePage.selectEvent(0);
        profilePage.selectFavorite().selectEventByNumber(0);

    }

    @AfterMethod
    public void tearDown() throws Exception {
        AppiumExtDriver.getCurrentDriver().closeApp();
        AppiumExtDriver.stopDriver(AppiumExtDriver.getCurrentDriver());

    }


}
