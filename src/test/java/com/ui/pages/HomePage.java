package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;

public final class HomePage extends BrowserUtility {
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign')]") ;

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName,isHeadless);
		//goToWebsite(PropertiesUtil.readProperty(Env.QA, "URL"));
		goToWebsite(JSONUtility.readJSON(Env.QA));
	}
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(Env.QA));
	}
	public LoginPage goToLoginPage() { // don't return void in pom
		logger.info("Trying to perform click to goto Sign in Page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	public void quit() {
		
	}
	

}
