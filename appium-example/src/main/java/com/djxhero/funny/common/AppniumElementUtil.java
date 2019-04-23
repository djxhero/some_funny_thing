package com.djxhero.funny.common;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/4/22 19:18
 **/
public class AppniumElementUtil {

    public static boolean isElementPresent(AppiumDriver<WebElement> driver, String id, Integer timeout) {
        if (timeout == null) {
            timeout = 5;
        }
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void click(AppiumDriver<WebElement> driver, String id) {
        try {
            WebElement videoBtn = driver.findElement(By.id(id));
            videoBtn.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
