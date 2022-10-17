package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.ProductDetailPageObject;
import pageObjects.nopCommerce.user.ShoppingCarPageObject;
import pageObjects.nopCommerce.user.UserComputerPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.WishlistPageObject;

public class Wishlist_Compare_RecentView extends BaseTest{
	WebDriver driver;
	 private UserHomePageObject userHomePage;
	 private UserRegisterPageObject registerPage;
	 private UserComputerPageObject userComputerPage;
	 private ProductDetailPageObject productDetailPage;
	 private WishlistPageObject wishlistPage;
	 private ShoppingCarPageObject shoppingCartPage;
	 String invalidEmail = "abc@123@abc";
	 int fakeNumber = generateFakeNumber();
	 String validEmail = "automail" + fakeNumber + "@gmail.com", firstName = "Automation", lastName = "Testing", gender = "Male",
			password = "Abc@123456", confirmPassword = password, day = "20", month = "October", year = "1990";
	String notExistData = "Macbook Pro 2050";
			
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
		
@Test(priority = 1)
public void Wishlist_01_Add_To_Wishlist() {
	log.info("Wishlist_01_Add_To_Wishlist - Step 01: Open Notebook products page");
	userComputerPage = registerPage.selectASubmenuByName("Computers ", "Notebooks ");
	
	log.info("Wishlist_01_Add_To_Wishlist - Step 02: Select a product to view detail");
	productDetailPage = userComputerPage.selectAProductByNameToViewDetail("Apple MacBook Pro 13-inch");
	
	log.info("Wishlist_01_Add_To_Wishlist - Step 03: Click on Add to Wishlist button");
	productDetailPage.clickToOverviewButtonByProductNameAndButtonLabel("Apple MacBook Pro 13-inch", "Add to wishlist" );
	
	log.info("Wishlist_01_Add_To_Wishlist - Step 04: Verify the result message displays with correct content 'The product has been added to your wishlist'");
	verifyEquals(productDetailPage.getResultMessageAfterClickOnOverviewButtons(), "The product has been added to your wishlist");
	
	log.info("Wishlist_01_Add_To_Wishlist - Step 05: Open Wishlist page");
	productDetailPage.openLinkPageAtHomePageByName(driver, "Wishlist");
	wishlistPage = PageGeneratorManager.getWishlistPage(driver);
	
	log.info("Wishlist_01_Add_To_Wishlist - Step 06: Verify the product is displayed correctly on WishList page");
	verifyTrue(wishlistPage.isProductDisplayedCorrectlyOnWishListPage("Apple MacBook Pro 13-inch"));
	
	log.info("Wishlist_01_Add_To_Wishlist - Step 07: Click to 'Your wishlist URL for sharing:' link");
	wishlistPage.clickToWishlistSharingLink();
	
	log.info("Wishlist_01_Add_To_Wishlist - Step 08: Verify title of wishlist share link page contains user name: " +firstName + " " + lastName);
	wishlistPage.isWishlistSharePageTitleContainsUsername(firstName + " " + lastName);	
	
	log.info("Wishlist_01_Add_To_Wishlist - Step 09: Open Home Page");
	wishlistPage.clickToHomePageIcon();	
}

@Test(priority = 2)
public void Wishlist_02_Add_To_Cart_From_Wishlist() {
	log.info("Wishlist_02_Add_To_Cart_From_Wishlist - Step 01: Open Wishlist page");
	wishlistPage.openLinkPageAtHomePageByName(driver, "Wishlist");
	
	log.info("Wishlist_02_Add_To_Cart_From_Wishlist - Step 02: Select 'Add to Cart' checkbox");
	wishlistPage.selectAddToCartCheckboxByProductName("Apple MacBook Pro 13-inch");
	
	log.info("Wishlist_02_Add_To_Cart_From_Wishlist - Step 03: Click on ADD TO CART button");
	shoppingCartPage = wishlistPage.clickToAddToCartButton();
	
	log.info("Wishlist_02_Add_To_Cart_From_Wishlist - Step 04: Verify the product is added to cart page");
	shoppingCartPage.isProductAddedToCartPage("Apple MacBook Pro 13-inch");
	
	log.info("Wishlist_02_Add_To_Cart_From_Wishlist - Step 05: Open Wishlist page");
	shoppingCartPage.openLinkPageAtHomePageByName(driver, "Wishlist");
	wishlistPage = PageGeneratorManager.getWishlistPage(driver);
	
	log.info("Wishlist_02_Add_To_Cart_From_Wishlist - Step 05: Verify the product was removed from Wishlist page after adding it to Cart page");
	wishlistPage.isProductRemovedFromWishlistAfterAddingItToCartPage("Apple MacBook Pro 13-inch");
	

}
}
