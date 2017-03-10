package autotest.android.pages;

import autotest.android.pages.page_enum.MainMenu;
import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.condition.SearchContextConditions;
import core.condition.Waiter;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 27.12.2016.
 */
public class MainMenuList extends MobileBasePage {
    private static final String ITEM_MENU_XPATH_PATTERN = "//android.widget.TextView[@text='%s']";

    private static final By LIVE = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/menu_live']", true);

    private static final By SHOWAPP_LOGO = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/app_name_in_menu']", true);

    private static final By DISCOVER = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/menu_discover']", true);

    private static final By AVAILABLE = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/menu_available']", true);

    private static final By ACTIVITIES = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/menu_activities']", true);

    private static final By CREATE_EVENT = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/menu_create_even']", true);

    private static final By PROFILE = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/menu_profile']", true);

    private static final By SETTINGS = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/menu_settings']", true);

    private static final By EXIT = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/menu_exit']", true);

    private static final By PRE_LOADER = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.intouch:id/progress_view']", true);



    private static final By OPEN_MENU = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_menu']", true);

    private static final By MENU_PRESENT = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/menu_exit']", true);

    public MainMenuList openMainMenu() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем главное меню, нажимаем на " +
                "элемент c xpath: '%s'", OPEN_MENU.toString()));
        getSearchContext().findElement(OPEN_MENU).click();
//        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Меню " +
//                "не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
//                until(SearchContextConditions.visibilityOfElementLocated(MENU_PRESENT));
        return mobilePageFactory.createPage(MainMenuList.class);
    }


    public  MainMenuList() {
        super(MobilePlatform.ANDROID);
    }

    public <T extends MobileBasePage> T selectMainMenu(MainMenu mainMenu) {
        By locator = new ByLocator(String.format(ITEM_MENU_XPATH_PATTERN, mainMenu.getRusText()), true);
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выбираем пункт меню '%s', нажимаем на " +
                "элемент c xpath: '%s'", mainMenu.getRusText(), locator.toString()));
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Меню " +
                "не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.visibilityOfElementLocated(EXIT));
        getSearchContext().findElement(locator).click();
        Class cl = null;
        try {
            cl = Class.forName(mainMenu.getPageNameClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T)mobilePageFactory.createPage(cl);
    }

    public DiscoverPage openDiscoverPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("В главном меню открываем страницу поиска, нажимаем на " +
                "Войти, элемент c xpath: '%s'", DISCOVER.toString()));
        getSearchContext().findElement(DISCOVER).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "не загрузилась спустя %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(DiscoverPage.class);
    }

    public ProfilePage openProfilePage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("В главном меню открываем страницу профиля, нажимаем на " +
                "элемент c xpath: '%s'", PROFILE.toString()));
        getSearchContext().findElement(PROFILE).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "не загрузилась спустя %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(ProfilePage.class);
    }

    public CreateEventPage openCreateEventPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("В главном меню открываем страницу поиска, нажимаем на " +
                "Войти, элемент c xpath: '%s'", CREATE_EVENT.toString()));
        getSearchContext().findElement(CREATE_EVENT).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
                "не загрузилась спустя %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(CreateEventPage.class);
    }

    public IntroPage performExit() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("В главном меню нажимаем на " +
                "элемент c xpath: '%s'", EXIT.toString()));
        getSearchContext().findElement(EXIT).click();
        return mobilePageFactory.createPage(IntroPage.class);
    }

}
