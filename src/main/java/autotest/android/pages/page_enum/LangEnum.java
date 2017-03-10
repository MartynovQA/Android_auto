package autotest.android.pages.page_enum;

/**
 * Created by zaborovsky on 27.12.2016.
 */
public interface LangEnum {
    public String getRuEnValue();
    public String getRusText();
    default<T extends LangEnum> T[] getValues() {
        return null;
    }
}
