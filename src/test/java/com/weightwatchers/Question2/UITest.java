package com.weightwatchers.Question2;
/**
 * @author  Aditya Shah
 * @version 1.0
 *
 */
import com.weightwatchers.driverwrapper.DriverWrapper;
import org.testng.annotations.Test;

public class UITest extends DriverWrapper {

    @Test
    public void weightWatcherTest(){
        pageBase().LandPage().verifyPageTitle("Weight Loss Program, Recipes & Help | Weight Watchers")
                .clickOnFindaMeetingIcon()
                .verifyPageTitleContains("Get Schedules & Times Near You")
                .enterZipInSearchBox("10011")
                .printTitleAndDistanceofFirstResult()
                .clickOnFirstResultAndVerifyName()
                .printTodaysHours();
    }
}