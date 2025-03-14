package OrangeHRM.PageModels;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {
    // définir le web driver
    WebDriver driver;

    // constructeur initialisation des web elements
    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // définir les web elements de la page Admin
    @FindBy(linkText = "Admin")
    WebElement adminLink;
    @FindBy(className = "oxd-button-icon")
    WebElement btnAdd;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i")
    WebElement UserRoleSelectIcon;
    @FindBy(xpath = "//div[contains(@class, 'oxd-select-dropdown')]//span[contains(text(), 'Admin')]")
    WebElement AdminOption;
    @FindBy(xpath = "//div[contains(@class, 'oxd-select-dropdown')]//span[contains(text(), 'ESS')]")
    WebElement EssOption;
    @FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
    WebElement EmployeeNameInput;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i")
    WebElement StatusSelectIcon;
    @FindBy(xpath = "//div[contains(@class, 'oxd-select-dropdown')]//span[contains(text(), 'Enabled')]")
    WebElement EnabledOption;
    @FindBy(xpath = "//div[contains(@class, 'oxd-select-dropdown')]//span[contains(text(), 'Disabled')]")
    WebElement DisabledOption;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement UsernameInput;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement PasswordInput;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement ConfirmPasswordInput;
    @FindBy(className = "orangehrm-left-space")
    WebElement BtnSave;
    @FindBy(className = "oxd-button--ghost")
    WebElement BtnCancel;

    // définir les méthodes des actions des web elements
    public void clickBtnSave() {
        BtnSave.click();
    }

    public void clickBtnCancel() {
        BtnCancel.click();
    }

    public void saisirConfirmPassword(String pwd) {
        ConfirmPasswordInput.sendKeys(pwd);
    }

    public void saisirAdminPassword(String pwd) {
        PasswordInput.sendKeys(pwd);
    }

    public void saisirUsername(String username) {
        UsernameInput.sendKeys(username);
    }

    public void selectStatus(String status) throws InterruptedException {
        StatusSelectIcon.click();
        Thread.sleep(2000);
        String Enabled = EnabledOption.getText();
        String Disabled = DisabledOption.getText();
        if (Enabled.equals(status)) {
            EnabledOption.click();
        }
        if (Disabled.equals(status)) {
            DisabledOption.click();
        }
        Thread.sleep(2000);
    }

    public void saisirEmployeeName(String name) throws InterruptedException {
        EmployeeNameInput.sendKeys(name);
        Thread.sleep(5000);
        // Attendre l'apparition des suggestions
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'oxd-autocomplete-option')]")));
        // Utiliser la flèche bas (Arrow Down) et Enter pour sélectionner la première suggestion
        EmployeeNameInput.sendKeys(Keys.ARROW_DOWN);
        EmployeeNameInput.sendKeys(Keys.ENTER);
    }

    public void clickAdminLink() {
        adminLink.click();
    }

    public void clickBtnAdd() {
        btnAdd.click();
    }

    public void selectUserRole(String role) throws InterruptedException {
        // Attendre que le champ du menu déroulant soit cliquable et cliquer dessus
        UserRoleSelectIcon.click();
        Thread.sleep(2000);
        String ESS = EssOption.getText();
        String ADMIN = AdminOption.getText();
        if (ESS.equals(role)) {
            EssOption.click();
        }
        if (ADMIN.equals(role)) {
            AdminOption.click();
        }
        Thread.sleep(2000);
    }
}
