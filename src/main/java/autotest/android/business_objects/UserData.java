package autotest.android.business_objects;

/**
 * Created by zaborovsky on 10.01.2017.
 */
public class UserData {
    private String username;
    private String email;
    private String password;
    private User user;


//    public UserData() {
//        this.email = PropertiesLoader.getProperty("login4");
//        this.password = PropertiesLoader.getProperty("password4");
//    }

    public UserData(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserData(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

}
