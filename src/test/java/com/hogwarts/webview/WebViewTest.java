package com.hogwarts.webview;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebViewTest {
    public static AppiumDriver driver;

    private WebDriverWait wait;

    @BeforeAll
    public static void setUp(){

        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability("platformName","android");
            caps.setCapability("udid","emulator-5554");
            caps.setCapability("deviceName","xxxx"); //随便填 ，不写会报错
            caps.setCapability("automationName","UiAutomator2");
            caps.setCapability("appPackage","com.xueqiu.android");
            caps.setCapability("appActivity",".view.WelcomeActivityAlias");
            caps.setCapability("noReset","true"); //没有弹窗

            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps); //测试android 手机
            driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS); //隐式等待 10s，服务器端等待
        } catch(MalformedURLException e){
            e.printStackTrace ();
        }
    }

    /*@Test
    public void webView() throws Exception{
        driver.findElement(By.xpath("//*[@text='交易']")).click();

        for(int i = 0; i < 5; i++) {
            driver.getContextHandles().forEach(context->System.out.println(context.toString()));
            Thread.sleep(3000);
        }
        driver.findElement(By.xpath("//*[@text='基金开会']")).click();
    }*/

}
