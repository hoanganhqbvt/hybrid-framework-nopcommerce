package pageObjects.jQuery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFile.HomePageUploadFileUI;

public class HomepageObject extends BasePage{
	WebDriver driver;

	
	public HomepageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUploadFileUI.FILE_NAME_LOADED, fileName);
		return isElementDisplay(driver, HomePageUploadFileUI.FILE_NAME_LOADED, fileName);
	}
	public boolean isFileLinkUploadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUploadFileUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplay(driver, HomePageUploadFileUI.FILE_NAME_UPLOADED_LINK, fileName);
	}
	public boolean isFileImageUploadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUploadFileUI.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, HomePageUploadFileUI.FILE_NAME_UPLOADED_IMAGE, fileName);
	}
	
	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElement(driver, HomePageUploadFileUI.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
	}

}
