package org.veera;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestRegistration {

    public static AndroidDriver driver;

    public static void main(String[] args) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

//        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("udid", "d30771bb");
//        capabilities.setCapability("deviceName", "Veera");
        capabilities.setCapability("appPackage", "io.selendroid.testapp");
        capabilities.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("noReset", "true");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Veera");


        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/"), capabilities);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement registrationButton = driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration"));
        registrationButton.click();
        WebElement userName = driver.findElement(By.id("io.selendroid.testapp:id/inputUsername"));
        userName.sendKeys("Veera");
        WebElement email = driver.findElement(By.id("io.selendroid.testapp:id/inputEmail"));
        email.sendKeys("Veera@gmail");
        WebElement password = driver.findElement(By.id("io.selendroid.testapp:id/inputPassword"));
        password.sendKeys("********");
        WebElement inputName = driver.findElement(By.id("io.selendroid.testapp:id/inputName"));
        inputName.clear();
        inputName.sendKeys("Veeraguru");
//        driver.navigate().back();
        driver.hideKeyboard();
        WebElement programmingLanguage = driver.findElement(By.id("android:id/text1"));
        programmingLanguage.click();
        WebElement java = driver.findElement(By.xpath("//*[@text='Java']"));
        java.click();
        WebElement checkBox = driver.findElement(By.id("io.selendroid.testapp:id/input_adds"));
        checkBox.click();
        WebElement registrationUser = driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser"));
        registrationUser.click();

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        WebElement toastBtn = driver.findElement(By.id("io.selendroid.testapp:id/showToastButton"));
        toastBtn.click();
        WebElement toastMsg = driver.findElement(By.xpath("//android.widget.Toast[@text=\"Hello selendroid toast!\"]"));
        System.out.println(toastMsg.getText());
        driver.navigate().back();

    }
}
