package com.djxhero.funny.windows;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description TODO
 * @Author dujx
 * @Date 2019/4/19 15:25
 **/
public class Demo {
    public static void main(String[] args) throws MalformedURLException {
        // Launch Notepad
        DesiredCapabilities appCapabilities = new DesiredCapabilities();
        appCapabilities.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
        appCapabilities.setCapability("appArguments", "MyTestFile.txt");
        appCapabilities.setCapability("appWorkingDir", "f:\\temp\\");
        WindowsDriver notepad = new WindowsDriver<WindowsElement>(
                new URL("http://127.0.0.1:4723"), appCapabilities);

// Use the session to control the app
        notepad.findElementByClassName("Edit").sendKeys("This is some text");
    }
}
