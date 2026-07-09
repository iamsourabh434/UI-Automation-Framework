package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listeners.TestListner.class)

public class SearchProductTest extends TestBase {
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM ="printed summer dress";
	
	@BeforeMethod(description="Valid user logs into the application")
	public void setup() {
		myAccountPage =homePage.goToLoginPage().doLoginWith("penaf64811@luxudata.com", "password");
	}
	
	@Test(description = "Verify if the user is able to search for a product and correct product search result show", groups = {
			"smoke", "End To End" })
	public void verifyProducSearchTest() {
		boolean actualResult=myAccountPage.searchForAProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}

}
