package autotest.android.business_objects.business_enum;

import autotest.android.pages.page_enum.LangEnum;

/**
 * Created by zaborovsky on 09.01.2017.
 */
public enum Gender implements LangEnum {

    MALE("Male", ""),
    FEMALE("Female","");

    private String rusText;
    private String engText;

    private Gender(String rusText, String engText) {
        this.rusText = rusText;
        this.engText = engText;
    }

    public String getRusText() {
        return rusText;
    }

    public String getEngText() {
        return engText;
    }

    @Override
    public String getRuEnValue() {
        return String.format("%s/%s", rusText, engText);
    }

    @Override
    public Gender[] getValues() {
        return values();
    }

}
