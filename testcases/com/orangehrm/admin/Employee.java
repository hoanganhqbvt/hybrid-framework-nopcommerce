package com.orangehrm.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.orangeHRM.admin.AdminLoginPO;
import pageObjects.orangeHRM.admin.ContactDetailPO;
import pageObjects.orangeHRM.admin.DependentPO;
import pageObjects.orangeHRM.admin.EmergencyContactPO;
import pageObjects.orangeHRM.admin.EmployeeDetailPO;
import pageObjects.orangeHRM.admin.JobPageObject;
import pageObjects.orangeHRM.admin.PIMAddEmployeePO;
import pageObjects.orangeHRM.admin.PIMEmployeeListPO;
import pageObjects.orangeHRM.admin.PageGeneratorManagerOrangeHRM;
import pageObjects.orangeHRM.admin.PersonalDetailPO;
import pageObjects.orangeHRM.admin.QualificationPageObject;
import pageObjects.orangeHRM.admin.SalaryPageObject;
import pageObjects.orangeHRM.admin.TaxPageObject;

public class Employee extends BaseTest {
	WebDriver driver;
	private AdminLoginPO adminLoginPage;
	private PIMEmployeeListPO pimEmployeeListPage;
	private PIMAddEmployeePO pimAddEmployeePage;
	private EmployeeDetailPO employeeDetailPage;
	private PersonalDetailPO personalDetailPage;
	private ContactDetailPO contactDetailPage;
	private EmergencyContactPO emergencyContactPage;
	private DependentPO dependentPage;
	private JobPageObject jobPage;
	private SalaryPageObject salaryPage;
	private TaxPageObject taxPage;
	private QualificationPageObject qualificationPage;
	String adminUsername = "Admin";
	String adminPassword = "admin123";
	int fakeNumber = generateFakeNumber();

	String firstName = "Employee" + fakeNumber;
	String middleName = "Mid";
	String lastName = "LastName";
	String employeeID = "ID" + fakeNumber;
	String userName = "User" + fakeNumber;
	String password = "Abcde@" + fakeNumber;
	String imageName = "image1.jpg";
	String nickname = "nickname" + fakeNumber;
	String driverLicenseNumber = "DV" + fakeNumber;
	String ssnNumber = "SSN" + fakeNumber;
	String sinNumber = "SIN" + fakeNumber;
	String gender = "Male";
	String militaryService = "No";
	String bloodType = "A+";
	String expireDriverLicenseDate = "2025-08-20";
	String dateOfBirth = "1990-10-20";
	String dependentDOB = "2017-10-09", dependentName = "Dependent" + fakeNumber, dependentRelationship = "Child";
	String nationality = "American";
	String maritalStatus = "Married";
	String street1 = "street1" + fakeNumber;
	String street2 = "street2" + fakeNumber;
	String city = "Thuan An";
	String province = "Binh Duong";
	String zipCode = "72000";
	String countryName = "Viet Nam";
	String homeNumber = "0274382123";
	String mobileNumber = "0917382666";
	String workNumber = "0228382123";
	String emergencyName = "emergencyName";
	String homeTelephoneNumber = "02381234567", mobilePhoneNumber = "0917382111", workTelephoneNumber = "02382345678";
	String relationship = "Em";
	String joinedDate = "2021-12-15", jobTitle = "QA Lead", jobCategory = "Professionals",
			jobSubUnit = "Quality Assurance", jobLocation = "New York Sales Office", jobStatus = "Full-Time Permanent";
	String salaryComponent = "Main Income", salaryAmount = "10000", payGrade = "Grade 5", payFrequency = "Monthly",
			currency = "United States Dollar";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-condition - Step 01: Open browser and access URL");
		driver = getBrowserDriver(browserName, appUrl);
		adminLoginPage = PageGeneratorManagerOrangeHRM.getAdminLoginPage(driver);

		log.info("Pre-condition - Step 02: Input admin username with value is: " + adminUsername);
		adminLoginPage.inputToUsernameTextbox(adminUsername);

		log.info("Pre-condition - Step 03: Input admin password with value is: " + adminPassword);
		adminLoginPage.inputToPasswordTextbox(adminPassword);

