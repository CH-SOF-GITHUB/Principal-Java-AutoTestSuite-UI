package OrangeHRM.PageModels;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage {
    // définir le web driver
    WebDriver driver;

    // constructeur initialisation des web elements
    public PIMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // définir les web elements de la page PIM
    @FindBy(linkText = "PIM")
    WebElement PimLink;
    @FindBy(className = "bi-plus")
    WebElement PlusButton;
    @FindBy(name = "firstName")
    WebElement EmpFirstNameInput;
    @FindBy(name = "middleName")
    WebElement EmpMiddleNameInput;
    @FindBy(name = "lastName")
    WebElement EmpLastNameInput;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement EmpIdInput;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")
    WebElement ClickCLDCheckbox;
    @FindBy(xpath = "(//input[@autocomplete='off'])[1]")
    WebElement EmpUsernameInput;
    //@FindBy(xpath = "(//input[@value='1'])[1]")
    //WebElement EnabledOption;
    @FindBy(xpath = "//label[normalize-space()='Enabled']")
    WebElement LabelEnabled;
    //@FindBy(xpath = "(//input[@value='2'])[1]")
    //WebElement DisabledOption;
    @FindBy(xpath = "//label[normalize-space()='Disabled']")
    WebElement LabelDisabled;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement EmpPasswordInput;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement EmpConfirmPwdInput;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement SaveButton;

    // Web element upload photo
    @FindBy(className = "employee-image-action")
    WebElement AddImageButton;
    @FindBy(xpath = "//input[@type=\"file\"]")
    WebElement FileInput;
    // Web elements de la page Add Reports
    @FindBy(linkText = "Reports")
    WebElement ReportsLink;
    // Report Name
    @FindBy(xpath = "//input[@placeholder=\"Type here ...\"]")
    WebElement ReportNameInput;
    // Selection Criteria: Selection Criteria
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
    WebElement SelectCriteriaIcon;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(), 'Employee Name')]")
    WebElement EmployeeNameOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Pay Grade')]")
    WebElement PayGradeOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Education')]")
    WebElement EducationOption1;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Employment Status')]")
    WebElement EmploymentStatusOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Service Period')]")
    WebElement ServicePeriodOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Joined Date')]")
    WebElement JoinedDateOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Job Title')]")
    WebElement JobTitleOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Language')]")
    WebElement LanguageOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Skill')]")
    WebElement SkillOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Age Group')]")
    WebElement AgeGroupOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Sub Unit')]")
    WebElement SubUnitOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Gender')]")
    WebElement GenderOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Location')]")
    WebElement LocationOption;
    @FindBy(xpath = "(//button[@type='button'])[4]")
    WebElement BtnAddCriteria;
    // Selection Criteria: Include
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
    WebElement SelectIncludeIcon;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Current Employees Only')]")
    WebElement CurrentEmployeeOnlyOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Current and Past Employees')]")
    WebElement CurrentAndPastEmployeesOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Past Employees Only')]")
    WebElement PastEmployeeOnlyOption;
    // Display Fields: Select Display Field Group
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[4]")
    WebElement SelectDisplayFieldGroupIcon4;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Personal')]")
    WebElement PersonalOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Contact Details')]")
    WebElement ContactDetailsOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Emergency Contacts')]")
    WebElement EmergencyContactsOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Dependents')]")
    WebElement DependentsOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Immigration')]")
    WebElement ImmigrationOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Job')]")
    WebElement JobOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Salary')]")
    WebElement SalaryOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Subordinates')]")
    WebElement SubordinatesOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Supervisors')]")
    WebElement SupervisorsOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Work Experience')]")
    WebElement WorkExperienceOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Education')]")
    WebElement EducationOption2;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Skills')]")
    WebElement SkillsOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Languages')]")
    WebElement LanguagesOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'License')]")
    WebElement LicenseOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Memberships')]")
    WebElement MembershipsOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Custom Fields')]")
    WebElement CustomFieldsOption;
    // Display Fields: Select Display Field
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[5]")
    WebElement SelectDisplayFieldIcon5;
    // if Display Field Group: Personal
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Employee Id')]")
    WebElement EmployeeIdOption;  // Personal: Employee Id
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Employee Last Name')]")
    WebElement EmployeeLastNameOption; // Personal: Employee Last Name
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Employee First Name')]")
    WebElement EmployeeFirstNameOption; // Personal: Employee First Name
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Date of Birth')]")
    WebElement DateOfBirthOption; // Personal: Date of Birth
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Marital Status')]")
    WebElement MaritalStatusOption; // Personal: Marital Status
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Address')]")
    WebElement AddressOption; // Contact Details
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Home Telephone')]")
    WebElement HomeTelephoneOption; // Contact Details
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Mobile')]")
    WebElement MobileOption; // Contact Details
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Work Telephone')]")
    WebElement WorkTelephoneOption; // Emergency Contacts
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Relationship')]")
    WebElement RelationshipOption; // Dependents
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Eligibility Status')]")
    WebElement EligibilityStatusOption; // Immigration
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Contract Start Date')]")
    WebElement ContractStartDateOption; // Job
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Salary Component')]")
    WebElement SalaryComponentOption; // Salary
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'First Name')]")
    WebElement FirstNameOption; // Subordinates
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Reporting Method')]")
    WebElement ReportingMethodOption; // Supervisors
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Company')]")
    WebElement CompanyOption; // Work Experience
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Subscription Paid By')]")
    WebElement SubscriptionPaidByOption; // Memberships
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Blood Type')]")
    WebElement BloodTypeOption; // Custom Fields
    // le bouton + add display field
    @FindBy(xpath = "(//button[@type='button'])[6]")
    WebElement BtnAddsDisplayField;
    // include Header
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[5]/div/label/span")
    WebElement CheckboxHeader;
    /* déclaration des web elements and Selection Criteria with his field*/
    @FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
    WebElement EmployeeNameInput;
    // Criteria Pay Grade options
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[3]")
    WebElement CriteriaOptionSelectIcon;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Grade 1')]")
    WebElement Grade1Option;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Grade 2')]")
    WebElement Grade2Option;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Grade 3')]")
    WebElement Grade3Option;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Grade 4')]")
    WebElement Grade4Option;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Grade 5')]")
    WebElement Grade5Option;
    // Criteria Education options
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),\"Bachelor's Degree\")]")
    WebElement BachelorDegreeOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'College Undergraduate')]")
    WebElement CollegeUndergraduateOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'High School Diploma')]")
    WebElement HighSchoolDiplomaOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),\"Master's Degree\")]")
    WebElement MasterDegreeOption;
    // Criteria Employment Status options
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Freelance')]")
    WebElement FreelanceOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Full-Time Contract')]")
    WebElement FullTimeContractOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Full-Time Permanent')]")
    WebElement FullTimePermanentOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Full-Time Probation')]")
    WebElement FullTimeProbationOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Part-Time Contract')]")
    WebElement PartTimeContractOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Part-Time Internship')]")
    WebElement PartTimeInternshipOption;
    // Criteria Service Period options
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Less Than')]")
    WebElement LessThanOption;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    WebElement LessThanInput;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Greater Than')]")
    WebElement GreaterThanOption;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    WebElement GreaterThanInput;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Range')]")
    WebElement RangeOption;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    WebElement RangeFromInput;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[4]")
    WebElement RangeToInput;
    // Criteria Joined Date options
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Joined before')]")
    WebElement JoinedBeforeOption;
    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[1]")
    WebElement JoinedBeforeCalender;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Joined after')]")
    WebElement JoinedAfterOption;
    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[1]")
    WebElement JoinedAfterCalender;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Joined in between')]")
    WebElement JoinedInBetweenOption;
    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[1]")
    WebElement JoinedInBetweenCalender1;
    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[2]")
    WebElement JoinedInBetweenCalender2;
    // Criteria Job Title
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Test Engineer')]")
    WebElement TestEngineerOption;
    // Criteria Language
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Arabic')]")
    WebElement ArabicOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'French')]")
    WebElement FrenchOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'English')]")
    WebElement EnglishOption;
    // Criteria Sub Unit
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'OrangeHRM')]")
    WebElement OrangeHRMOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Administration')]")
    WebElement AdministrationOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Development')]")
    WebElement DevelopmentOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Quality Assurance')]")
    WebElement QualityAssuranceOption;
    // Criteria Gender
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Male')]")
    WebElement MaleOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Female')]")
    WebElement FemaleOption;
    // Criteria Location
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'HQ - CA, USA')]")
    WebElement HQCAUSAOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'New York Sales Office')]")
    WebElement NewYorkSalesOfficeOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Texas R&D')]")
    WebElement TexasRDOption;

    // définir les méthodes des actions des web elements
    public void SelectionCriteriaWithField(String criteria, String field, String criteriaEmpName, String Less, String Greater, String RangeFrom, String RangeTo, String JoinedBeforeDate, String JoinedAfterDate, String JoinedInBetween1, String JoinedInBetween2) throws InterruptedException {
        SelectCriteriaIcon.click();
        Thread.sleep(2000);
        String EmployeeName = EmployeeNameOption.getText();
        String PayGrade = PayGradeOption.getText();
        String Education1 = EducationOption1.getText();
        String EmploymentStatus = EmploymentStatusOption.getText();
        String ServicePeriod = ServicePeriodOption.getText();
        String JoinedDate = JoinedDateOption.getText();
        String JobTitle = JobTitleOption.getText();
        String Language = LanguageOption.getText();
        String Skill = SkillOption.getText();
        String AgeGroup = AgeGroupOption.getText();
        String SubUnit = SubUnitOption.getText();
        String Gender = GenderOption.getText();
        String Location = LocationOption.getText();
        if (EmployeeName.equals(criteria)) {
            EmployeeNameOption.click();
            Thread.sleep(2000);
        } else if (PayGrade.equals(criteria)) {
            PayGradeOption.click();
            Thread.sleep(2000);
        } else if (Location.equals(criteria)) {
            LocationOption.click();
            Thread.sleep(2000);
        } else if (Gender.equals(criteria)) {
            GenderOption.click();
            Thread.sleep(2000);
        } else if (SubUnit.equals(criteria)) {
            SubUnitOption.click();
            Thread.sleep(2000);
        } else if (AgeGroup.equals(criteria)) {
            AgeGroupOption.click();
            Thread.sleep(2000);
        } else if (Skill.equals(criteria)) {
            SkillOption.click();
            Thread.sleep(2000);
        } else if (Language.equals(criteria)) {
            LanguageOption.click();
            Thread.sleep(2000);
        } else if (JobTitle.equals(criteria)) {
            JobTitleOption.click();
            Thread.sleep(2000);
        } else if (JoinedDate.equals(criteria)) {
            JoinedDateOption.click();
            Thread.sleep(2000);
        } else if (ServicePeriod.equals(criteria)) {
            ServicePeriodOption.click();
            Thread.sleep(2000);
        } else if (Education1.equals(criteria)) {
            EducationOption1.click();
            Thread.sleep(2000);
        } else if (EmploymentStatus.equals(criteria)) {
            EmploymentStatusOption.click();
            Thread.sleep(2000);
        } else {
            System.out.println("Error: No criteria Found");
        }
        BtnAddCriteria.click();
        Thread.sleep(2000);
        // saisir ou select criteria field
        if (criteria.equals("")) {
            SelectDisplayFieldGroupIcon4 = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[3]"));
            SelectDisplayFieldIcon5 = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[4]"));
            BtnAddsDisplayField = driver.findElement(By.xpath("(//button[@type='button'])[5]"));
        }
        if (criteria.equals("Employee Name")) {
            EmployeeNameInput.sendKeys(criteriaEmpName);
            Thread.sleep(2000);
            EmployeeNameInput.sendKeys(Keys.ARROW_DOWN);
            EmployeeNameInput.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            SelectDisplayFieldGroupIcon4 = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[3]"));
            SelectDisplayFieldIcon5 = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[4]"));
            Thread.sleep(2000);
        } else if (criteria.equals("Pay Grade")) {
            CriteriaOptionSelectIcon.click();
            Thread.sleep(2000);
            String Grade1 = Grade1Option.getText();
            String Grade2 = Grade2Option.getText();
            String Grade3 = Grade3Option.getText();
            String Grade4 = Grade4Option.getText();
            String Grade5 = Grade5Option.getText();
            if (Grade1.equals(field)) {
                Grade1Option.click();
                Thread.sleep(2000);
            }
            if (Grade2.equals(field)) {
                Grade2Option.click();
                Thread.sleep(2000);
            }
            if (Grade3.equals(field)) {
                Grade3Option.click();
                Thread.sleep(2000);
            }
            if (Grade4.equals(field)) {
                Grade4Option.click();
                Thread.sleep(2000);
            }
            if (Grade5.equals(field)) {
                Grade5Option.click();
                Thread.sleep(2000);
            }
        } else if (criteria.equals("Education")) {
            CriteriaOptionSelectIcon.click();
            Thread.sleep(2000);
            String BachelorDegree = BachelorDegreeOption.getText();
            String CollegeUndergraduate = CollegeUndergraduateOption.getText();
            String HighSchoolDiploma = HighSchoolDiplomaOption.getText();
            String MasterDegree = MasterDegreeOption.getText();
            if (BachelorDegree.equals(field)) {
                BachelorDegreeOption.click();
                Thread.sleep(2000);
            }
            if (CollegeUndergraduate.equals(field)) {
                CollegeUndergraduateOption.click();
                Thread.sleep(2000);
            }
            if (HighSchoolDiploma.equals(field)) {
                HighSchoolDiplomaOption.click();
                Thread.sleep(2000);
            }
            if (MasterDegree.equals(field)) {
                MasterDegreeOption.click();
                Thread.sleep(2000);
            }
        } else if (criteria.equals("Employment Status")) {
            CriteriaOptionSelectIcon.click();
            Thread.sleep(2000);
            String Freelance = FreelanceOption.getText();
            String FullTimeContract = FullTimeContractOption.getText();
            String FullTimePermanent = FullTimePermanentOption.getText();
            String FullTimeProbation = FullTimeProbationOption.getText();
            String PartTimeContract = PartTimeContractOption.getText();
            String PartTimeInternship = PartTimeInternshipOption.getText();
            if (Freelance.equals(field)) {
                FreelanceOption.click();
                Thread.sleep(2000);
            }
            if (FullTimeContract.equals(field)) {
                FullTimeContractOption.click();
                Thread.sleep(2000);
            }
            if (FullTimePermanent.equals(field)) {
                FullTimePermanentOption.click();
                Thread.sleep(2000);
            }
            if (FullTimeProbation.equals(field)) {
                FullTimeProbationOption.click();
                Thread.sleep(2000);
            }
            if (PartTimeContract.equals(field)) {
                PartTimeContractOption.click();
                Thread.sleep(2000);
            }
            if (PartTimeInternship.equals(field)) {
                PartTimeInternshipOption.click();
                Thread.sleep(2000);
            }
        } else if (criteria.equals("Service Period")) {
            CriteriaOptionSelectIcon.click();
            Thread.sleep(2000);
            String LessThan = LessThanOption.getText();
            String GreaterThan = GreaterThanOption.getText();
            String Range = RangeOption.getText();
            if (LessThan.equals(field)) {
                LessThanOption.click();
                Thread.sleep(2000);
                LessThanInput.sendKeys(Less);
                Thread.sleep(2000);
            }
            if (GreaterThan.equals(field)) {
                GreaterThanOption.click();
                Thread.sleep(2000);
                GreaterThanInput.sendKeys(Greater);
                Thread.sleep(2000);
            }
            if (Range.equals(field)) {
                RangeOption.click();
                Thread.sleep(2000);
                RangeFromInput.sendKeys(RangeFrom);
                Thread.sleep(2000);
                RangeToInput.sendKeys(RangeTo);
                Thread.sleep(2000);
            }
        } else if (criteria.equals("Joined Date")) {
            CriteriaOptionSelectIcon.click();
            Thread.sleep(2000);
            String JoinedBefore = JoinedBeforeOption.getText();
            String JoinedAfter = JoinedAfterOption.getText();
            String JoinedInBetween = JoinedInBetweenOption.getText();
            if (JoinedBefore.equals(field)) {
                JoinedBeforeOption.click();
                Thread.sleep(2000);
                JoinedBeforeCalender.sendKeys(JoinedBeforeDate);
                Thread.sleep(2000);
            }
            if (JoinedAfter.equals(field)) {
                JoinedAfterOption.click();
                Thread.sleep(2000);
                JoinedAfterCalender.sendKeys(JoinedAfterDate);
                Thread.sleep(2000);
            }
            if (JoinedInBetween.equals(field)) {
                JoinedInBetweenOption.click();
                Thread.sleep(2000);
                JoinedInBetweenCalender1.sendKeys(JoinedInBetween1);
                Thread.sleep(2000);
                JoinedInBetweenCalender2.sendKeys(JoinedInBetween2);
            }
        } else if (criteria.equals("Job Title")) {
            CriteriaOptionSelectIcon.click();
            Thread.sleep(2000);
            String TestEngineer = TestEngineerOption.getText();
            if (TestEngineer.equals(field)) {
                TestEngineerOption.click();
                Thread.sleep(2000);
            }
        } else if (criteria.equals("Language")) {
            CriteriaOptionSelectIcon.click();
            Thread.sleep(2000);
            String Arabic = ArabicOption.getText();
            String French = FrenchOption.getText();
            String English = EnglishOption.getText();
            if (Arabic.equals(field)) {
                ArabicOption.click();
                Thread.sleep(2000);
            }
            if (French.equals(field)) {
                FrenchOption.click();
                Thread.sleep(2000);
            }
            if (English.equals(field)) {
                EnglishOption.click();
                Thread.sleep(2000);
            }
        } else if (criteria.equals("Sub Unit")) {
            CriteriaOptionSelectIcon.click();
            Thread.sleep(2000);
            String OrangeHRM = OrangeHRMOption.getText();
            String Administration = AdministrationOption.getText();
            String Development = DevelopmentOption.getText();
            String QualityAssurance = QualityAssuranceOption.getText();
            if (OrangeHRM.equals(field)) {
                OrangeHRMOption.click();
                Thread.sleep(2000);
            }
            if (Administration.equals(field)) {
                AdministrationOption.click();
                Thread.sleep(2000);
            }
            if (Development.equals(field)) {
                DevelopmentOption.click();
                Thread.sleep(2000);
            }
            if (QualityAssurance.equals(field)) {
                QualityAssuranceOption.click();
                Thread.sleep(2000);
            }
        } else if (criteria.equals("Gender")) {
            CriteriaOptionSelectIcon.click();
            Thread.sleep(2000);
            String Male = MaleOption.getText();
            String Female = FemaleOption.getText();
            if (Male.equals(field)) {
                MaleOption.click();
                Thread.sleep(2000);
            }
            if (Female.equals(field)) {
                FemaleOption.click();
                Thread.sleep(2000);
            }
        } else if (criteria.equals("Location")) {
            CriteriaOptionSelectIcon.click();
            Thread.sleep(2000);
            String HQCAUSA = HQCAUSAOption.getText();
            String NewYorkSalesOffice = NewYorkSalesOfficeOption.getText();
            String TexasRD = TexasRDOption.getText();
            if (HQCAUSA.equals(field)) {
                HQCAUSAOption.click();
                Thread.sleep(2000);
            }
            if (NewYorkSalesOffice.equals(field)) {
                NewYorkSalesOfficeOption.click();
                Thread.sleep(2000);
            }
            if (TexasRD.equals(field)) {
                TexasRDOption.click();
                Thread.sleep(2000);
            }
        } else {
            System.out.println("criteria not recognized");
        }
    }

    public void CheckIncludeHeader() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(CheckboxHeader));
        wait.until(ExpectedConditions.elementToBeClickable(CheckboxHeader));
        CheckboxHeader.click();
        Thread.sleep(2000);
    }

    public void ClickBtnAddDisplayField() throws InterruptedException {
        BtnAddsDisplayField.click();
        Thread.sleep(2000);
    }

    public void SelectDisplayFields(String fieldGroup, String field) throws InterruptedException {
        // selection display field group
        SelectDisplayFieldGroupIcon4.click();
        Thread.sleep(1000);
        String Personal = PersonalOption.getText();
        String ContactDetails = ContactDetailsOption.getText();
        String EmergencyContacts = EmergencyContactsOption.getText();
        String Dependents = DependentsOption.getText();
        String Immigration = ImmigrationOption.getText();
        String Job = JobOption.getText();
        String Salary = SalaryOption.getText();
        String Subordinates = SubordinatesOption.getText();
        String Supervisors = SupervisorsOption.getText();
        String WorkExperience = WorkExperienceOption.getText();
        String Education2 = EducationOption2.getText();
        String Skills = SkillsOption.getText();
        String Languages = LanguagesOption.getText();
        String License = LicenseOption.getText();
        String Memberships = MembershipsOption.getText();
        String CustomFields = CustomFieldsOption.getText();
        if (Personal.equals(fieldGroup)) {
            PersonalOption.click();
            Thread.sleep(2000);
        }
        if (ContactDetails.equals(fieldGroup)) {
            ContactDetailsOption.click();
            Thread.sleep(2000);
        }
        if (EmergencyContacts.equals(fieldGroup)) {
            EmergencyContactsOption.click();
            Thread.sleep(2000);
        }
        if (Dependents.equals(fieldGroup)) {
            DependentsOption.click();
            Thread.sleep(2000);
        }
        if (Immigration.equals(fieldGroup)) {
            ImmigrationOption.click();
            Thread.sleep(2000);
        }
        if (Job.equals(fieldGroup)) {
            JobOption.click();
            Thread.sleep(2000);
        }
        if (Salary.equals(fieldGroup)) {
            SalaryOption.click();
            Thread.sleep(2000);
        }
        if (Subordinates.equals(fieldGroup)) {
            SubordinatesOption.click();
            Thread.sleep(2000);
        }
        if (Supervisors.equals(fieldGroup)) {
            SupervisorsOption.click();
            Thread.sleep(2000);
        }
        if (WorkExperience.equals(fieldGroup)) {
            WorkExperienceOption.click();
            Thread.sleep(2000);
        }
        if (Education2.equals(fieldGroup)) {
            EducationOption2.click();
            Thread.sleep(2000);
        }
        if (Skills.equals(fieldGroup)) {
            SkillsOption.click();
            Thread.sleep(2000);
        }
        if (Languages.equals(fieldGroup)) {
            LanguagesOption.click();
            Thread.sleep(2000);
        }
        if (License.equals(fieldGroup)) {
            LicenseOption.click();
            Thread.sleep(2000);
        }
        if (Memberships.equals(fieldGroup)) {
            MembershipsOption.click();
            Thread.sleep(2000);
        }
        if (CustomFields.equals(fieldGroup)) {
            CustomFieldsOption.click();
            Thread.sleep(2000);
        }
        // selection display field
        SelectDisplayFieldIcon5.click();
        Thread.sleep(2000);
        if (fieldGroup.equals("Personal")) {
            String EmployeeId = EmployeeIdOption.getText();
            String EmployeeLastName = EmployeeLastNameOption.getText();
            String EmployeeFirstName = EmployeeFirstNameOption.getText();
            String DateOfBirth = DateOfBirthOption.getText();
            String MaritalStatus = MaritalStatusOption.getText();
            if (EmployeeId.equals(field)) {
                EmployeeIdOption.click();
                Thread.sleep(2000);
            }
            if (EmployeeLastName.equals(field)) {
                EmployeeLastNameOption.click();
                Thread.sleep(2000);
            }
            if (EmployeeFirstName.equals(field)) {
                EmployeeFirstNameOption.click();
                Thread.sleep(2000);
            }
            if (DateOfBirth.equals(field)) {
                DateOfBirthOption.click();
                Thread.sleep(2000);
            }
            if (MaritalStatus.equals(field)) {
                MaritalStatusOption.click();
                Thread.sleep(2000);
            }
        }
        if (fieldGroup.equals("Contact Details")) {
            String Addres = AddressOption.getText();
            String HomeTelephone = HomeTelephoneOption.getText();
            String Mobile = MobileOption.getText();
            if (Addres.equals(field)) {
                AddressOption.click();
                Thread.sleep(2000);
            }
            if (HomeTelephone.equals(field)) {
                HomeTelephoneOption.click();
                Thread.sleep(2000);
            }
            if (Mobile.equals(field)) {
                MobileOption.click();
                Thread.sleep(2000);
            }
        }
        if (fieldGroup.equals("Emergency Contacts")) {
            String WorkTelephone = WorkTelephoneOption.getText();
            if (WorkTelephone.equals(field)) {
                WorkTelephoneOption.click();
                Thread.sleep(2000);
            }
        }
        if (fieldGroup.equals("Dependents")) {
            String Relationship = RelationshipOption.getText();
            if (Relationship.equals(field)) {
                RelationshipOption.click();
                Thread.sleep(2000);
            }
        }
        if (fieldGroup.equals("Immigration")) {
            String EligibilityStatus = EligibilityStatusOption.getText();
            if (EligibilityStatus.equals(field)) {
                EligibilityStatusOption.click();
                Thread.sleep(2000);
            }
        }
        if (fieldGroup.equals("Job")) {
            String ContractStartDate = ContractStartDateOption.getText();
            if (ContractStartDate.equals(field)) {
                ContractStartDateOption.click();
                Thread.sleep(2000);
            }
        }
        if (fieldGroup.equals("Salary")) {
            String SalaryComponent = SalaryComponentOption.getText();
            if (SalaryComponent.equals(field)) {
                SalaryComponentOption.click();
                Thread.sleep(2000);
            }
        }
        if (fieldGroup.equals("Subordinates")) {
            String FirstName = FirstNameOption.getText();
            if (FirstName.equals(field)) {
                FirstNameOption.click();
                Thread.sleep(2000);
            }
        }
        if (fieldGroup.equals("Supervisors")) {
            String ReportingMethod = ReportingMethodOption.getText();
            if (ReportingMethod.equals(field)) {
                ReportingMethodOption.click();
                Thread.sleep(2000);
            }
        }
        if (fieldGroup.equals("Work Experience")) {
            String Company = CompanyOption.getText();
            if (Company.equals(field)) {
                CompanyOption.click();
                Thread.sleep(2000);
            }
        }
        if (fieldGroup.equals("Memberships")) {
            String SubscriptionPaidBy = SubscriptionPaidByOption.getText();
            if (SubscriptionPaidBy.equals(field)) {
                SubscriptionPaidByOption.click();
                Thread.sleep(2000);
            }
        }
        if (fieldGroup.equals("Custom Fields")) {
            String BloodType = BloodTypeOption.getText();
            if (BloodType.equals(field)) {
                BloodTypeOption.click();
                Thread.sleep(2000);
            }
        }
    }

    public void SelectionInclude(String include) throws InterruptedException {
        // scroller
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(2000);
        SelectIncludeIcon.click();
        Thread.sleep(2000);
        if (include.equals("")) {
            SelectDisplayFieldGroupIcon4 = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[3]"));
            SelectDisplayFieldIcon5 = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[4]"));
        }
        String CurrentEmployeeOnly = CurrentEmployeeOnlyOption.getText();
        String CurrentAndPastEmployees = CurrentAndPastEmployeesOption.getText();
        String PastEmployeeOnly = PastEmployeeOnlyOption.getText();
        if (CurrentEmployeeOnly.equals(include)) {
            CurrentEmployeeOnlyOption.click();
            Thread.sleep(2000);
        } else if (CurrentAndPastEmployees.equals(include)) {
            CurrentAndPastEmployeesOption.click();
            Thread.sleep(2000);
        } else if (PastEmployeeOnly.equals(include)) {
            PastEmployeeOnlyOption.click();
            Thread.sleep(2000);
        } else {
            System.out.println("Selection include option not found");
        }
    }

    public void ClickBtnAddCriteria() {
        BtnAddCriteria.click();
    }

    public void SaisirReportName(String name) throws InterruptedException {
        ReportNameInput.sendKeys(name);
        Thread.sleep(2000);
    }

    public void ClickReportsLink() throws InterruptedException {
        ReportsLink.click();
        Thread.sleep(2000);
    }

    // fin méthodes Add Reports
    public WebElement getFileInput() {
        return FileInput;
    }

    public void ClickAddImageButton() {
        AddImageButton.click();
    }

    public void ClickToSave() throws InterruptedException {
        Thread.sleep(3000);
        SaveButton.click();
    }

    public void SaisirEmpPassword(String pwd) {
        EmpPasswordInput.sendKeys(pwd);
    }

    public void SaisirEmpConfirmPwd(String pwd) {
        EmpConfirmPwdInput.sendKeys(pwd);
    }

    public void ClickCreateLoginDetails() throws InterruptedException {
        // scroller vers le bas de la page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0,400)");
        ClickCLDCheckbox.click();
        Thread.sleep(2000);
    }

    public void ClickStatus(String status) throws InterruptedException {
        Thread.sleep(2000);
        if (status.equals("Enabled")) {
            LabelEnabled.click();
        }
        Thread.sleep(2000);
        if (status.equals("Disabled")) {
            LabelDisabled.click();
        }
    }

    public void SaisirEmpUsername(String name) {
        EmpUsernameInput.sendKeys(name);
    }

    public void SaisirEmployeeId(String id) throws InterruptedException {
        EmpIdInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        Thread.sleep(1000);
        WebElement LabelEmployeeId = driver.findElement(By.xpath("//label[normalize-space()='Employee Id']"));
        LabelEmployeeId.click();
        Thread.sleep(2000);
        EmpIdInput.sendKeys(id);
    }

    public static void macCleanHack(WebElement element) {
        String inputText = element.getAttribute("value");
        if (inputText != null) {
            for (int i = 0; i < inputText.length(); i++) {
                element.sendKeys(Keys.BACK_SPACE);
            }
        }

    }

    public void ClickPIMLink() {
        PimLink.click();
    }

    public void ClickPlusButton() {
        PlusButton.click();
    }

    public void SaisirEmpFirstName(String name) {
        EmpFirstNameInput.sendKeys(name);
    }

    public void SaisirEmpMiddleName(String name) {
        EmpMiddleNameInput.sendKeys(name);
    }

    public void SaisirEmpLastName(String name) {
        EmpLastNameInput.sendKeys(name);
    }
}
