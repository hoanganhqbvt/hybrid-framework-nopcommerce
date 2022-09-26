package pageObjects.orangeHRM.admin;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManagerOrangeHRM {
	
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	public static PIMEmployeeListPO getPIMEmployeeListPage(WebDriver driver) {
		return new PIMEmployeeListPO(driver);
	}
	public static PIMAddEmployeePO getPIMAddEmployeePage(WebDriver driver) {
		return new PIMAddEmployeePO(driver);
	}
	
	public static EmployeeDetailPO getEmployeeDetailPage(WebDriver driver) {
		return new EmployeeDetailPO(driver);
	}
	
	public static PersonalDetailPO getPersonalDetailPage(WebDriver driver) {
		return new PersonalDetailPO(driver);
	}
	
	public static ContactDetailPO getContactDetailPage(WebDriver driver) {
		return new ContactDetailPO(driver);
	}
	
	public static EmergencyContactPO getEmergencytDetailPage(WebDriver driver) {
		return new EmergencyContactPO(driver);
	}
	
	public static DependentPO getDepentdentPage(WebDriver driver) {
		return new DependentPO(driver);
	}
	
	public static JobPageObject getJobPage(WebDriver driver) {
		return new JobPageObject(driver);
	}
	
	public static SalaryPageObject getSalaryPage(WebDriver driver) {
		return new SalaryPageObject(driver);
	}
	
	public static TaxPageObject getTaxPage(WebDriver driver) {
		return new TaxPageObject(driver);
	}
	
	public static QualificationPageObject getQualificationPage(WebDriver driver) {
		return new QualificationPageObject(driver);
	}
}