		log.info("Pre-condition - Step 04: Click on Login button");
		pimEmployeeListPage = adminLoginPage.clickOnLoginButton();

	}

	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add New Employee - Step 01: Click on 'Add' button ");
		pimAddEmployeePage = pimEmployeeListPage.clickToAddButton();

		log.info("Add New Employee - Step 02: Input firstname with value is: " + firstName);
		pimAddEmployeePage.inputToFirstnameTextbox(firstName);

		log.info("Add New Employee - Step 03: Input middlename with value is: " + middleName);
		pimAddEmployeePage.inputToMiddlenameTextbox(middleName);

		log.info("Add New Employee - Step 04: Input lastname with value is: " + lastName);
		pimAddEmployeePage.inputToLastnameTextbox(lastName);

		log.info("Add New Employee - Step 05: Input employee ID with value is: " + employeeID);
		pimAddEmployeePage.inputToEmployeeIDTextbox(employeeID);

		log.info("Add New Employee - Step 06: Click on Create Login Detail button");
		pimAddEmployeePage.clickToCreateLoginDetailButton();

		log.info("Add New Employee - Step 07: Input to Username textbox with value is :" + userName);
		pimAddEmployeePage.inputToUsernameTextbox(userName);

		log.info("Add New Employee - Step 08: Input to password textbox with value is :" + password);
		pimAddEmployeePage.inputToPasswordTextbox(password);

		log.info("Add New Employee - Step 09: Input to Confirm password textbox with value is :" + password);
		pimAddEmployeePage.inputToConfirmPasswordTextbox(password);

		log.info("Add New Employee - Step 10: Click to Save button");
		pimAddEmployeePage.clickToSaveButton();

		log.info("Add New Employee - Step 11: Verify the success message displayed");
		verifyTrue(pimAddEmployeePage.isAddEmployeeSuccessMessageDisplayed());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void Employee_02_Upload_Avatar() {
		employeeDetailPage = PageGeneratorManagerOrangeHRM.getEmployeeDetailPage(driver);

		log.info("Upload_Avatar - Step 01: Click on Avatar icon");
		employeeDetailPage.clickToAvatarIcon();

		log.info("Upload_Avatar - Step 02: Upload avatar image");
		employeeDetailPage.uploadAvatarImage(imageName);

		log.info("Upload_Avatar - Step 03: Verify uploaded avatar success message displayed");
		verifyTrue(employeeDetailPage.isUploadAvatarSuccessMessageDisplayed());
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void Employee_03_Personal_Detail() {
		log.info("Personal_Detail - Step 01: Click on Personal Detail link");
		personalDetailPage = employeeDetailPage.clickToPersonalDetailLink();
	
		/*
		 * log.info("Personal_Detail - Step 02: Input nick name with value is " +
		 * nickname); personalDetailPage.inputToNicknameTextbox(nickname);
		 */
		log.info("Personal_Detail - Step 02: Input Driver license with value is " + driverLicenseNumber);
		personalDetailPage.inputToDriverLicenseTextbox(driverLicenseNumber);

		log.info("Personal_Detail - Step 03: Input SSN number with value is " + ssnNumber);
		personalDetailPage.inputToSSNNumberTextbox(ssnNumber);

		log.info("Personal_Detail - Step 04: Input SIN number with value is " + sinNumber);
		personalDetailPage.inputToSINNumberTextbox(sinNumber);

		/*
		 * log.info("Personal_Detail - Step 05: Input Millitary service with value is "
		 * + militaryService);
		 * personalDetailPage.inputToMilitaryServiceTextbox(militaryService);
		 */

		log.info("Personal_Detail - Step 06: Select Gender is " + gender);
		personalDetailPage.selectGenderRadioButton(gender);

		/*
		 * log.info("Personal_Detail - Step 07: Check Smoker checkbox");
		 * personalDetailPage.selectSmokerCheckbox();
		 */

		log.info(
				"Personal_Detail - Step 08: Input expire Driver license date with value is " + expireDriverLicenseDate);
		personalDetailPage.inputToExpireDirverLicenseTextbox(expireDriverLicenseDate);

		log.info("Personal_Detail - Step 09: Input DOB with value is " + dateOfBirth);
		personalDetailPage.inputToDateOfBirthTextbox(dateOfBirth);

		log.info("Personal_Detail - Step 10: Select Nationality with value is " + nationality);
		personalDetailPage.selectNationalityFromDropdownList(nationality);

		log.info("Personal_Detail - Step 11:  Select Marital status with value is " + maritalStatus);
		personalDetailPage.selectMaritalStatusFromDropdownList(maritalStatus);

		log.info("Personal_Detail - Step 12: Click on Save required fields button");
		personalDetailPage.clickToSaveRequiredFieldsButton();

		log.info("Personal_Detail - Step 13: Verify updated Required Personal detail success message displayed");
		verifyTrue(personalDetailPage.isSuccessUpdatePersonalDetailMessageDisplayed());

		log.info("Personal_Detail - Step 14: Select Blood type with value is " + bloodType);
		personalDetailPage.selectBloodTypeFromDropdownList(bloodType);

		log.info("Personal_Detail - Step 15: Click on Save custom fields button");
		personalDetailPage.clickToSaveCustomFieldsButton();

		log.info("Personal_Detail - Step 16: Verify updated Custom Personal detail success message displayed");
		verifyTrue(personalDetailPage.isSuccessSavePersonalDetailMessageDisplayed());
	}

	@Test
	public void Employee_04_Contact_Detail() throws InterruptedException {
		log.info("Contact_Detail - Step 01: Click on Contact Detail link");
		contactDetailPage = personalDetailPage.clickToContactDetailLink();

		log.info("Contact_Detail - Step 02: Input address Street 1 with value is: " + street1);
		contactDetailPage.inputToTextboxByLabel("Street 1", street1);

		log.info("Contact_Detail - Step 03: Input address Street 2 with value is: " + street2);
		contactDetailPage.inputToTextboxByLabel("Street 2", street2);

		log.info("Contact_Detail - Step 04: Input address State/Province with value is: " + province);
		contactDetailPage.inputToTextboxByLabel("State/Province", province);

		log.info("Contact_Detail - Step 05: Input address Zip/Postal code with value is: " + zipCode);
		contactDetailPage.inputToTextboxByLabel("Zip/Postal Code", zipCode);

		log.info("Contact_Detail - Step 06: Select country from dropdown list with value is: " + countryName);
		contactDetailPage.selectCountryFromDropdownList(countryName);

		log.info("Contact_Detail - Step 07: Input Telephone  Home with number is: " + homeNumber);
		contactDetailPage.inputToTextboxByLabel("Home", homeNumber);

		log.info("Contact_Detail - Step 08: Input Telephone Mobile with number is: " + mobileNumber);
		contactDetailPage.inputToTextboxByLabel("Mobile", mobileNumber);

		log.info("Contact_Detail - Step 09: Input Telephone Work with number is: " + workNumber);
		contactDetailPage.inputToTextboxByLabel("Work", workNumber);

		log.info("Contact_Detail - Step 10: Click on Save button");
		contactDetailPage.clickToSaveButton();

		log.info(
				"Contact_Detail - Step 11: Verify success saved contact detail info message displayed with text 'Successfully Updated'");
		verifyTrue(contactDetailPage.isSaveContactDetailMessageDisplayed());
		Thread.sleep(5000);
	}

	@Test
	public void Employee_05_Emergency_Detail() {
		log.info("Emergency_Detail - Step 01: Open Emergency Detail page");

		contactDetailPage.openPageAtEmployeeDetailByPageName(driver, "Emergency Contacts");
		emergencyContactPage = PageGeneratorManagerOrangeHRM.getEmergencytDetailPage(driver);

		log.info("Emergency_Detail - Step 02: Click on '+ Add' button");
		emergencyContactPage.clickToAddEmergencyButton();

		log.info("Emergency_Detail - Step 03: Input to Name textbox with name is: " + emergencyName);
		emergencyContactPage.inputToEmergencyNameTextbox("Name", emergencyName);

		log.info("Emergency_Detail - Step 04: Input to Relationship textbox with value is: " + relationship);
		emergencyContactPage.inputToEmergencyNameTextbox("Relationship", relationship);

		log.info("Emergency_Detail - Step 05: Input to Home telephone textbox with value is: " + homeTelephoneNumber);
		emergencyContactPage.inputToEmergencyNameTextbox("Home Telephone", homeTelephoneNumber);

		log.info("Emergency_Detail - Step 06: Input to Mobile phone textbox with value is: " + mobilePhoneNumber);
		emergencyContactPage.inputToEmergencyNameTextbox("Mobile", mobilePhoneNumber);

		log.info("Emergency_Detail - Step 07: Input to Work telephone textbox with value is: " + workTelephoneNumber);
		emergencyContactPage.inputToEmergencyNameTextbox("Work Telephone", workTelephoneNumber);

		log.info("Emergency_Detail - Step 08: Click on Save button");
		emergencyContactPage.clickToSaveEmergenctDetailButton();

		log.info(
				"Emergency_Detail - Step 09: Verify success saved Emergency detail info message displayed with text 'Successfully Saved'");
		verifyTrue(emergencyContactPage.isSaveEmergencyDetailMessageDisplayed());
	}

	@Test
	public void Employee_06_Assigned_Dependents() {
		log.info("Assigned_Dependents - Step 01: Open Dependents page");
		emergencyContactPage.openPageAtEmployeeDetailByPageName(driver, "Dependents");
		dependentPage = PageGeneratorManagerOrangeHRM.getDepentdentPage(driver);

		log.info("Assigned_Dependents - Step 02: Click on Add dependent button");
		dependentPage.clickToAddDependentButton();

		log.info("Assigned_Dependents - Step 03: Input to Dependent Name textbox with value is: " + dependentName);
		dependentPage.inputToDependentNameTextbox(dependentName);

		log.info("Assigned_Dependents - Step 04: Select Dependent Relationship in dropdown list with value is: "
				+ dependentRelationship);
		dependentPage.selectRelationshipOptionInDropdownList(dependentRelationship);

		log.info("Assigned_Dependents - Step 05: Input to Dependent DOB with value is " + dependentDOB);
		dependentPage.inputToDependentDOBTextbox(dependentDOB);

		log.info("Assigned_Dependents - Step 06: Click on Save button");
		dependentPage.clickToSaveDependentButton();

		log.info(
				"Assigned_Dependents - Step 07: Verify success added dependent massge displayed with value is 'Successfully Saved'");
		verifyTrue(dependentPage.isSuccessAddedDependentMessageDisplayed());
	}

	@Test
	public void Employee_07_Edit_View_Job() {
		log.info("Edit_View_Job - Step 01: Open Job page");
		dependentPage.openPageAtEmployeeDetailByPageName(driver, "Job");
		jobPage = PageGeneratorManagerOrangeHRM.getJobPage(driver);

		log.info("Edit_View_Job - Step 02: Input to Joined Date textbox with value is: " + joinedDate);
		jobPage.inputToJoinedDateTextbox(joinedDate);

		log.info("Edit_View_Job - Step 03: Select Job title in dropdown list with value is: " + jobTitle);
		jobPage.selectOptionInDropdownListByLabel("Job Title", jobTitle);

		log.info("Edit_View_Job - Step 04: Select Job Category in dropdown list with value is: " + jobCategory);
		jobPage.selectOptionInDropdownListByLabel("Job Category", jobCategory);

		log.info("Edit_View_Job - Step 05: Select Job Sub Unit in dropdown list with value is: " + jobSubUnit);
		jobPage.selectOptionInDropdownListByLabel("Sub Unit", jobSubUnit);

		log.info("Edit_View_Job - Step 06: Select Job status in dropdown list with value is: " + jobStatus);
		jobPage.selectOptionInDropdownListByLabel("Employment Status", jobStatus);

		log.info("Edit_View_Job - Step 07: Select Job location in dropdown list with value is: " + jobLocation);
		jobPage.selectOptionInDropdownListByLabel("Location", jobLocation);

		log.info("Edit_View_Job - Step 08: Click on Save button");
		jobPage.clickToSaveJobButton();

		log.info("Edit_View_Job - Step 09: Verify success added job message displayed with text 'Successfully Saved'");
		verifyTrue(jobPage.isSuccessAddedJobMessageDisplayed());

	}

	@Test
	public void Employee_08_Edit_View_Salary() throws InterruptedException {
		log.info("Edit_View_Salary - Step 01: Open Salary page");
		jobPage.openPageAtEmployeeDetailByPageName(driver, "Salary");
		salaryPage = PageGeneratorManagerOrangeHRM.getSalaryPage(driver);

		log.info("Edit_View_Salary - Step 02: Click on Add button");
		salaryPage.clickToAddSalaryButton();

		log.info("Edit_View_Salary - Step 03: Input to Salary component textbox with value is: " + salaryComponent);
		salaryPage.inputToSalaryTextboxByLabel("Salary Component", salaryComponent);

		log.info("Edit_View_Salary - Step 04: Input to Salary Amount textbox with value is: " + salaryAmount);
		salaryPage.inputToSalaryTextboxByLabel("Amount", salaryAmount);

		log.info("Edit_View_Salary - Step 05: Select Pay Grade option in dropdown list with value is: " + payGrade);
		salaryPage.selectOptionInDropdownListInSalaryByLabel("Pay Grade", payGrade);

		log.info("Edit_View_Salary - Step 06: Select Pay Frequency option in dropdown list with value is: "
				+ payFrequency);
		Thread.sleep(3000);
		salaryPage.selectOptionInDropdownListInSalaryByLabel("Pay Frequency", payFrequency);

		log.info("Edit_View_Salary - Step 07: Select currency option in dropdown list with value is: " + currency);
		salaryPage.selectOptionInDropdownListInSalaryByLabel("Currency", currency);

		log.info("Edit_View_Salary - Step 08: Click on Save salary button");
		salaryPage.clickToSaveCurrencyButton();

		log.info(
				"Edit_View_Salary - Step 09: Verify success added salary message displayed with text 'Successfully Saved");
		verifyTrue(salaryPage.isSuccessAddedSalaryMessageDisplayed());
	}

	/*
	 * @Test public void Employee_09_Edit_View_Tax() {
	 * log.info("Edit_View_Tax - Step 01: Open Tax page");
	 * salaryPage.openPageAtEmployeeDetailByPageName(driver, "Tax Exemptions");
	 * taxPage = PageGeneratorManagerOrangeHRM.getTaxPage(driver);
	 * 
	 * log.
	 * info("Edit_View_Tax - Step 02: Select Status for Ferderal Tax Income with value is: "
	 * + ferderalTaxStatus);
	 * taxPage.selectFerderalTaxStatusInDropdownList(ferderalTaxStatus);
	 * 
	 * log.
	 * info("Edit_View_Tax - Step 03: Input to Exemptions textbox for Ferderal Tax Income with value is: "
	 * + ferderalTaxExemption);
	 * taxPage.inputToFerderalTaxExemptionTextbox(ferderalTaxExemption);
	 * 
	 * log.
	 * info("Edit_View_Tax - Step 04: Select State for State Tax Income with value is: "
	 * + stateTaxState); taxPage.selectStateTaxOptionInDropdownListByLabel("State",
	 * stateTaxState);
	 * 
	 * log.
	 * info("Edit_View_Tax - Step 05: Select Status for State Tax Income with value is: "
	 * + stateTaxStatus);
	 * taxPage.selectStateTaxOptionInDropdownListByLabel("Status", stateTaxStatus);
	 * 
	 * log.
	 * info("Edit_View_Tax - Step 06: Select Unemployment State for State Tax Income with value is: "
	 * + stateTaxUnemploymentState);
	 * taxPage.selectStateTaxOptionInDropdownListByLabel("Unemployment State",
	 * stateTaxUnemploymentState);
	 * 
	 * log.
	 * info("Edit_View_Tax - Step 06: Select Work State for State Tax Income with value is: "
	 * + stateTaxWorkState);
	 * taxPage.selectStateTaxOptionInDropdownListByLabel("Work State",
	 * stateTaxWorkState);
	 * 
	 * log.
	 * info("Edit_View_Tax - Step 07: Input to Exemptions textbox for State Tax Income with value is: "
	 * + stateTaxExemption);
	 * taxPage.inputToStateTaxExemptionTextbox(stateTaxExemption);
	 * 
	 * log.info("Edit_View_Tax - Step 08: Click on Save tax button");
	 * taxPage.clickToSaveTaxButton();
	 * 
	 * log.
	 * info("Edit_View_Tax - Step 09: Verify success added tax message displayed is 'Successfully Updated'"
	 * ); verifyTrue(taxPage.isSuccessAddedTaxMessageDisplayed());
	 * 
	 * }
	 */
	@Test
	public void Employee_10_Qualifications() {
		log.info("Qualifications - Step 01: Open Qualifications page");
		salaryPage.openPageAtEmployeeDetailByPageName(driver, "Qualifications");
		qualificationPage = PageGeneratorManagerOrangeHRM.getQualificationPage(driver);

		log.info("Qualifications - Step 02: Click on Add Work Experience button");
		qualificationPage.clickToAddButtonByLabel("Work Experience");

		log.info("Qualifications - Step 03: Input to Company textbox with value is: " + oldCompanyName);
		qualificationPage.inputToQualificationTextboxByLabel("Company", oldCompanyName);

		log.info("Qualifications - Step 04: Input to Job Title textbox with value is: " + oldJobTitle);
		qualificationPage.inputToQualificationTextboxByLabel("Job Title", oldJobTitle);

		log.info("Qualifications - Step 05: Input to Date From textbox with value is: " + dateForm);
		qualificationPage.inputToQualificationTextboxByLabel("From", dateForm);

		log.info("Qualifications - Step 06: Input to Date To textbox with value is: " + dateTo);
		qualificationPage.inputToQualificationTextboxByLabel("To", dateTo);

		log.info("Qualifications - Step 07: Click on Save buton");
		qualificationPage.clickToSaveButton();

		log.info(
				"Qualifications - Step 08: Verify success added work experience message dispayed with text 'Successfully Saved'");
		verifyTrue(qualificationPage.isSuccessAddedWorkExperienceMessageDisplayed());

		log.info("Qualifications - Step 09: Verify Company name is displayed correctly after created with value is: "
				+ oldCompanyName);
		verifyTrue(qualificationPage.isValueOfCreatedQualificationByLabelAndIndexCorrect("Work Experience", "Company",
				"1", oldCompanyName));

		log.info("Qualifications - Step 10: Verify Job Title name is displayed correctly after created with value is: "
				+ jobTitle);
		verifyTrue(qualificationPage.isValueOfCreatedQualificationByLabelAndIndexCorrect("Work Experience", "Job Title",
				"1", jobTitle));

		log.info("Qualifications - Step 11: Verify Date From is displayed correctly after created with value is: "
				+ dateForm);
		verifyTrue(qualificationPage.isValueOfCreatedQualificationByLabelAndIndexCorrect("Work Experience", "From", "1",
				dateForm));

		log.info("Qualifications - Step 12: Verify Date To is displayed correctly after created with value is: "
				+ dateTo);
		verifyTrue(qualificationPage.isValueOfCreatedQualificationByLabelAndIndexCorrect("Work Experience", "To", "1",
				dateTo));

	}

	@Test
	public void Employee_11_Search_Employee() {
		log.info("Search_Employee - Step 01: Open Employee list page");
		qualificationPage.openTabOnPIMPageByName(driver, "Employee List");
		pimEmployeeListPage = PageGeneratorManagerOrangeHRM.getPIMEmployeeListPage(driver);

		log.info("Search_Employee - Step 02: Input to Employee Name textbox with value is: " + firstName);
		pimEmployeeListPage.inputToTextboxOnSearchPageByName("Employee Name", firstName);

		log.info(
				"Search_Employee - Step 03: Select auto suggest result displayed afetr input value to Employee name textbox");
		pimEmployeeListPage.selectSuggestEmployeeFullName();

		// log.info("Search_Employee - Step 03: Input to Employee ID textbox with value
		// is: " + employeeID);
		// pimEmployeeListPage.inputToTextboxOnSearchPageByName("Employee Id",
		// employeeID);

		// log.info("Search_Employee - Step 04: Select job title in dropdown list with
		// value is: " + jobTitle);
		// pimEmployeeListPage.selectOptionInDropdownListByName("Job Title", jobTitle);

		log.info("Search_Employee - Step 05: Click on Search button");
		pimEmployeeListPage.clickToSearchButton();

		log.info("Search_Employee - Step 06: Verify searched employee displayed that matched search conditions: "
				+ lastName);
		verifyTrue(pimEmployeeListPage.isSearchedEmployeeMatchedSearchCondition("Last Name", "1", lastName));

		log.info("Search_Employee - Step 07: Verify searched employee displayed that matched search conditions: "
				+ jobTitle);
		verifyTrue(pimEmployeeListPage.isSearchedEmployeeMatchedSearchCondition("Job Title", "1", jobTitle));

		log.info("Search_Employee - Step 08: Verify searched employee displayed that matched search conditions: "
				+ employeeID);
		//verifyTrue(pimEmployeeListPage.isSearchedEmployeeMatchedSearchCondition("Id", "1", employeeID));

	}

	 @AfterTest(alwaysRun = true)
	 public void afterClass() { driver.quit(); }

	String stateTaxExemption = "20", ferderalTaxExemption = "50", ferderalTaxStatus = "Married",
			stateTaxState = "American Samoa", stateTaxStatus = "Single",
			stateTaxUnemploymentState = "Armed Forces Africa", stateTaxWorkState = "American Samoa";
	String oldCompanyName = "ACB", oldJobTitle = "QA Lead", dateForm = "2021-12-15", dateTo = "2022-10-15";
}