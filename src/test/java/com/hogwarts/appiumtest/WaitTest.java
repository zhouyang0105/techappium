package com.hogwarts.appiumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTest extends BaseTest{

    /**
     * 2.1 显示等待
     */
    @Test
    public void fun(){
        wait = new WebDriverWait(driver,10,1000);

        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");

        WebElement ali = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='BABA']")));

        System.out.println(ali.getAttribute("enabled"));
        ali.click();
    }
}
