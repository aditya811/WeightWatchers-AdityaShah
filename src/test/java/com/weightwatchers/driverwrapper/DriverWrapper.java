package com.weightwatchers.driverwrapper;
/**
 * @author  Aditya Shah
 * @version 1.0
 *
 */
import java.util.concurrent.TimeUnit;

import com.weightwatchers.pageobjects.DriverBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class DriverWrapper {

    protected WebDriver driver;
    private DriverBasePage driverBasePage;

    @BeforeClass
    public void beforeclass() {
        /*
        TODO driver should be thread safe. Need to introduce ThreadLocal to make driver thread safe
         */
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to("https://www.weightwatchers.com/us/");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforMethod(){

    }

    @AfterMethod
    public void afterMethod(){

    }

    @AfterClass
    public void afterclass() {
        driver.close();
        driver.quit();
    }

    public DriverBasePage pageBase(){

        if(driverBasePage == null){
            driverBasePage = new DriverBasePage(driver);
        }
        return driverBasePage;
    }
}