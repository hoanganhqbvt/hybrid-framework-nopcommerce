package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.CheckoutPageObject;
import pageObjects.nopCommerce.user.ProductDetailPageObject;
import pageObjects.nopCommerce.user.ShoppingCarPageObject;
import pageObjects.nopCommerce.user.UserComputerPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserOrderPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;



public class Order extends BaseTest{
		 WebDriver driver;
		 private UserHomePageObject userHomePage;
		 private UserRegisterPageObject registerPage;
		 private UserComputerPageObject userComputerPage;
		 private ProductDetailPageObject productDetailPage;
		 private ShoppingCarPageObject shoppingCartPage;
		 private CheckoutPageObject checkoutPage;
		 private UserOrderPageObject orderPage;
		 
		 String invalidEmail = "abc@123@abc";
		 int fakeNumber = generateFakeNumber();
		 String validEmail = "automail" + fakeNumber + "@gmail.com", firstName = "Automation", lastName = "Testing", gender = "Male",
				password = "Abc@123456", confirmPassword = password, day = "20", month = "October", year = "1990";
		 String productName1 = "Build your own computer";
		 String ramSize = "8GB [+$60.00]", hddSize = "400 GB [+$100.00]", processorType = "2.2 GHz Intel Pentium Dual-Core E2200",
				os = "Vista Premium [+$60.00]", software = "Microsoft Office [+$50.00]", orderNumber = "1";
		 String price, updateProductPrice, productTotalPriceBefore, productTotalPriceAfter;
		 String editRAMSize = "4GB [+$20.00]", editHDDSize = "320 GB", editProcessorType = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]",
					editOS = "Vista Home [+$50.00]", editSoftware = "Acrobat Reader [+$10.00]", editOrderNumber = "2";
		 String updateProduct = "Lenovo IdeaCentre 600 All-in-One PC";
		 String updateQty = "5", defaultQty = "1";
		 String country = "United States", stateProvince = "California", city = "Oakland", address1 = "Street 1", address2 = "Street 2", phoneNumber = "0917382666",
				 zipPostal = "94600", paymentMethod = "Check / Money Order", shippingMethod = "Ground ($0.00)", giftWrapping = "No";
		
		 @Parameters({"browser", "userURL"})
			@BeforeClass
			public void beforeClass(String browserName, String userURL) {
				log.info("Pre-condition - Step 01: Open browser");
				driver = getBrowserDriver(browserName, userURL);
				userHomePage = PageGeneratorManager.getUserHomePage(driver);
				
				log.info("Pre-condition - Step 02: Click to Register link");
				userHomePage.clickToPageLinkByName("Register");
				registerPage = PageGeneratorManager.getUserRegisterPage(driver);
				
				log.info("Pre-condition - Step 03: Select gender radio button that is Male");
				registerPage.selectGenderRadioButton("Male", gender);
				
				log.info("Pre-condition - Step 04: Input to Firstname textbox: " + firstName);
				registerPage.inputToDynamicTextboxByID("FirstName", firstName);
				
				log.info("Pre-condition - Step 05: Input to Lastname textbox: " + lastName);
				registerPage.inputToDynamicTextboxByID("LastName", lastName);
				
				log.info("Pre-condition - Step 06: Select a day of birth in Day dropdown list that has value: " + day);
				registerPage.selectDOBInDropdownListByName("DateOfBirthDay", day);
				
				log.info("Pre-condition - Step 07: Select a month of birth in Month dropdown list that has value: " + month);
				registerPage.selectDOBInDropdownListByName("DateOfBirthMonth", month);
				
				log.info("Pre-condition - Step 08: Select a year of birth in Year dropdown list that has value: " + year);
				registerPage.selectDOBInDropdownListByName("DateOfBirthYear", year);
				
				log.info("Pre-condition - Step 09: Input to Email textbox: " + validEmail);
				registerPage.inputToDynamicTextboxByID("Email", validEmail);
				
				log.info("Pre-condition - Step 10: Input to Password textbox: " + password);
				registerPage.inputToDynamicTextboxByID("Password", password);
				
				log.info("Pre-condition - Step 11: Input to ConfirmPassword textbox: " + password);
				registerPage.inputToDynamicTextboxByID("ConfirmPassword", confirmPassword);
				
				log.info("Pre-condition - Step 12: Click to Register button");
				registerPage.clickToRegisterButton();
				
				log.info("Pre-condition - Step 13: Verify success registered message displayed correctly with content is 'Your registration completed'");
				verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		 }
		
		
	@Test
	public void Order_01_Add_Product_To_Cart() {
		log.info("Order_01_Add_Product_To_Cart - Step 01: Open Desktops products page");
		userComputerPage = registerPage.selectASubmenuByName("Computers ", "Desktops ");
		
		log.info("Order_01_Add_Product_To_Cart - Step 02: Select a product to view detail");
		productDetailPage = userComputerPage.selectAProductByNameToViewDetail(productName1);
		
		log.info("Order_01_Add_Product_To_Cart - Step 03: Select RAM option" + hddSize);
		productDetailPage.selectRAMOptionInDropdownList(ramSize);
		
		log.info("Order_01_Add_Product_To_Cart - Step 04: Select HDD option" + ramSize);
		productDetailPage.selectHDDOptionRadioButton(hddSize);
		
		log.info("Order_01_Add_Product_To_Cart - Step 05: Select Processor type" + processorType);
		productDetailPage.selectProcessorInDropdown(processorType);
		
		log.info("Order_01_Add_Product_To_Cart - Step 06: Select OS type" +os);
		productDetailPage.selectOSTypeRadioButton(os);
		
		log.info("Order_01_Add_Product_To_Cart - Step 07: Select Software option" + software);
		productDetailPage.selectSoftwareOptionCheckbox(software);
		
		log.info("Order_01_Add_Product_To_Cart - Step 08: Input order number to textbox" + orderNumber);
		productDetailPage.inputOrderNumber(orderNumber);
		
		log.info("Order_01_Add_Product_To_Cart - Step 09: Get Price value");
		price = productDetailPage.getpriceValueOfAddedToCartProduct();
			System.out.println(price);	
		log.info("Order_01_Add_Product_To_Cart - Step 10: Click on Add to Cart button");
		productDetailPage.clickToOverviewButtonByProductNameAndButtonLabel(productName1, "Add to cart");
		
		log.info("Order_01_Add_Product_To_Cart - Step 11: Verify the success message displayed with correct content 'The product has been added to your shopping cart'");
		verifyEquals(productDetailPage.getResultMessageAfterClickOnOverviewButtons(),"The product has been added to your shopping cart");
		
		log.info("Order_01_Add_Product_To_Cart - Step 12: Verify order number shown on Shopping cart link on top menu");
		verifyEquals(productDetailPage.getOrderNumberDisplayedOnShoppingCartLink(), orderNumber);
		
		log.info("Order_01_Add_Product_To_Cart - Step 13: Close the success message");
		productDetailPage.closeSuccessMessage();
		
		log.info("Order_01_Add_Product_To_Cart - Step 14: Hover over Shopping cart link");
		productDetailPage.hoverOverShoppingCartLink();
		
		log.info("Order_01_Add_Product_To_Cart - Step 15: Verify the information of builder computer is displayed correctly when hover mouse over Shopping cart link");
		verifyTrue(productDetailPage.isCorrectInfoDisplayedOnShoppingCartLink(processorType, ramSize, hddSize, os, software));
		
		log.info("Order_01_Add_Product_To_Cart - Step 16: Verify the price displayed correctly on Shopping cart link");
		verifyEquals(productDetailPage.getProductPriceDisplayedOnShoppingCartLink(), price);
		
		log.info("Order_01_Add_Product_To_Cart - Step 17: Verify the number shown in the sentence 'There are "+ orderNumber + " item(s) in your cart");
		// way 1st
		verifyEquals(productDetailPage.getNumberItemInTextShownOnShoppingCartLink(), orderNumber);
		
		// way 2nd
		verifyEquals(productDetailPage.getTextShowNumberItemOnShoppingCartLink(), "There are " + orderNumber + " item(s) in your cart.");

	}
	
	@Test
	public void Order_02_Edit_Product_In_Shopping_Cart() {
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 01: Open Shopping cart page");
		productDetailPage.openLinkPageAtHomePageByName(driver, "Shopping cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 02: Click on Edit link on a product on Shopping cart page");
		productDetailPage = shoppingCartPage.clickToEditLink();
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 03: Edit RAM option" +editRAMSize);
		productDetailPage.selectRAMOptionInDropdownList(editRAMSize);
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 04: Edit HDD option" + editHDDSize);
		productDetailPage.selectHDDOptionRadioButton(editHDDSize);
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 05: Edit Processor type" + editProcessorType);
		productDetailPage.selectProcessorInDropdown(editProcessorType);
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 06: Edit OS type" + editOS);
		productDetailPage.selectOSTypeRadioButton(editOS);
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 07: Edit Software option" + editSoftware);
		productDetailPage.deselectSoftwareOptionCheckbox(software);
		productDetailPage.selectSoftwareOptionCheckbox(editSoftware);
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 08: Edit order number to textbox" + editOrderNumber);
		productDetailPage.inputOrderNumber(editOrderNumber);
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 09: Get Price value");
		price = productDetailPage.getpriceValueOfAddedToCartProduct();
			System.out.println(price);	
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 10: Click on UPDATE button");
		productDetailPage.clickToOverviewButtonByProductNameAndButtonLabel(productName1, "Update");
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 11: Verify the success message displayed with correct content 'The product has been added to your shopping cart'");
		verifyEquals(productDetailPage.getResultMessageAfterClickOnOverviewButtons(),"The product has been added to your shopping cart");
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 12: Verify order number shown on Shopping cart link on top menu");
		verifyEquals(productDetailPage.getOrderNumberDisplayedOnShoppingCartLink(), editOrderNumber);
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 13: Close the success message");
		productDetailPage.closeSuccessMessage();
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 14: Hover over Shopping cart link");
		productDetailPage.hoverOverShoppingCartLink();
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 15: Verify the information of builder computer is displayed correctly when hover mouse over Shopping cart link");
		verifyTrue(productDetailPage.isCorrectInfoDisplayedOnShoppingCartLink(editProcessorType, editRAMSize, editHDDSize, editOS, editSoftware));
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 16: Verify the price displayed correctly on Shopping cart link");
		verifyEquals(productDetailPage.getProductPriceDisplayedOnShoppingCartLink(), price);
		
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 17: Verify the number shown in the sentence 'There are "+ editOrderNumber + " item(s) in your cart");
		// way 1st
		verifyEquals(productDetailPage.getNumberItemInTextShownOnShoppingCartLink(), editOrderNumber);
		
		// way 2nd
		verifyEquals(productDetailPage.getTextShowNumberItemOnShoppingCartLink(), "There are " + editOrderNumber + " item(s) in your cart.");
	
		log.info("Order_02_Edit_Product_In_Shopping_Cart - Step 18: Verify the total price equals: " +  Integer.valueOf(price.replace("$", "").replace(",", "").replace(".00", "")) * Integer.valueOf(editOrderNumber));
		verifyEquals(productDetailPage.getTotalPriceShownOnShoppingCartLink(), Integer.valueOf(price.replace("$", "").replace(",", "").replace(".00", "")) * Integer.valueOf(editOrderNumber));
	}
	
	@Test
	public void Order_03_Remove_Product_From_Shopping_Cart() {
		log.info("Order_03_Remove_Product_From_Shopping_Cart - Step 01: Open Shopping cart page");
		productDetailPage.openLinkPageAtHomePageByName(driver, "Shopping cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		log.info("Order_03_Remove_Product_From_Shopping_Cart - Step 02: Click on Remove icon on product to remove it from shopping cart");
		shoppingCartPage.clickToRemoveIconOnAProductOnShoppingCartPage("Build your own computer");
		
		log.info("Order_03_Remove_Product_From_Shopping_Cart - Step 03: Verify the shopping cart is empty with the message displayed 'Your Shopping Cart is empty!'");
		verifyEquals(shoppingCartPage.getNoDataMessageOnShoppingCartPage(),"Your Shopping Cart is empty!");				
	
		log.info("Order_03_Remove_Product_From_Shopping_Cart - Step 04: Verify the number displayed (=0) on Shopping cart link on top menu");
		productDetailPage = PageGeneratorManager.getProductDetailPage(driver);
		verifyEquals(productDetailPage.getOrderNumberDisplayedOnShoppingCartLink(),"0");
	}
	
	@Test
	public void Order_04_Update_Shopping_Cart() {
		log.info("Order_04_Update_Shopping_Cart - Step 01: Click on Computer link");
		productDetailPage.openTopMenuLinkPageByName(driver, "Computers");
		
		log.info("Order_04_Update_Shopping_Cart - Step 02: Click on Desktops link");
		productDetailPage.openSubLinkPageByName(driver, "Desktops ");
		
		log.info("Order_04_Update_Shopping_Cart - Step 03: Click on ADD TO CART button on product name " + updateProduct);
		productDetailPage.clickToOverviewButtonByProductNameAndButtonLabelOnProductPage(updateProduct, "Add to cart");
		
		log.info("Order_04_Update_Shopping_Cart - Step 04: Verify the success added product to shopping cart message displayed");
		verifyEquals(productDetailPage.getResultMessageAfterClickOnOverviewButtons(), "The product has been added to your shopping cart");
		
		log.info("Order_04_Update_Shopping_Cart - Step 05: Click on Shopping cart link");
		productDetailPage.openLinkPageAtHomePageByName(driver, "Shopping cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("Order_04_Update_Shopping_Cart - Step 06: Get product's price before updating Qty");
		updateProductPrice = shoppingCartPage.getProductAttributeOnShoppingCartByName(updateProduct, "Price:");
		
		log.info("Order_04_Update_Shopping_Cart - Step 07: Get product's Total price before updating Qty");
		productTotalPriceBefore = updateProductPrice = shoppingCartPage.getProductAttributeOnShoppingCartByName(updateProduct, "Total:");
		
		log.info("Order_04_Update_Shopping_Cart - Step 08: Verify the total price is correct before updating Qty");
		verifyTrue(shoppingCartPage.isTotalPriceUpdatedCorrectlyCorrespondingToQtyNumber(defaultQty, updateProductPrice, productTotalPriceBefore));
		
		log.info("Order_04_Update_Shopping_Cart - Step 09: Input value to Qty textbox with value is: " + updateQty);
		shoppingCartPage.inputValueToQtyTextboxForAProductOnShoppingPage(updateProduct, updateQty);
		
		log.info("Order_04_Update_Shopping_Cart - Step 10: Click on Update shopping cart button");
		shoppingCartPage.clickToButtonsOnShoppingCartByName("Update shopping cart");
		
		log.info("Order_04_Update_Shopping_Cart - Step 11: Get product's Total price after updating Qty");
		productTotalPriceAfter = shoppingCartPage.getProductAttributeOnShoppingCartByName(updateProduct, "Total:");
		
		log.info("Order_04_Update_Shopping_Cart - Step 12: Verify the total price is updated = price*Qty after changing Qty ");
		verifyTrue(shoppingCartPage.isTotalPriceUpdatedCorrectlyCorrespondingToQtyNumber(updateQty, updateProductPrice, productTotalPriceAfter));
		
	}@Test
	public void Order_05_Checkout_Order() {
		log.info("Order_05_Checkout_Order - Step 01: Select Gift wrapping option in dropdown list");
		shoppingCartPage.selectGiftWrappingOptionInDropdownList(giftWrapping);
		
		log.info("Order_05_Checkout_Order - Step 02: Check the agreement terms of service checkbox");
		shoppingCartPage.checkAgreementTermsOfServiceCheckbox();		

		log.info("Order_05_Checkout_Order - Step 03: Click on CHECKOUT button");
		checkoutPage = shoppingCartPage.clickToCheckoutButton();
		
		log.info("Order_05_Checkout_Order - Step 04: ");
		checkoutPage.selectShipToTheSameAddressCheckbox();
		
		log.info("Order_05_Checkout_Order - Step 05: Select Country in dropdown list: " + country);
		checkoutPage.selectOptionInDropdownList("Country:", country);
		
		log.info("Order_05_Checkout_Order - Step 06: Select State/ Province in dropdown list: " + stateProvince);
		checkoutPage.selectOptionInDropdownList("State / province:", stateProvince);
		
		log.info("Order_05_Checkout_Order - Step 07: Input to City textbox the value: " + city);
		checkoutPage.inputToTextboxByLabel("City:", city);
		
		log.info("Order_05_Checkout_Order - Step 08: Input to Address1 textbox the value: " + address1);
		checkoutPage.inputToTextboxByLabel("Address 1:", address1);
		
		log.info("Order_05_Checkout_Order - Step 09: Input to Address2 textbox the value: " + address2);
		checkoutPage.inputToTextboxByLabel("Address 2:", address2);
		
		log.info("Order_05_Checkout_Order - Step 09: Input to Zip/ postal code textbox the value: " + zipPostal);
		checkoutPage.inputToTextboxByLabel("Zip / postal code:", zipPostal);
		
		log.info("Order_05_Checkout_Order - Step 09: Input to Phone number textbox the value: " + phoneNumber);
		checkoutPage.inputToTextboxByLabel("Phone number:", phoneNumber);
		
		log.info("Order_05_Checkout_Order - Step 10: Click on CONTINUE button");
		checkoutPage.clickToContinueButtonByClass("new-address-next-step-button");
		
		log.info("Order_05_Checkout_Order - Step 11: Select Shipping method radio button based on ID");
		checkoutPage.selectShippingMethodRadioButton("shippingoption_0");
		
		log.info("Order_05_Checkout_Order - Step 12: Click on CONTINUE button");
		checkoutPage.clickToContinueButtonByClass("shipping-method-next-step-button");
		
		log.info("Order_05_Checkout_Order - Step 13: Select Payment method radio button based on ID");
		checkoutPage.selectPaymentMethodRadioButton("paymentmethod_0");
		
		log.info("Order_05_Checkout_Order - Step 14: Click on CONTINUE button");
		checkoutPage.clickToContinueButtonByClass("payment-method-next-step-button");		
		
		log.info("Order_05_Checkout_Order - Step 15: Verify Payment Information content");
		checkoutPage.getPaymentInformationContent();
		
		log.info("Order_05_Checkout_Order - Step 16: Click on CONTINUE button");
		checkoutPage.clickToContinueButtonByClass("payment-info-next-step-button");
		
		log.info("Order_05_Checkout_Order - Step 17: Verify Billing address 'Address1' info displayed in Confirm section");
		verifyEquals(checkoutPage.getBillingAddressInfoInConfirmSectionByClass("address1"), address1);
		
		log.info("Order_05_Checkout_Order - Step 18: Verify Billing address 'Country' info displayed in Confirm section");
		verifyEquals(checkoutPage.getBillingAddressInfoInConfirmSectionByClass("country").trim(), country);
		
		log.info("Order_05_Checkout_Order - Step 19: Verify Billing address 'Phone' info displayed in Confirm section");
		verifyEquals(checkoutPage.getBillingAddressInfoInConfirmSectionByClass("phone").trim().replace("Phone: ", ""), phoneNumber);
		
		log.info("Order_05_Checkout_Order - Step 20: Verify Billing address 'Payment method' info displayed in Confirm section");
		verifyEquals(checkoutPage.getPaymentMethodInfoInConfirmSection().trim(), paymentMethod);
		
		log.info("Order_05_Checkout_Order - Step 21: Verify Billing address 'Shipping method' info displayed in Confirm section");
		verifyEquals(checkoutPage.getShippingMethodInfoInConfirmSection().trim(), shippingMethod.replace(" ($0.00)", ""));
		
		log.info("Order_05_Checkout_Order - Step 22: Verify State/ Province, City and Zip/ postal code are displayed correct in Confirm section");
		verifyTrue(checkoutPage.isBillingStateProvinceCityZipPostalCodeDisplayedCorrectlyInConfirmSection(city, stateProvince, zipPostal));
		
		log.info("Order_05_Checkout_Order - Step 23: Verify Product's name displayed correct on Checkout table");
		verifyEquals(checkoutPage.getProductNameOnCheckoutTable(), updateProduct);
		
		log.info("Order_05_Checkout_Order - Step 24: Verify Product's price displayed correct on Checkout table");
		verifyEquals(checkoutPage.getProductAttributesOnCheckoutTable("unit-price"), updateProductPrice);
		
		log.info("Order_05_Checkout_Order - Step 25: Verify Product's Qty displayed correct on Checkout table");
		verifyEquals(checkoutPage.getProductAttributesOnCheckoutTable("quantity"), updateQty);
		
		log.info("Order_05_Checkout_Order - Step 26: Verify Product's total price displayed correct on Checkout table");
		verifyEquals(checkoutPage.getProductAttributesOnCheckoutTable("subtotal"), productTotalPriceAfter);
		
		log.info("Order_05_Checkout_Order - Step 27: Verify Gift wrapping method displayed correct on Checkout table");
		verifyEquals(checkoutPage.getGiftWrappingMethodOnCheckoutPage(), giftWrapping);
		
		log.info("Order_05_Checkout_Order - Step 28: Verify Sub-total value displayed correct on Checkout Summary info");
		verifyEquals(checkoutPage.getSummaryPriceOnCheckoutPage("order-subtotal", "value-summary"), productTotalPriceAfter);
		
		log.info("Order_05_Checkout_Order - Step 29: Verify Shipping method displayed correct on Checkout Summary info");
		verifyEquals(checkoutPage.getSummaryPriceOnCheckoutPage("shipping-cost", "selected-shipping-method").replace("(", "").replace(")", ""), shippingMethod.replace(" ($0.00)", ""));
		
		log.info("Order_05_Checkout_Order - Step 30: Get corresponding Shipping fee displayed correct on Checkout Summary info");
		String shippingFee = checkoutPage.getSummaryPriceOnCheckoutPage("shipping-cost", "value-summary");
		
		
		log.info("Order_05_Checkout_Order - Step 31: Get tax value displayed on Checkout Summary info");
		String tax = checkoutPage.getSummaryPriceOnCheckoutPage("tax-value", "value-summary");
		
		log.info("Order_05_Checkout_Order - Step 32: Get Total value displayed on Checkout Summary info");
		String total = checkoutPage.getSummaryPriceOnCheckoutPage("order-total", "value-summary");
						
		log.info("Order_05_Checkout_Order - Step 33: Verify the 'total = sub-total + shipping fee + tax' displayed on Checkout Summary info");
		verifyTrue(checkoutPage.isCorrectTotalValueOnCheckoutSummary(productTotalPriceAfter, shippingFee, tax, total));
		
		log.info("Order_05_Checkout_Order - Step 34: Click on CONFIRM button");
		checkoutPage.clickToConfirmButton();
		
		log.info("Order_05_Checkout_Order - Step 35: Verify order success message displayed with correct content 'Your order has been successfully processed!'");
		verifyEquals(checkoutPage.getOrderSuccessMessageDisplayed(),"Your order has been successfully processed!");
		
		log.info("Order_05_Checkout_Order - Step 36: Get Order Number");
		String orderNumber = checkoutPage.getOrderNumber();
		
		log.info("Order_05_Checkout_Order - Step 37: Click on  My account link");
		checkoutPage.openLinkPageAtHomePageByName(driver, "My account");
		
		log.info("Order_05_Checkout_Order - Step 38: Click on Order link");
		checkoutPage.openPageAtMyAccountByPageName(driver, "Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);
		
		log.info("Order_05_Checkout_Order - Step 39: Verify Order number displayed on Order page");
		verifyEquals(orderPage.getOrderNumberDisplayedOnOrderPage(), orderNumber);
		
		log.info("Order_05_Checkout_Order - Step 40: Click on Detail button");
		orderPage.clickToDetailButton();
		
		log.info("Order_05_Checkout_Order - Step 41: Verify Order number displayed on Order detail page");
		verifyEquals(orderPage.getOrderNumberDisplayedOnOrderDetailPage(), orderNumber);
		
		log.info("Order_05_Checkout_Order - Step 42: Verify Billing address 'Address1' info displayed on Order detail");
		verifyEquals(orderPage.getBillingAddressInfoOnOrderDetailPageByClass("address1"), address1);
		
		log.info("Order_05_Checkout_Order - Step 43: Verify Billing address 'Country' info displayed on Order detail");
		verifyEquals(orderPage.getBillingAddressInfoOnOrderDetailPageByClass("country").trim(), country);
		
		log.info("Order_05_Checkout_Order - Step 44: Verify product' name is displayed correctly on Order detail");
		verifyEquals(orderPage.getProductNameOnOrderDetailPage(), updateProduct);
	}
		
}
