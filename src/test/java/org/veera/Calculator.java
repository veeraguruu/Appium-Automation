package org.veera;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {

    public static AndroidDriver driver;

    public static void main(String[] args) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

//        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("udid", "d30771bb");
//        capabilities.setCapability("deviceName", "Veera");
        capabilities.setCapability("appPackage", "com.coloros.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("noReset", "true");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Veera");


        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/"), capabilities);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        }

        WebElement btn1 = driver.findElement(By.id("com.coloros.calculator:id/digit_1"));
        WebElement btn2 = driver.findElement(By.id("com.coloros.calculator:id/digit_2"));
        WebElement add = driver.findElement(By.id("com.coloros.calculator:id/op_add"));
        WebElement equals = driver.findElement(By.id("com.coloros.calculator:id/eq"));

        btn1.click();
        add.click();
        btn2.click();
        equals.click();
    }
}
