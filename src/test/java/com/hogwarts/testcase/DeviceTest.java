package com.hogwarts.testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.aspectj.util.FileUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * 2.7 设备交互API
 */
public class DeviceTest {

    //public static AppiumDriver driver;

    public static AndroidDriver driver;

    @BeforeAll
    public static void initData() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "android");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("deviceName", "xxxx");

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps); //测试android 手机
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS); //隐式等待 10s，服务器端等待
    }

    @Test
    public void callTest() throws  Exception{
        driver.makeGsmCall("5551234567", GsmCallActions.CALL); //打电话
        driver.sendSMS("555-123-4567", "Hey lol");//发短信

        //网络设置
        driver.toggleAirplaneMode(); //开启飞行模式
        Thread.sleep(5000);
        driver.toggleData();//切换数据流量模式
        Thread.sleep(5000);
        driver.toggleWifi(); //切换wifi模式
        Thread.sleep(5000);


        driver.rotate(ScreenOrientation.LANDSCAPE); //切换成竖屏
        Thread.sleep(5000);
        driver.rotate(ScreenOrientation.PORTRAIT);  //切换成横屏


        //截屏
        Thread.sleep(5000);
        File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
        File file= new File( System.getProperty("user.dir")+"/src/main/resources/demo.png");
        FileUtil.copyFile(screenshotAs,file);

        //按键
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }
}
