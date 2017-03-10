package core.appium.page;

import com.google.common.base.Preconditions;
import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;

import core.appium.driver.AppiumExtDriver;
import core.appium.enums.MobilePlatform;
import core.ios.IosLocator;
import core.logger.ThreadLogger;


/**
 * Created by zaborovsky on 21.12.2016.
 */

public class MobileBasePage {

    public static final int LOAD_PAGE_SECONDS = 120;
    public static final int TIMEOUT = 12;
    protected MobilePageFactory mobilePageFactory = new MobilePageFactory();
    protected Logger logger = ThreadLogger.getThreadLogger();
    private SearchContext searchContext;
    private IosLocator iosParentLocator;


    /**
     * Когда контекстом поиска является сам драйвер
     */

    public MobileBasePage(MobilePlatform platform) {
        this.searchContext = AppiumExtDriver.getDriver(platform);
    }


    public MobileBasePage(MobilePlatform platform, IosLocator iosParentLocator) {
        this.searchContext = AppiumExtDriver.getDriver(platform);
        this.iosParentLocator = iosParentLocator;
    }

    /**
     * Возвращает текущий контекст поиска
     *
     * @return Текущий контекст поиска
     */

    public SearchContext getSearchContext() {
        Preconditions.checkNotNull(searchContext, "Контекст поиска не может быть равен null.");
        return searchContext;
    }

    /**
     * Установка контекста поиска
     * @param searchContext новый контекст поиска
     */
    public void setSearchContext(SearchContext searchContext) {
        Preconditions.checkNotNull(searchContext, "Контекст поиска не может быть равен null.");
        this.searchContext = searchContext;
    }

    protected IosLocator getIosParentLocator() { return iosParentLocator;}

}
