package com.hogwarts.page;

import com.hogwarts.appiumtest.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * 2.4 参数化用例
 */
public class SearchPageTest extends BaseTest {


    @ParameterizedTest
    @MethodSource("byNameGetPrice")
    @Test
    public void searchByName(String name,String code,double price){
        //定位雪球首页搜索页
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        //定位搜索框
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(name);

        driver.findElement(By.xpath("//*[@text='"+code+"']")).click();

        //获取股票价格
        String realPrice = driver.findElement(By.xpath("//*[@text=09988]/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText();
        //assertThat("股票实际价格和期望价格比较", Double.parseDouble(realPrice) , greaterThanOrEqualTo(price));

        //优化：每次都需要点击取消，重新回到搜索页
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();

        assertThat("股票实际价格和期望价格比较", Double.parseDouble(realPrice) , lessThanOrEqualTo(price));
    }

    private static Stream<Arguments> byNameGetPrice(){
        return Stream.of( Arguments.of("alibaba","BABA",200d),
                Arguments.of("wangyi","NTES",250d),
                Arguments.of("baidu","BIDU",180d),
                Arguments.of("google","GOOGL",300d)
        );
    }
}
