package autotest.android.business_objects;



import autotest.android.business_objects.business_enum.Gender;

import java.time.LocalDate;

/**
 * Created by zaborovsky on 05.01.2017.
 */

public class User {

    private String nickName;
    private String firstlastName;
    private DateCalendar birthday;
    private Gender gender;

    public User(String nickName, String firstlastName, DateCalendar birthday) {
        this.nickName = nickName;
        this.firstlastName = firstlastName;
        this.birthday = birthday;
        this.gender = Gender.MALE;
    }

    public User(String nickName, String firstlastName) {
        this.nickName = nickName;
        this.firstlastName = firstlastName;
        this.birthday = new DateCalendar(LocalDate.now().minusYears(20)).getFieldFormat();
        this.gender = Gender.MALE;
    }

    public String getnickName() {
        return nickName;
    }

    public void setnickName(String nickName) {
        this.nickName = nickName;
    }

    public String getfirstlastName() {
        return firstlastName;
    }

    public void setfirstlastName(String firstlastName) {
        this.firstlastName = firstlastName;
    }

    public DateCalendar getBirthday() {
        return birthday;
    }

    public void setBirthday(DateCalendar birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User User = (User) o;
        if (!birthday.getBirthdayFormat().equals(User.birthday.getBirthdayFormat())) return false;
        if (!nickName.equals(User.nickName)) return false;
        if (!firstlastName.equals(User.firstlastName)) return false;

        return true;
    }

    @Override
    public String toString() {
        return nickName + " " + firstlastName + " " + birthday;
    }

}
