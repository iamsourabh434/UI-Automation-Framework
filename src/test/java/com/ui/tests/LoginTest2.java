package com.ui.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;

public class LoginTest2 {

	public static void main(String[] args) {

		WebDriver wd = new ChromeDriver();
		HomePage homePage = new HomePage(wd);
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.doLoginWith("penaf64811@luxudata.com", "password");
	}

}
