package org.examplefirstProjectUsingAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;



// Class still in progress ...

public class TesteUniversal {
    private static ScreenLogin ScreenLogin;

    public static String local = "";
    public static String plataforma = "";


    private static AppiumDriver<RemoteWebElement> driver;

    @BeforeClass
    public static void caps() throws MalformedURLException {


        local = System.getProperty("local").toLowerCase();
        plataforma = System.getProperty("plataforma").toLowerCase();


        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (local.equals("local") && plataforma.equals("android")) {
            capabilities.setCapability("app", new File("apps/app-debug.apk"));
            capabilities.setCapability("devoiceName", "emulator-5554");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("unicodeKeyboard", true);

            driver = new AndroidDriver<RemoteWebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
        }if (local.equals("local")&& plataforma.equals(("iOS"))){
            capabilities.setCapability("app",new File("apps/LoginExample.app"));
            capabilities.setCapability("devoiceName","iPhone 13");
            capabilities.setCapability("platformName","iOS");
            capabilities.setCapability("platformVersion","15.0");
            capabilities.setCapability("automationName","XCUITest");
            driver = new AndroidDriver<RemoteWebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
        }
        ScreenLogin = new ScreenLogin(driver);
    }

    @Test
    public void testeLogin() {
        ScreenLogin.logar();
    }

}