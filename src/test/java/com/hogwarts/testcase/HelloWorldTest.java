package com.hogwarts.testcase;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HelloWorldTest {
    public static AndroidDriver<WebElement> driver;

    private WebDriverWait wait;

    @BeforeAll
    public static void setUp(){

        try {
            DesiredCapabilities caps = new DesiredCapabilities ();

            caps.setCapability("platformName","Android");
            caps.setCapability("udid","emulator-5554");
            caps.setCapability("deviceName","xxxx");
            caps.setCapability("appPackage","com.xueqiu.android");
            caps.setCapability("appActivity","./view.WelcomeActivityAlias");

            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/lub"), caps); //测试android 手机
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //隐式等待 10s
        } catch(MalformedURLException e){
            e.printStackTrace ();
        }
    }

    @Test
    public void fun(){
        wait = new WebDriverWait(driver,10,1);

        wait.until(ExpectedConditions.
                visibilityOfElementLocated(MobileBy.id("com.android.setting:id/title")));
    }

    @Test
    public void helloSnowBallTest(){

        //方法一：使用appium desktop 录制脚本
//        MobileElement el1 = (MobileElement) driver.findElementById("com.xueqiu.android:id/tv_search");
//        el1.click();
//        MobileElement el2 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
//        el2.sendKeys("阿里巴巴");
//        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]");
//        el3.click();


        //方法二
        //定位首页搜素框
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();

        //定位搜索页搜索框
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).click();


    }
    
}
