package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPojo;
import com.utility.FakeAddressUtility;

@Listeners(com.ui.listeners.TestListner.class)
public class AddNewFirstAddressTest extends TestBase {
	
	private MyAccountPage myAccountPage;
	
	private AddressPojo address;
	
	
	@BeforeMethod(description="Valid first time user logs into the application")
	public void setup() {
		
		myAccountPage = homePage.goToLoginPage().doLoginWith("penaf64811@luxudata.com", "password");
		address = FakeAddressUtility.getFakeAddress();
	}
	
	@Test(description="Verify new address is added correctly ")
	public void addNewAddress() {
		String newAddress =myAccountPage.goToAddAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress,address.getAddressAlias().toUpperCase());
		
	}
	
}
