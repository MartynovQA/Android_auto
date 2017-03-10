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
import org.testng.asserts.SoftAssert;

/**
 * Created by zaborovsky on 31.01.2017.
 */
public class TestEvents extends BaseTestCase {
    SoftAssert softAssert = new SoftAssert();

    @Test(invocationCount = 1)
    public void createEvent() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);
        MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
        if (!(showappPage.isMainMenuPresent())){
            IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
            LogIn login = introPage.openLoginPage();
            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
            login.setUserData(test_adult);
            showappPage = login.login();
        }
        showappPage.openMainMenu();
        while (!(showappPage.isMainMenuOpen())){
            showappPage.openMainMenu();
            Utils.sleep(2);
            showappPage.openMainMenu();
        }
        CreateEventPage createEventPage = mainMenuList.selectMainMenu(MainMenu.Create);
        CreateEventPage image = createEventPage.addPhotoButton().addPhotoFromGallery();
        image.selectPhotoFromGallery(0);
        createEventPage.setTitle().typeTitle("KremlinTest");
        createEventPage.applyButton().applyButton();
//        createEventPage.setLocation();
//        createEventPage.setLocationInMiddle().applyButton();
        createEventPage.searchLocation("Kremlin").applyButton();
        createEventPage.typeDescription("Kremlin Tests");
        createEventPage.applyButton().applyButton();
        createEventPage.setPrivate().applyButton().applyButton();
        createEventPage.typeTicketLink("goo.gl").applyButton();
        String st = createEventPage.getPublishText();
        softAssert.assertEquals(st, "Опубликовать", "No avatar");
        createEventPage.publishButton();
//        createEventPage.applyButton();
//        Utils.sleep(5);
    }

    @Test(invocationCount = 0)
    public void scrollTo() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);

        MainMenuList mainMenuList = showappPage.openMainMenu();

        Utils.sleep(1);

        DiscoverPage discoverPage = mainMenuList.openDiscoverPage();
        SearchPage searchPage = discoverPage.openSearchPage().search("3");
        Utils.sleep(5);
//        searchPage.scrollToPosition("Выставка «Русское влияние на музыку и танец в Америке»");
        EventPage eventPage = searchPage.selectEventByNumber(1);

        eventPage.scrollToPosition("Выставка «Русское влияние на музыку и танец в Америке»");

        Utils.sleep(5);

        logger.log(LevelLogger.SCREEN_ACTION, "Конец теста");
    }

    @Test(invocationCount = 1)
    public void editEvent() throws InterruptedException {
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);
        MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
        if (!(showappPage.isMainMenuPresent())){
            IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
            LogIn login = introPage.openLoginPage();
            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
            login.setUserData(test_adult);
            showappPage = login.login();
        }
        showappPage.openMainMenu();
        while (!(showappPage.isMainMenuOpen())){
            showappPage.openMainMenu();
            Utils.sleep(1);
            showappPage.openMainMenu();
        }
        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
        Utils.sleep(1);
        profilePage.openCreatedEventsPage();

        EventPage eventPage = profilePage.selectEventByNumber(0);
        Utils.sleep(2);
        CreateEventPage editEvent = eventPage.openMoreMenu().openEditEventPage();

        editEvent.setTitle().typeTitle("Moscow").applyButton();
        editEvent.publishButton();
        Utils.sleep(10);
        softAssert.assertEquals(eventPage.getEventName(), "KremlinTestMoscow","Event name mismatch");

        logger.log(LevelLogger.SCREEN_ACTION, "Конец теста");
    }

    @Test(invocationCount = 1)
    public void commentWithUser() throws InterruptedException {
        ShowappPage showappPage = mobilePageFactory.createPage(ShowappPage.class);
        MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
        if (!(showappPage.isMainMenuPresent())){
            IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
            LogIn login = introPage.openLoginPage();
            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
            login.setUserData(test_adult);
            showappPage = login.login();
        }
        showappPage.openMainMenu();
        while (!(showappPage.isMainMenuOpen())){
            showappPage.openMainMenu();
            Utils.sleep(1);
            showappPage.openMainMenu();
        }
        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
        Utils.sleep(1);
        profilePage.openCreatedEventsPage();

        EventPage eventPage = profilePage.selectEventByNumber(0);
        eventPage.scrollToPosition("Добавить комментарий");
        eventPage.addComment("@dafuq go to");
//        Utils.sleep(2);


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
        UserData test_adult = new UserData("dafuq12321356","dafuq12321356@grr.la", "dafuq12321356");
        Registration registration = introPage.openRegistrationPage();
        registration.setUserData(test_adult);
        showappPage = registration.registration().doneButton().finishRegistration();
        MainMenuList mainMenuList = showappPage.openMainMenu();
    }



    @AfterMethod
    public void tearDown() throws Exception {
        AppiumExtDriver.stopDriver(AppiumExtDriver.getCurrentDriver());
//        AppiumExtDriver.getCurrentDriver().closeApp();

    }
}
