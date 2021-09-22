package com.hogwarts.testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ToastTest {

    public static AppiumDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setUp(){

        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability("platformName","android");
            caps.setCapability("udid","emulator-5554");
            caps.setCapability("deviceName","xxxx"); //随便填 ，不写会报错
            //caps.setCapability("noReset","true"); //没有弹窗
            //caps.setCapability("automationName","UiAutomator2");
            caps.setCapability("appPackage","com.mumu.launcher");
            caps.setCapability("appActivity","com.mumu.launcher.Launcher");

            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps); //测试android 手机
            driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS); //隐式等待 10s，服务器端等待
        } catch(MalformedURLException e){
            e.printStackTrace ();
        }
    }


    @Test
    public void toastTest(){
        driver.findElement(By.xpath("//*[@text='Make a Popup!']")).click();
        System.out.println(driver.getPageSource());

        driver.findElement(By.xpath("//*[@text='search']")).click();

        System.out.println(driver.findElement(By.xpath("//*[@class='android.widget.Toast']")).getText());
        System.out.println(driver.getPageSource());
    }
}
