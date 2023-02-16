package org.examplefirstProjectUsingAppium;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.ios.IOSDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class TesteLoginIOS {

    private static ScreenLogin ScreenLogin;

    private static AppiumDriver<RemoteWebElement> driver;

    @BeforeClass
    public static void caps ()throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app",new File("apps/LoginExample.app"));
        capabilities.setCapability("devoiceName","iPhone 13");
        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("platformVersion","15.0");
        capabilities.setCapability("automationName","XCUITest");

        driver= new IOSDriver<RemoteWebElement>(new URL("http://localhost:4723/wd/hub"),capabilities);

        ScreenLogin = new ScreenLogin(driver);
    }

    @Test
    public void  testeLogin (){
        ScreenLogin.logar();
    }


}
