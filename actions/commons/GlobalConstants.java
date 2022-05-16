package commons;

import java.io.File;

public class GlobalConstants {
	public static final String ADMIN_TESTING_URL = "https://admin-demo.nopcommerce.com";
	public static final String TECHPANDA_ADMIN_TESTING_URL = "https://admin-demo.nopcommerce.com";
	public static final String PORTAL_TESTING_URL = "https://demo.nopcommerce.com";
	public static final String TECHPANDA_PORTAL_TESTING_URL = "https://demo.nopcommerce.com";
	public static final String ADMIN_DEV_URL = "https://admin-demo.nopcommerce.com";
	public static final String PORTAL_DEV_URL = "https://demo.nopcommerce.com";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
		
	// windows/ MAC/ Linux
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE= PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
	public static final String BROWSER_LOG_FOLDER = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGScreenshot" +  File.separator;
	
	// Database Account/ User/ Password/ Port
	public static final String DB_DEV_URL = "32.18.252.185:0960";
	public static final String DB_DEV_USER = "automationFC";
	public static final String DB_DEV_PASS = "P@ssworld1!";
	
	public static final String DB_TEST_URL = "32.18.195.23:0960";
	public static final String DB_TESTUSER = "automationFC";
	public static final String DB_TEST_PASS = "P@ssworld1!";
	
	public static final long LONG_TIMEOUT = 30;
	public static final long SHORT_TIMEOUT = 5;
	public static final long RETRY_TEST_FAIL = 3;

	
}
