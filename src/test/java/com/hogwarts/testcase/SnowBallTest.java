package com.hogwarts.testcase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.discovery.UriSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class SnowBallTest extends BaseTest{

    /**
     * 1.4-app 控件交互
     */
    @Test
    public void snowBallTest(){

        WebElement home_search =  driver.findElement(By.id("com.xueqiu.android:id/home_search")); //定位首页输入康
        if(home_search.getAttribute("enabled").equals("true")){ //判断搜索框是否可用
            System.out.println(home_search.getLocation());
            System.out.println(home_search.getSize());
            home_search.click();

            WebElement search_input_text = (WebElement) driver.findElements(By.id("com.xueqiu.android:id/search_input_text"));

            if(search_input_text.getAttribute("displayed").equals("true")){
                search_input_text.sendKeys("alibaba");
                System.out.println("搜索成功");
            }else {
                System.out.println("搜索失败");
            }
        }
    }

    /**
     * 1.5-app触屏操作自动化
     */
    @Test
    public void swipeTest(){

        try {
            int width = driver.manage().window().getSize().getWidth();
            int height = driver.manage().window().getSize().getHeight();

            Thread.sleep(10000);

            TouchAction touchAction =new TouchAction(driver);
            touchAction = touchAction.press(PointOption.point((int)(width*0.5), (int)(height*0.8))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
                    .moveTo(PointOption.point((int)(width*0.5), (int)(height*0.2))).release().perform();

        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1.6 高级定位技巧-xpath定位
     * //*[@text=09988]/../../..//*[@resource-id='com.xueqiu.android:id/current_price']
     */
    @Test
    public void  priceTest(){

        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");
        driver.findElement(By.xpath("//*[@text='BABA']")).click();
        System.out.println(driver.findElement(By.xpath("//*[@text=09988]/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText());
    }

    /**
     * 1.6 高级定位技巧--uiautomator定位
     * resourceId("com.xueqiu.android:id/tab_name").text("交易")
     *
     * resourceId("com.xueqiu.android:id/scroll_view").childSelector(text("热门"))   -- 父找子
     */
    @Test
    public void uiautomatorSelectorTest(){
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;

        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/tab_name\").text(\"交易\")"); //打开雪球，点击交易
    }

    /**
     * 1.6 高级定位技巧--滚动查找元素
     */
    @Test
    public void scrollTest() throws  Exception{
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;

        Thread.sleep(1000); //等待页面加载10s

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView( new UiSelector().text(\"查找的文本\").instance(0))\n").click();
        //new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView( new UiSelector().text("查找的文本").instance(0));

    }
}
