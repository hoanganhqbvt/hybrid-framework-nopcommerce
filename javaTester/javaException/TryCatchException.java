package javaException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryCatchException {

	public static void main(String[] args) {
		int number = 10;
		try {	//đúng: chạy hết đoạn code trong try và ko qua catch
			// sai: gặp exception -> nhảy qua catch
			number = number / 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		System.out.println(number);
		String[] browserName = {"firefox", "chrome", "edge"};
		
		try {
			browserName[1] = "safari";
			browserName[3] = "IE";
		} catch (Exception e) {
			e.printStackTrace();
		}		
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream("C://automationFC.txt");
			outputStream.write(65);
			outputStream.close();
			outputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
