package autotest.android.business_objects;

import autotest.android.business_objects.business_enum.DateCalendarFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by zaborovsky on 06.01.2017.
 */
public class DateCalendar {

    private DateTimeFormatter dateTimeFormatter;
    private Locale locale;
    private LocalDate localDate;

    private String day = "";
    private String month = "";
    private String year = "";
    private String dayOfWeek = "";

    public DateCalendar() {
        this.localDate = LocalDate.now();
        this.locale = new Locale("ru");
    }

    public DateCalendar(LocalDate localDate) {
        this.localDate = localDate;
        this.locale = new Locale("ru");
    }

    public DateCalendar(LocalDate localDate, Locale locale) {
        this.localDate = localDate;
        this.locale = locale;
    }

    public DateCalendar getBlockFormat() {
        dateTimeFormatter = DateTimeFormatter.ofPattern(DateCalendarFormat.FIELD.getFormat(), locale);
        String dates[] = localDate.format(dateTimeFormatter).split(" ");
        this.day = dates[0];
        this.month = dates[1];
        this.dayOfWeek = dates[2];
        this.year = dates[3];
        return this;
    }

    public DateCalendar getBirthdayFormat() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE." + DateCalendarFormat.BIRTHDAY.getFormat(), locale);
        String dates[] = localDate.format(dateTimeFormatter).split("\\.");
        this.dayOfWeek = dates[0];
        this.day = dates[1];
        this.month = dates[2];
        this.year = dates[3];
        return this;
    }

    public DateCalendar getFieldFormat() {
        dateTimeFormatter = DateTimeFormatter.ofPattern(DateCalendarFormat.FIELD.getFormat(), locale);
        String dates[] = localDate.format(dateTimeFormatter).split(" ");
        this.day = dates[0];
        this.month = dates[1];
        this.dayOfWeek = dates[2];
        this.year = dates[3];
        return this;
    }

//    TODO: доделать блоки по датам
}


