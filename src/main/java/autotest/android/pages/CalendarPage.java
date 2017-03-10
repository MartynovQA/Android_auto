package autotest.android.pages;

import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 23.01.2017.
 */
public class CalendarPage extends MobileBasePage {

    private static final By CURRENT_DATE = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/date_picker_year']", true);
    private static final By DATE_PICKER_MONTH = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/date_picker_month']", true);
    private static final By DATE_PICKER_DAY = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/date_picker_day']", true);
    private static final By DATE_PICKER_YEAR = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/date_picker_year']", true);
    private static final By CALENDAR_FIELD = new ByLocator("//android.widget.ViewAnimator[@resource-id=" +
            "'com.mgrmobi.intouch:id/animator']", true);

    private static final By CANCEL = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/cancel']", true);
    private static final By OK = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/ok']", true);

    public CalendarPage() {
        super(MobilePlatform.ANDROID);
    }


//    public CalendarPage selectDateDeparture(DateCalendar dataFrom, DateCalendar currentSelectedDate) {
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выбираем дату вылета туда - '%s',нажимаем на " +
//                "элемент c xpath: '%s'", dataFrom, AVAILABLE_DATE.toString()));
//        List<WebElement> dates = getSearchContext().findElements(AVAILABLE_DATE);
//        int countDays = (int) ChronoUnit.DAYS.between(dataFrom.getLocalDate(), currentSelectedDate.getLocalDate());
//        dates.get(Math.abs(countDays)).click();
//        return this;
//    }

    public SearchPage clickCancel() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Нажимаем кнопку 'Готово', " +
                "элемент c xpath: '%s'", OK.toString()));
        getSearchContext().findElement(OK).click();
        return mobilePageFactory.createPage(SearchPage.class);
    }

    public SearchPage clickDone() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Нажимаем кнопку 'Готово', " +
                "элемент c xpath: '%s'", OK.toString()));
        getSearchContext().findElement(OK).click();
        return mobilePageFactory.createPage(SearchPage.class);
    }

}
