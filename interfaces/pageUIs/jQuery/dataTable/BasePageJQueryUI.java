package pageUIs.jQuery.dataTable;

import java.io.File;

public class BasePageJQueryUI {
public static final String PROJECT_PATH = System.getProperty("user.dir");
public static final String START_BUTTON = "css=table button.start";
public static final String UPLOAD_FILE = "xpath=//input[@type='file']";
public static final String FILE_NAME_LOADED = "xpath=//p[@class='name' and text()='%s']";
public static final String FILE_NAME_UPLOADED_LINK = "xpath=//a[text()='%s']";
public static final String FILE_NAME_UPLOADED_IMAGE = "xpath=//a[@title='%s']/img";
}