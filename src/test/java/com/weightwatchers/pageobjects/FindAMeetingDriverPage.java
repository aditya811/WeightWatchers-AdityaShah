package com.weightwatchers.pageobjects;
/**
 * @author  Aditya Shah
 * @version 1.0
 *
 */
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FindAMeetingDriverPage extends DriverBasePage {

    @FindBy(how= How.ID, using = "meetingSearch")
    private WebElement searchBox;

    @FindBy(how = How.ID, using = "ela-mfsr:mf-find-btn")
    private WebElement search;

    @FindBy(how = How.XPATH, using = "//*[@id='content']//ui-view/ui-view//div[@class='meeting-locations-list']")
    private WebElement locations;
	
	public FindAMeetingDriverPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

    public List<WebElement> locationLists() {
        return locations.findElements(By.className("meeting-locations-list__item"));
    }

	public FindAMeetingDriverPage enterZipInSearchBox(String zip){
		searchBox.sendKeys(zip);
		searchBox.sendKeys(Keys.ENTER);
        return new FindAMeetingDriverPage(driver);
	}

    public JoinWeightWatcherDriverPage printTitleAndDistanceofFirstResult(){
        WebElement firstResult = locationLists().get(0);
        WebElement locationName = firstResult.findElement(By.xpath("//*[@class='location__top']"));
        String [] name = locationName.getText().split("\\r?\\n");
        System.out.println(name[0]);

        WebElement distance = firstResult.findElement(By.xpath("//*[@class='location__distance']"));
        System.out.println(distance.getText());
        return new JoinWeightWatcherDriverPage(driver);
    }
}
