package com.weightwatchers.pageobjects;
/**
 * @author  Aditya Shah
 * @version 1.0
 *
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class DriverBasePage {

	protected WebDriver driver;
	private LandingDriverPage landingPage;

	public DriverBasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void delayFor(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException explicit) {

		}
	}

	public WebElement waitForElement(final WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return element;
			}
		});
		return foo;
	}


	public LandingDriverPage LandPage(){

		if(landingPage == null){
			landingPage = new LandingDriverPage(driver);
		}
		return landingPage;
	}
}
