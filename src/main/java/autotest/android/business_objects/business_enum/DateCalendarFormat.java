package autotest.android.business_objects.business_enum;

/**
 * Created by zaborovsky on 06.01.2017.
 */
public enum DateCalendarFormat {
    BIRTHDAY("dd MMM yyyy"), //birthday 22 dec 1999
    FIELD("dd MMM yyyy"), //get rekt 22 dec 1999
    EVENT_FILTER("EEE,dd MMMM, yyyy"); //event cp, 4 january, 2017

    private String format;

    private DateCalendarFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }


}
