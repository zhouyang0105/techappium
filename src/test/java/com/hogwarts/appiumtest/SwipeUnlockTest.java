package com.hogwarts.appiumtest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * 1.5触屏手势密码锁
 */
public class SwipeUnlockTest {

    private static AndroidDriver driver;

    @BeforeAll
    public static void setUp(){

        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability("platformName","android");
            caps.setCapability("udid","emulator-5554");
            caps.setCapability("deviceName","xxxx"); //随便填 ，不写会报错
            //caps.setCapability("noReset","true"); //没有弹窗
            caps.setCapability("automationName","UiAutomator2");
            caps.setCapability("appPackage","com.xueqiu.android");    //修改成手势密码锁的
            caps.setCapability("appActivity",".view.WelcomeActivityAlias");  //修改成手势密码锁的

            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps); //测试android 手机
            driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS); //隐式等待 10s，服务器端等待
        } catch(MalformedURLException e){
            e.printStackTrace ();
        }
    }

    @Test
    public void swipeUnlockTest(){

        try {
            TouchAction touchAction = new TouchAction(driver);

            Duration duration = Duration.ofMillis(5000); //3s

            Thread.sleep(3000);// 防止页面还没有渲染出来，就进行滑动操作



        } catch(InterruptedException e) {
            e.printStackTrace();
        }

    }
}
