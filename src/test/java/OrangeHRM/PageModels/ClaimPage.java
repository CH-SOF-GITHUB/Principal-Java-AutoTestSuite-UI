package OrangeHRM.PageModels;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClaimPage {
    // définir le web driver
    WebDriver driver;

    // constructeur initialisation des web elements
    public ClaimPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // définir les web elements de la page claim
    @FindBy(linkText = "Claim")
    WebElement claimLink;
    @FindBy(xpath = "//button[normalize-space()='Assign Claim']")
    public WebElement assignClaimButton;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement EmployeeNameInput;
    // Debut options Event Field
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
    WebElement EventSelectIcon;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Accommodation')]")
    WebElement AccommodationOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Medical Reimbursement')]")
    WebElement MedicalReimbursementOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Travel Allowance')]")
    WebElement TravelAllowanceOption;
    // Fin options Event Field
    // Debut options Currency Field
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
    WebElement CurrencySelectIcon;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Afghanistan Afghani')]")
    WebElement AfghanistanAfghaniOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Albanian Lek')]")
    WebElement AlbanianLekOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Algerian Dinar')]")
    WebElement AlgerianDinarOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Angolan New Kwanza')]")
    WebElement AngolanNewKwanzaOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Bahraini Dinar')]")
    WebElement BahrainiDinarOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'Danish Krona')]")
    WebElement DanishKronaOption;
    @FindBy(xpath = "//div[@role='listbox']//span[contains(text(),'United States Dollar')]")
    WebElement UnitedStatesDollarOption;
    // Fin options Currency Field
    // Remarks
    @FindBy(className = "oxd-textarea--resize-vertical")
    WebElement RemarksInput;

    // Submit Button
    @FindBy(xpath = "//button[normalize-space()='Create']")
    public WebElement createButton;

    // définir les méthodes des actions des web elements
    public void SaisirRemarks(String remarks) throws InterruptedException {
        RemarksInput.sendKeys(remarks);
        Thread.sleep(2000);
    }

    public void SelectCurrency(String currency) throws InterruptedException {
        CurrencySelectIcon.click();
        Thread.sleep(2000);
        String AfghanistanAfghani = AfghanistanAfghaniOption.getText();
        String AlbanianLek = AlbanianLekOption.getText();
        String AlgerianDinar = AlgerianDinarOption.getText();
        String AngolanNewKwanza = AngolanNewKwanzaOption.getText();
        String BahrainiDinar = BahrainiDinarOption.getText();
        String DanishKrona = DanishKronaOption.getText();
        String UnitedStatesDollar = UnitedStatesDollarOption.getText();
        if (AfghanistanAfghani.equals(currency)) {
            AfghanistanAfghaniOption.click();
            Thread.sleep(2000);
        } else if (AlbanianLek.equals(currency)) {
            AlbanianLekOption.click();
            Thread.sleep(2000);
        } else if (AlgerianDinar.equals(currency)) {
            AlgerianDinarOption.click();
            Thread.sleep(2000);
        } else if (AngolanNewKwanza.equals(currency)) {
            AngolanNewKwanzaOption.click();
            Thread.sleep(2000);
        } else if (BahrainiDinar.equals(currency)) {
            BahrainiDinarOption.click();
            Thread.sleep(2000);
        } else if (DanishKrona.equals(currency)) {
            DanishKronaOption.click();
            Thread.sleep(2000);
        } else if (UnitedStatesDollar.equals(currency)) {
            UnitedStatesDollarOption.click();
            Thread.sleep(2000);
        } else {
            System.out.println("Invalid currency");
        }
    }

    public void SelectEvent(String event) throws InterruptedException {
        EventSelectIcon.click();
        Thread.sleep(2000);
        String Accommodation = AccommodationOption.getText();
        String MedicalReimbursement = MedicalReimbursementOption.getText();
        String TravelAllowance = TravelAllowanceOption.getText();
        if (Accommodation.equals(event)) {
            AccommodationOption.click();
            Thread.sleep(2000);
        } else if (MedicalReimbursement.equals(event)) {
            MedicalReimbursementOption.click();
            Thread.sleep(2000);
        } else if (TravelAllowance.equals(event)) {
            TravelAllowanceOption.click();
            Thread.sleep(2000);
        } else {
            System.out.println("Invalid Event");
        }
    }

    public void SaisirEmployeeName(String name) throws InterruptedException {
        EmployeeNameInput.sendKeys(name);
        Thread.sleep(2000);
        EmployeeNameInput.sendKeys(Keys.ARROW_DOWN);
        EmployeeNameInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    public void ClickClaimLink() throws InterruptedException {
        claimLink.click();
        Thread.sleep(1000);
    }

    public void ClickAssignClaimButton() throws InterruptedException {
        assignClaimButton.click();
        Thread.sleep(1000);
    }

    public void ClickCreateButton() throws InterruptedException {
        createButton.click();
        Thread.sleep(2000);
    }
}
