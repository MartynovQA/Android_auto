package autotest.android.suites;

import autotest.android.business_objects.UserData;
import autotest.android.pages.*;
import autotest.android.utils.Utils;
import core.appium.driver.AppiumExtDriver;
import core.logger.LevelLogger;
import core.test_case.BaseTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


/**
 * Created by zaborovsky on 21.12.2016.
 */
public class TestRegistration extends BaseTestCase{

    @Test(invocationCount = 1)
    public void test() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");

        IntroPage myIntroLogin = mobilePageFactory.createPage(IntroPage.class);
//        Registration login = myIntroLogin.openRegistrationPage();

        LogIn login = myIntroLogin.openLoginPage();
//        Utils.sleep(600);
//        UserData test_user = new UserData();
// TODO: Сделать генерацию юзера в виде метода в бизнес-объекте
//        TODO: Додебажить загрузку всей тестовой инфы из общей проперти
//        login.typeUserData(test_user);
//
//        Выполнение входа в приложение
//        login.typeEmail("dafuq@grr.la");
        UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
//        Utils.sleep(5);

        login.setUserData(test_adult);



        ShowappPage showappPage = login.login();

//        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);

        MainMenuList mainMenuList = showappPage.openMainMenu();

        Utils.sleep(1);

        DiscoverPage discoverPage = mainMenuList.openDiscoverPage();
        SearchPage searchPage = discoverPage.openSearchPage().search("3");

        EventPage eventPage = searchPage.selectEventByNumber(1);
        String eventName = eventPage.getEventName();
        eventPage.pressGoingButton();
        mainMenuList = eventPage.openMainMenu();
        Utils.sleep(5);
        mainMenuList.performExit();
//        Utils.sleep(3);
//        ProfilePage profilePage = mainMenuList.openProfilePage();
//        Utils.sleep(5);
//        profilePage.selectEvent(0);
//        String eventProfileName = eventPage.getEventName();





//        EventPage
//
//        searchBar.openSearch();

//        ShowappPage showappPage = login.login();
//
//        search = openMenu.openSearchPage.searchRequest("выставк")
//
//        mainMenuList.performExit();
//        Utils.sleep(5);
        logger.log(LevelLogger.SCREEN_ACTION, "Конец теста");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        AppiumExtDriver.stopDriver(AppiumExtDriver.getCurrentDriver());
        //AppiumExtDriver.getCurrentDriver().closeApp();
    }
}
