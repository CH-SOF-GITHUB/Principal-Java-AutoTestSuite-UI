package OrangeHRM.PageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VacancyPage {
    WebDriver driver;

    public VacancyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // définir les web elements de la page vacancy
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    public WebElement VacancyNameInput;
    // select job title
    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
    public WebElement JobSelectIcon;
    //@FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Account Assistant')]")
    //WebElement AccountAssistantOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Automaton Tester')]")
    WebElement AutomatonTesterOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Chief Executive Officer')]")
    WebElement ChiefExecutiveOfficerOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Chief Financial Officer')]")
    WebElement ChiefFinancialOfficerOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Chief Technical Officer')]")
    WebElement ChiefTechnicalOfficerOption;
    // Description
    @FindBy(xpath = "//textarea[@placeholder=\"Type description here\"]")
    WebElement DescriptionInput;
    // Hiring Manager
    @FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
    WebElement HiringManagerInput;
    // Number of positions
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    WebElement NumberPositionsInput;
    // error msg already exists
    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[1]")
    WebElement ErrorMessage;
    // lien Recruitement
    @FindBy(linkText = "Recruitment")
    WebElement RecruitmentLink;
    // lien Vacancies
    @FindBy(linkText = "Vacancies")
    WebElement VacanciesLink;
    // Span Edit Vacancy
    @FindBy(xpath = "//h6[normalize-space()='Edit Vacancy']")
    WebElement EditVacancySpan;
    // button none
    @FindBy(xpath = "//button[@role='none']")
    WebElement BtnNone;

    // définir les méthodes des actions des web elements
    public void ClickBtnNone() {
        BtnNone.click();
    }

    public WebElement GetEditVacancySpan() {
        return EditVacancySpan;
    }

    public void ClickVacanciesLink() throws InterruptedException {
        VacanciesLink.click();
        Thread.sleep(1000);
    }

    public void SaisirNumberPositions(String number) throws InterruptedException {
        List<WebElement> errorMsg = driver.findElements(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[1]"));
        if (!errorMsg.isEmpty() && errorMsg.get(0).getText().equals("Already exists")) {
            NumberPositionsInput = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
        } else {
            NumberPositionsInput = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]"));
        }
        NumberPositionsInput.sendKeys(String.valueOf(number));
        Thread.sleep(2000);
    }

    public void SaisirDescription(String description) throws InterruptedException {
        DescriptionInput.sendKeys(description);
        Thread.sleep(2000);
    }

    public void SaisirHiringManager(String manager) throws InterruptedException {
        HiringManagerInput.sendKeys(manager);
        Thread.sleep(2000);
        HiringManagerInput.sendKeys(Keys.ARROW_DOWN);
        HiringManagerInput.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    public void SelectionJobTitle(String jobTitle) throws InterruptedException {
        JobSelectIcon.click();
        Thread.sleep(2000);
        //String AccountAssistant = AccountAssistantOption.getText();
        String AutomatonTester = AutomatonTesterOption.getText();
        String ChiefExecutiveOfficer = ChiefExecutiveOfficerOption.getText();
        String ChiefFinancialOfficer = ChiefFinancialOfficerOption.getText();
        String ChiefTechnicalOfficer = ChiefTechnicalOfficerOption.getText();
        /*if (AccountAssistant.equals(jobTitle)) {
            AccountAssistantOption.click();
            Thread.sleep(2000);
        } else*/
        if (AutomatonTester.equals(jobTitle)) {
            AutomatonTesterOption.click();
            Thread.sleep(2000);
        } else if (ChiefExecutiveOfficer.equals(jobTitle)) {
            ChiefExecutiveOfficerOption.click();
            Thread.sleep(2000);
        } else if (ChiefFinancialOfficer.equals(jobTitle)) {
            ChiefFinancialOfficerOption.click();
            Thread.sleep(2000);
        } else if (ChiefTechnicalOfficer.equals(jobTitle)) {
            ChiefTechnicalOfficerOption.click();
            Thread.sleep(2000);
        } else {
            System.out.println("Job Title Not Found");
        }
    }

    public void ClickRecruitmentLink() throws InterruptedException {
        RecruitmentLink.click();
        Thread.sleep(1000);
    }

    public void SaisirVacancyName(String name) throws InterruptedException {
        VacancyNameInput.sendKeys(name);
        Thread.sleep(2000);
    }
}
