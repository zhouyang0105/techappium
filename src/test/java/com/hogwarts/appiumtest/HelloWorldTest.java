package com.hogwarts.appiumtest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

/**
 * 移动端app自动化: 元素定位方法和隐式等待
 */
public class HelloWorldTest {
    public static AppiumDriver driver;

    private WebDriverWait wait;

    @BeforeAll
    public static void setUp(){

        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability("platformName","android");
            caps.setCapability("udid","emulator-5554");
            caps.setCapability("deviceName","xxxx"); //随便填 ，不写会报错
            //caps.setCapability("noReset","true"); //没有弹窗
            caps.setCapability("automationName","UiAutomator2");
            caps.setCapability("appPackage","com.xueqiu.android");
            caps.setCapability("appActivity",".view.WelcomeActivityAlias");

           /* caps.setCapability("platformName","android");
            caps.setCapability("deviceName","emulator-5554");
            caps.setCapability("automationName","UiAutomator2");
            caps.setCapability("appPackage","com.xueqiu.android");
            caps.setCapability("appActivity",".view.WelcomeActivityAlias");*/

            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps); //测试android 手机
            driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS); //隐式等待 10s，服务器端等待
        } catch(MalformedURLException e){
            e.printStackTrace ();
        }
    }

    @Test
    public void fun() throws ParseException {
        wait = new WebDriverWait(driver,10,1); //显示等待在客户端等待

        wait.until(ExpectedConditions.
                visibilityOfElementLocated(MobileBy.id("com.android.settings:id/title")));
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
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");

       // driver.findElement(By.xpath("//*[@text='BABA']")).click();
      //  System.out.println(driver.findElement(By.id("current_price")).getText());
    }


    
}
