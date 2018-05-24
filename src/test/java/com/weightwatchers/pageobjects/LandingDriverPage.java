package com.weightwatchers.pageobjects;
/**
 * @author  Aditya Shah
 * @version 1.0
 *
 */
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingDriverPage extends DriverBasePage {

	@FindBy(how=How.ID, using = "ela-menu-visitor-desktop-supplementa_find-a-meeting")
	private WebElement findaMeetingIcon;

	
	public LandingDriverPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public LandingDriverPage clickOnFindaMeetingIcon(){
		waitForElement(findaMeetingIcon);
		findaMeetingIcon.click();
        return new LandingDriverPage(driver);
	}
	
	public LandingDriverPage verifyPageTitle(String expected){
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual);
        return new LandingDriverPage(driver);
	}

	public FindAMeetingDriverPage verifyPageTitleContains(String expected){
		String actual = driver.getTitle();
		Assert.assertTrue(actual.contains(expected));
        return new FindAMeetingDriverPage(driver);
	}
	

}
