package com.hogwarts.appiumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * 2.3 Assert断言演示
 */
public class AssertTest extends BaseTest{

    /**
     * 自带断言演示
     */
    @Test
    public void assertTest(){
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        assertEquals(a,b);
        assertNotNull(a);
        assertTrue(false);
        assertFalse(true);
        assertNull(b);
        assertSame(a,b);
        assertNotSame(a,b);
        assertArrayEquals(new int[]{7,8,9},new int[]{1,2,3});
    }

    /**
     * Hamcrest 断言演示
     */
    @Test
    public void  priceAssertTest() {

        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();

        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");

        driver.findElement(By.xpath("//*[@text='BABA']")).click();

        driver.findElement(By.xpath("//*[@resource-id='com.xueqiu.android:id/title_text'][@text='股票']")).click();

        String realPrice = driver.findElement(By.xpath("//*[@text=09988]/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText();

        assertThat("股票价格对比", Double.parseDouble(realPrice), greaterThanOrEqualTo(200d)); //价格大于等于200d

    }



}
