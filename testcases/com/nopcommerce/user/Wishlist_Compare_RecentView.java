package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.CompareProductListPageObject;
import pageObjects.nopCommerce.user.ProductDetailPageObject;
import pageObjects.nopCommerce.user.RecentlyViewProductPageObject;
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
	 private CompareProductListPageObject compareProductPage;
	 private RecentlyViewProductPageObject recentlyViewProductPage;
	 String invalidEmail = "abc@123@abc";
	 int fakeNumber = generateFakeNumber();
	 String validEmail = "automail" + fakeNumber + "@gmail.com", firstName = "Automation", lastName = "Testing", gender = "Male",
			password = "Abc@123456", confirmPassword = password, day = "20", month = "October", year = "1990";
	String productName1 = "Apple MacBook Pro 13-inch", productPrice1 = "$1,800.00";
	String productName2 = "Asus N551JK-XO076H Laptop", productName3 = "HP Envy 6-1180ca 15.6-Inch Sleekbook",
			productName4 = "HP Spectre XT Pro UltraBook", productName5 = "Lenovo Thinkpad X1 Carbon Laptop";
	
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
	productDetailPage = userComputerPage.selectAProductByNameToViewDetail(productName1);
	
	log.info("Wishlist_01_Add_To_Wishlist - Step 03: Click on Add to Wishlist button");
	productDetailPage.clickToOverviewButtonByProductNameAndButtonLabel(productName1, "Add to wishlist" );
	
	log.info("Wishlist_01_Add_To_Wishlist - Step 04: Verify the result message displays with correct content 'The product has been added to your wishlist'");
	verifyEquals(productDetailPage.getResultMessageAfterClickOnOverviewButtons(), "The product has been added to your wishlist");
	
	log.info("Wishlist_01_Add_To_Wishlist - Step 05: Open Wishlist page");
	productDetailPage.openLinkPageAtHomePageByName(driver, "Wishlist");
	wishlistPage = PageGeneratorManager.getWishlistPage(driver);
	
	log.info("Wishlist_01_Add_To_Wishlist - Step 06: Verify the product is displayed correctly on WishList page");
	verifyTrue(wishlistPage.isProductDisplayedCorrectlyOnWishListPage(productName1));
	
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
	wishlistPage.selectAddToCartCheckboxByProductName(productName1);
	
	log.info("Wishlist_02_Add_To_Cart_From_Wishlist - Step 03: Click on ADD TO CART button");
	shoppingCartPage = wishlistPage.clickToAddToCartButton();
	
	log.info("Wishlist_02_Add_To_Cart_From_Wishlist - Step 04: Verify the product is added to cart page");
	shoppingCartPage.isProductAddedToCartPage(productName1);
	
	log.info("Wishlist_02_Add_To_Cart_From_Wishlist - Step 05: Open Wishlist page");
	shoppingCartPage.openLinkPageAtHomePageByName(driver, "Wishlist");
	wishlistPage = PageGeneratorManager.getWishlistPage(driver);
	
	log.info("Wishlist_02_Add_To_Cart_From_Wishlist - Step 05: Verify the product was removed from Wishlist page after adding it to Cart page");
	wishlistPage.isProductRemovedFromWishlist(productName1);	
}

@Test(priority = 3)
public void Wishlist_03_Remove_Product_From_Wishlist() {
	log.info("Wishlist_03_Remove_Product_From_Wishlist - Step 01: Open Desktop products page");
	userComputerPage = registerPage.selectASubmenuByName("Computers ", "Desktops ");
	
	log.info("Wishlist_03_Remove_Product_From_Wishlist - Step 02: Click on Add to Wishlist for product' name is 'Lenovo IdeaCentre 600 All-in-One PC'");
	wishlistPage = PageGeneratorManager.getWishlistPage(driver);
	wishlistPage.clickToAddToWishlistButtonByProductName("Lenovo IdeaCentre 600 All-in-One PC");
	
	log.info("Wishlist_03_Remove_Product_From_Wishlist - Step 03: Verify the result message displays with correct content 'The product has been added to your wishlist'");
	verifyEquals(wishlistPage.getResultMessageAfterClickOnOverviewButtons(), "The product has been added to your wishlist");
	
	log.info("Wishlist_03_Remove_Product_From_Wishlist - Step 04: Click on Add to Wishlist for product' name is 'Digital Storm VANQUISH 3 Custom Performance PCr'");
	wishlistPage.clickToAddToWishlistButtonByProductName("Digital Storm VANQUISH 3 Custom Performance PC");
	
	log.info("Wishlist_03_Remove_Product_From_Wishlist - Step 05: Verify the result message displays with correct content 'The product has been added to your wishlist'");
	verifyEquals(productDetailPage.getResultMessageAfterClickOnOverviewButtons(), "The product has been added to your wishlist");
		
	log.info("Wishlist_03_Remove_Product_From_Wishlist - Step 06: Open Wishlist page");
	wishlistPage.openLinkPageAtHomePageByName(driver, "Wishlist");
	
	log.info("Wishlist_03_Remove_Product_From_Wishlist - Step 07: Click on Remove icon on a product to remove it from wishlist page");
	wishlistPage.removeProductFromWishlist("Digital Storm VANQUISH 3 Custom Performance PC");
	
	log.info("Wishlist_03_Remove_Product_From_Wishlist - Step 08: Verify the product was removed from Wishlist page");
	wishlistPage.isProductRemovedFromWishlist("Digital Storm VANQUISH 3 Custom Performance PC");
	
	log.info("Wishlist_03_Remove_Product_From_Wishlist - Step 09: Open Home Page");
	wishlistPage.clickToHomePageIcon();	
}

