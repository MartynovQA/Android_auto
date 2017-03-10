package autotest.android.pages.page_enum;

/**
 * Created by zaborovsky on 02.02.2017.
 */
public enum RegistrationList implements LangEnum {

    Photo("Photo", "Photo","Registration"),
    Nickname("Showapp", "Showapp","Registration"),
    Fio("Поиск","Search","SearchPage"),
    Aboutme("Доступные","","Registration"),
    GenderMale("Активности","","Registration"),
    GenderFemale("Активности","","Registration"),
    Birthday("Создать","","Registration"),
    Interes("Профиль","Profile","ProfilePage"),
    City("Настройки", "Settings","Registration"),
    Link("Выход","Exit","Registration"),
    Ready("Готово","","ShowappPage");

    private RegistrationList(String rusName, String engName, String pageName){
        this.rusName = rusName;
        this.engName = engName;
        this.pageName = pageName;
    }

    private String rusName;
    private String engName;
    private String pageName;

    @Override
    public String getRusText(){
        return this.rusName;
    }

    @Override
    public String getRuEnValue(){
        return this.engName;
    }

    public String getPageNameClass() {
        return "autotest.android.pages." + pageName;
    }


}
