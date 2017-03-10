package core.appium.driver;

import core.appium.enums.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
/**
 * Created by zaborovsky on 21.12.2016.
 */
public class MobileCapabilitiesFactory {

    public static DesiredCapabilities getCapabilities(MobilePlatform platform) {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "mobileApp");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        File app;

        switch (platform) {
            case ANDROID:
                app = new File("C:\\AutoTests\\Android\\ShowApp\\src\\mobileAPP\\ShowApp.apk");
                capabilities.setCapability("deviceName", "ce859548");
//                xiaomi redminote3 & sgs4
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platform", "ANDROID");
                capabilities.setCapability("platformVersion","5.1.1");

                capabilities.setCapability("app", app.getAbsolutePath());

                capabilities.setCapability("app-package","com.magora.showapp.android");
                capabilities.setCapability("app-activity", ".activities.MainActivity");
                capabilities.setCapability("newCommandTimeout", 1200);
                capabilities.setCapability("unicodeKeboard", true);
                capabilities.setCapability("noReset", true);
                capabilities.setCapability("fullReset", false);
//                capabilities.setCapability();
                return capabilities;

            case IOS:
                capabilities.setCapability("deviceName", "2e79a7e97d43");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platform", "ANDROID");
                capabilities.setCapability("platformVersion","6.0.1");
                capabilities.setCapability("newCommandTimeout", 1200);
                return capabilities;

//iOS
            default:
                throw new UnsupportedOperationException("Not implemented yet");
        }
    }


}
