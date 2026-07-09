package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Size;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {
	private static final String SEARCH_TERM = "Printed summer dress";
	private SearchResultPage searchResultPage;

	@BeforeMethod(description="User logs in to the app and search for product")
	public void setup() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("penaf64811@luxudata.com", "password")
				.searchForAProduct(SEARCH_TERM);
	}
	
	@Test(description="Verify if the logged in user is able to buy a dress",groups= {"smoke","sanity","e2e"})
	public void checkoutTest() {
		String result =searchResultPage.clickOntheProductAtIndex(0).addProductToCart().proceedToCheckout()
		.goToConfirmAddressPage().goToShippmentPage().goToPaymentPage().makePaymentByWire();
		//System.out.println(result);
		Assert.assertTrue(result.contains("complete"));
		
		
	}
}
