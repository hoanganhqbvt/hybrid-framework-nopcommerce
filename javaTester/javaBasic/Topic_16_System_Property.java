package javaBasic;

import java.io.File;

public class Topic_16_System_Property {
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles";
	
public static void main(String[] args) {
	System.out.println(PROJECT_PATH);
	System.out.println(OS_NAME);
	System.out.println(UPLOAD_FILE);
}
}
