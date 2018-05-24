package com.weightwatchers.pageobjects;
/**
 * @author  Aditya Shah
 * @version 1.0
 *
 */
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class WeightWatcherComboPage {

	private WebDriver driver;
	
	private LandingDriverPage landingPage;
	private FindAMeetingDriverPage findAMeetingPage;
	private JoinWeightWatcherDriverPage joinWeightWatcherPage;
	
	public WeightWatcherComboPage(WebDriver driver){
		this.driver=driver;
	}
	
	
	public LandingDriverPage homePage(){
		if(landingPage == null){
			landingPage = new LandingDriverPage(driver);
		}
		return landingPage;
	}
	
	public FindAMeetingDriverPage findAMeetingPage(){
		if(findAMeetingPage == null){
			findAMeetingPage = new FindAMeetingDriverPage(driver);
		}
		return findAMeetingPage;
	}

	public JoinWeightWatcherDriverPage joinWWPage(){
		if(joinWeightWatcherPage == null){
			joinWeightWatcherPage = new JoinWeightWatcherDriverPage(driver);
		}
		return joinWeightWatcherPage;
	}

	public void verifyPageTitle(String expected){
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual);
	}
	
}