@Test(priority = 4)
public void Wishlist_04_Add_Product_To_Compare() {
	log.info("Wishlist_04_Add_Product_To_Compare - Step 01: Open Notebooks products page");
	userComputerPage = registerPage.selectASubmenuByName("Computers ", "Notebooks ");
	
	log.info("Wishlist_04_Add_Product_To_Compare - Step 02: Click on Add to Wishlist for product' name is: " +productName1);
	wishlistPage = PageGeneratorManager.getWishlistPage(driver);
	wishlistPage.clickToAddToCompareButtonByProductName(productName1);
	
	log.info("Wishlist_04_Add_Product_To_Compare - Step 03: Verify the result message displays with correct content 'The product has been added to your product comparison'");
	verifyEquals(wishlistPage.getResultMessageAfterClickOnOverviewButtons(), "The product has been added to your product comparison");
	
	log.info("Wishlist_04_Add_Product_To_Compare - Step 04: Click on Add to Wishlist for product' name is 'Lenovo Thinkpad X1 Carbon Laptop'");	
	wishlistPage.clickToAddToCompareButtonByProductName("Lenovo Thinkpad X1 Carbon Laptop");
	
	log.info("Wishlist_04_Add_Product_To_Compare - Step 05: Verify the result message displays with correct content 'The product has been added to your product comparison'");
	verifyEquals(wishlistPage.getResultMessageAfterClickOnOverviewButtons(), "The product has been added to your product comparison");
	
	log.info("Wishlist_04_Add_Product_To_Compare - Step 06: Open Compare Product List page");
	wishlistPage.openLinkPageAtHomePageByName(driver, "Compare products list");
	compareProductPage = PageGeneratorManager.getCompareProductListPage(driver);
	
	log.info("Wishlist_04_Add_Product_To_Compare - Step 07: Verify the product was added to Compare List page by product name");
	compareProductPage.isProductNameDisplayedCorrectlyOnCompareProductPage(productName1);
	
	log.info("Wishlist_04_Add_Product_To_Compare - Step 08: Verify the product price is displayed correctly on Compare List");
	compareProductPage.isProductPriceDisplayedCorrectlyOnCompareProductPage(productPrice1);
	
	log.info("Wishlist_04_Add_Product_To_Compare - Step 09: Click on Clear List button");
	compareProductPage.clickToClearListButton();
	
	log.info("Wishlist_04_Add_Product_To_Compare - Step 10: Verify the message displayed with correct content 'You have no items to compare.'");
	verifyEquals(compareProductPage.getNoDataMessageOnCompareListPage(),"You have no items to compare.");
}

@Test(priority = 5)
public void Wishlist_05_Recently_View_Product() {
	
	log.info("Wishlist_05_Recently_View_Product - Step 01: Open Notebook products page");
	userComputerPage = registerPage.selectASubmenuByName("Computers ", "Notebooks ");
	
	log.info("Wishlist_05_Recently_View_Product - Step 02: Select second product to view detail");
	productDetailPage = userComputerPage.selectAProductByNameToViewDetail(productName2);
	
	log.info("Wishlist_05_Recently_View_Product - Step 03: Select third product to view detail");
	userComputerPage = registerPage.selectASubmenuByName("Computers ", "Notebooks ");
	productDetailPage = userComputerPage.selectAProductByNameToViewDetail(productName3);

	
	log.info("Wishlist_05_Recently_View_Product - Step 04: Select fourth product to view detail");
	userComputerPage = registerPage.selectASubmenuByName("Computers ", "Notebooks ");
	productDetailPage = userComputerPage.selectAProductByNameToViewDetail(productName4);
	
	
	log.info("Wishlist_05_Recently_View_Product - Step 05: Select fifth product to view detail");
	userComputerPage = registerPage.selectASubmenuByName("Computers ", "Notebooks ");
	productDetailPage = userComputerPage.selectAProductByNameToViewDetail(productName5);
	
	
	log.info("Wishlist_05_Recently_View_Product - Step 06: Open Recently view product page");
	productDetailPage.openLinkPageAtHomePageByName(driver,"Recently viewed products");	
	recentlyViewProductPage = PageGeneratorManager.getRecentlyViewProductPage(driver);
	
	log.info("Wishlist_05_Recently_View_Product - Step 07: Verify there are only lastest 3 viewed product displayed on Recently view product page");
	verifyTrue(recentlyViewProductPage.isThreeLastestViewProductDisplayedOnPage(productName3, productName4, productName5));
	
}
}
