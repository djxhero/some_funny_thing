package com.djxhero.funny.android;

import com.djxhero.funny.common.AppniumElementUtil;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/4/19 16:33
 **/
public class QuToutiao {
    private static AndroidDriver driver;

    private static Pattern diigitPatter = Pattern.compile("\\d+");

    public static void setup() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", "Android");
        //指定测试机的ID,通过adb命令`adb devices`获取
        cap.setCapability("deviceName", "127.0.0.1:62001");
        cap.setCapability("platformVersion", "5.1.1");

        //将上面获取到的包名和Activity名设置为值
        String appPackage = "com.jifen.qukan";
        String appActivity = "com.jifen.qkbase.main.MainActivity";
        cap.setCapability("appPackage", appPackage);
        cap.setCapability("appActivity", appActivity);

        cap.setCapability("dontStopAppOnReset", true);

        cap.setCapability("skipLogcatCapture", true);


        //不停止应用，不清理应用数据，不卸载应用包。
        cap.setCapability("noReset", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

//        Activity activityName = new Activity(appPackage, appActivity);
//        activityName.setStopApp(false);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        System.out.println("start ...");

        try {
            int sleep = 30;
            if (args.length != 0) {
                sleep = Integer.parseInt(args[0]);
            }
            setup();
            operate(sleep);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void operate(int waitSeconds) {
        if (AppniumElementUtil.isElementPresent(driver, "com.jifen.qukan:id/a2p", waitSeconds)) {
            System.out.println("关闭红包广告提示");
            // 关闭红包广告提示
            AppniumElementUtil.click(driver, "com.jifen.qukan:id/a2p");
        }

        // 我的
        AppniumElementUtil.click(driver, "com.jifen.qukan:id/k4");

        if (AppniumElementUtil.isElementPresent(driver, "com.jifen.qukan:id/af2", waitSeconds)) {
            login(driver);
        } else {
            System.out.println("已经是登陆状态");
        }

        // 点击首页
        AppniumElementUtil.click(driver, "com.jifen.qukan:id/jy");

        // 领取
        AppniumElementUtil.click(driver, "com.jifen.qukan:id/vr");

        //小视频
        watchVideo(driver);

    }

    public static int getCurrentHour() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.HOUR_OF_DAY);
    }

    public static void watchVideo(AndroidDriver driver) {
        System.out.println("刷小视频");
        WebElement videoBtn = driver.findElement(By.id("com.jifen.qukan:id/k0"));
        videoBtn.click();
        do {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int currentHour = getCurrentHour();
            if (currentHour > 0 && currentHour < 7) {
                //0-7点不刷新
            }

            int width = driver.manage().window().getSize().width;
            int height = driver.manage().window().getSize().height;

            // 上拉刷新
            TouchAction action = new TouchAction(driver);

            PointOption startPoint = PointOption.point(width / 2, height * 3 / 4);
            PointOption endPoint = PointOption.point(width / 2, height / 4);
            action.longPress(startPoint).moveTo(endPoint).release().perform();
        } while (true);
    }

    public static void login(AndroidDriver driver) {
        System.out.println("尝试登陆");
        // 输入手机号
        WebElement mobile = driver.findElement(By.id("com.jifen.qukan:id/af2"));
        mobile.sendKeys("18620728470");

        // 获取短信验证码
        WebElement iz = driver.findElement(By.id("com.jifen.qukan:id/iz"));
        iz.click();

        String msgCode = null;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入短信验证码：");
            msgCode = sc.next(diigitPatter);
        } while (msgCode == null || msgCode.length() < 4);

        msgCode = StringUtils.trim(msgCode);
        System.out.println("获取到验证码：" + msgCode);
        // 输入短信验证码
        iz.sendKeys(msgCode);

        System.out.println("登陆成功");
    }
}

