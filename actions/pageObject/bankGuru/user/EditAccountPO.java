package pageObject.bankGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.bankGuru.user.EditAccountPageUI;

public class EditAccountPO extends BasePage{
 WebDriver driver;

public EditAccountPO(WebDriver driver) {
	this.driver = driver;
}

public void clickToSubmitButton() {
	waitForElementClickable(driver, EditAccountPageUI.SUBMIT_BUTTON);
	clickToElement(driver, EditAccountPageUI.SUBMIT_BUTTON);
}

public void inputToAccountIDTextbox(String accountID) {
	waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
	sendkeyToElement(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX, accountID);
}
 
}
