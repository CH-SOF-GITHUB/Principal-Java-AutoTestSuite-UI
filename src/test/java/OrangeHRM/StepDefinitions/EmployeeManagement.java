package OrangeHRM.StepDefinitions;

import OrangeHRM.PageModels.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.HelperClass;

import java.time.Duration;

public class EmployeeManagement {
    // définir un web driver: controle et ouverture d'un navigateur chrome
    // WebDriver driver = new ChromeDriver();
    // définir une instance de classe LoginPage
    LoginPage loginPage = new LoginPage(HelperClass.getDriver());
    // définir une instance de classe Logout
    LogoutPage logoutPage = new LogoutPage(HelperClass.getDriver());
    // définir une instance de classe AdminPage
    AdminPage adminPage = new AdminPage(HelperClass.getDriver());
    // définir une instance de classe PIMPage
    PIMPage pimPage = new PIMPage(HelperClass.getDriver());
    // définir une instance de classe ClaimPage
    ClaimPage claimPage = new ClaimPage(HelperClass.getDriver());
    // définir une instance de classe VacancyPage
    VacancyPage vacancyPage = new VacancyPage(HelperClass.getDriver());

    @Given("je suis sur l'interface login")
    public void je_suis_sur_l_interface_login() {
        HelperClass.openPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //driver.manage().window().maximize();
        // définir l'attente implicite de 10 s avant de lancer une exception
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("je saisie username {string}")
    public void jeSaisieUsername(String name) {
        loginPage.saisirUsername(name);
        System.out.println("je saisie username: " + name);
    }

    @And("je saisie password {string}")
    public void jeSaisiePassword(String pwd) {
        loginPage.saisirPassword(pwd);
        System.out.println("je saisie password: " + pwd);
    }

    @And("je clique sur le bouton Login")
    public void jeCliqueSurLeBoutonLogin() {
        loginPage.clickLogin();
        System.out.println("je clique sur le bouton Login");
    }

    @Then("connexion avec succès et redirection vers le tableau du board")
    public void connexionAvecSuccèsEtRedirectionVersLeTableauDuBoard() throws InterruptedException {
        // attente time de 3s pour charger la page
        Thread.sleep(3000);
        String url = HelperClass.getDriver().getCurrentUrl();
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", url);
    }

    @And("je clique sur dropdown AdminName en navbar")
    public void jeCliqueSurDropdownAdminNameEnNavbar() {
        logoutPage.clickOnUserDropdownIcon();
        System.out.println("je clique sur user dropdown icon en navbar");
    }

    @And("je clique sur le lien Logout")
    public void jeCliqueSurLeLienLogout() {
        logoutPage.clickOnLogoutLink();
        System.out.println("je clique sur le lien Logout");
    }

    @Then("déconnexion avec succès")
    public void déconnexionAvecSuccès() throws InterruptedException {
        // attente time de 3s pour charger la page
        Thread.sleep(3000);
        String url = HelperClass.getDriver().getCurrentUrl();
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", url);
    }

    @And("je clique sur Admin en menu item")
    public void jeCliqueSurAdminEnMenuItem() {
        adminPage.clickAdminLink();
        System.out.println("je clique sur Admin en menu item");
    }

    @And("je clique sur le bouton Add")
    public void jeCliqueSurLeBoutonAdd() {
        adminPage.clickBtnAdd();
        System.out.println("je clique sur le bouton Add");
    }

    @And("je sélectionne User Role {string}")
    public void jeSélectionneUserRoleUserole(String userole) throws InterruptedException {
        adminPage.selectUserRole(userole);
        System.out.println("je sélectionne User Role: " + userole);
    }

    @And("je saisie Employee Name {string}")
    public void jeSaisieEmployeeNameEmployeename(String employeename) throws InterruptedException {
        adminPage.saisirEmployeeName(employeename);
        System.out.println("je saisie Employee Name: " + employeename);
    }

    @And("je sélectionne Status {string}")
    public void jeSélectionneStatusStatus(String status) throws InterruptedException {
        adminPage.selectStatus(status);
        System.out.println("je saisie Status : " + status);
    }

    @And("je saisie Username {string}")
    public void jeSaisieUsernameName(String name) {
        adminPage.saisirUsername(name);
        System.out.println("je saisie Username: " + name);
    }

    @And("je saisie Password {string}")
    public void jeSaisiePasswordPwd(String pwd) {
        adminPage.saisirAdminPassword(pwd);
        System.out.println("je saisie Password: " + pwd);
    }

    @And("je saisie Confirm Password {string}")
    public void jeSaisieConfirmPasswordConfirmpwd(String confirmpwd) {
        adminPage.saisirConfirmPassword(confirmpwd);
        System.out.println("je saisie Confirm Password: " + confirmpwd);
    }

    @And("je clique sur le bouton save")
    public void jeCliqueSurLeBoutonSave() {
        adminPage.clickBtnSave();
        System.out.println("je clique sur le bouton save");
    }

    @Then("Admin ajouté avec succès")
    public void adminAjoutéAvecSuccès() throws InterruptedException {
        // attente time de 8s pour charger la page
        Thread.sleep(8000);
        String url = HelperClass.getDriver().getCurrentUrl();
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers", url);
        //attendre 2s pour fermer le navigateur
    }

    @And("je clique sur PIM en menu items")
    public void jeCliqueSurPIMEnMenuItems() {
        pimPage.ClickPIMLink();
        System.out.println("je clique sur PIM en sidebar");
    }

    @And("je clique sur bouton Add")
    public void jeCliqueSurBoutonAdd() {
        pimPage.ClickPlusButton();
        System.out.println("je clique sur bouton Add");
    }

    @And("je saisie FirstName {string}")
    public void jeSaisieFirstNameEmpfirstname(String empfirstname) {
        pimPage.SaisirEmpFirstName(empfirstname);
        System.out.println("je saisie FirstName: " + empfirstname);
    }

    @And("je saisie MiddleName {string}")
    public void jeSaisieMiddleNameEmpmiddlename(String empmiddlename) {
        pimPage.SaisirEmpMiddleName(empmiddlename);
        System.out.println("je saisie MiddleName: " + empmiddlename);
    }

    @And("je saisie LastName {string}")
    public void jeSaisieLastNameEmplastname(String emplastname) {
        pimPage.SaisirEmpLastName(emplastname);
        System.out.println("je saisie LastName: " + emplastname);
    }

    @And("je saisie EmployeeId {string}")
    public void jeSaisieEmployeeIdEmpid(String empid) {
        try {
            pimPage.SaisirEmployeeId(empid);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("je saisie EmployeeId: " + empid);
    }

    @And("je coche Create Login Details")
    public void jeCocheCreateLoginDetails() {
        try {
            pimPage.ClickCreateLoginDetails();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("je coche Create Login Details");
    }

    @And("je saisie un Username {string}")
    public void jeSaisieUnUsernameEmpusername(String empusername) {
        pimPage.SaisirEmpUsername(empusername);
        System.out.println("je saisie un Username: " + empusername);
    }

    @And("je sélectionne le Status {string}")
    public void jeSélectionneLeStatusEmpstatus(String empstatus) {
        try {
            pimPage.ClickStatus(empstatus);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("je sélectionne le Status: " + empstatus);
    }

    @And("je saisie un Password {string}")
    public void jeSaisieUnPasswordEmppwd(String emppwd) {
        pimPage.SaisirEmpPassword(emppwd);
        System.out.println("je saisie un Password: " + emppwd);
    }

    @And("je saisie un Confirm Password {string}")
    public void jeSaisieUnConfirmPasswordEmpconfirmpwd(String empconfirmpwd) {
        pimPage.SaisirEmpConfirmPwd(empconfirmpwd);
        System.out.println("je saisie un Confirm Password: " + empconfirmpwd);
    }

    @And("je clique sur bouton Save")
    public void jeCliqueSurBoutonSave() {
        try {
            pimPage.ClickToSave();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("je clique sur bouton Save");
    }

    @Then("ajout employé avec succès")
    public void ajoutEmployéAvecSuccès() throws InterruptedException {
        // attendre time de 8s pour charger la page
        Thread.sleep(8000);
        String url = HelperClass.getDriver().getCurrentUrl();
        Assert.assertTrue("employé ajouté avec succès", url.contains("viewPersonalDetails"));
        //attendre 2s pour fermer le navigateur
    }

    @And("je clique sur Reports en Topbar menu")
    public void jeCliqueSurReportsEnTopbarMenu() throws InterruptedException {
        pimPage.ClickReportsLink();
        System.out.println("je clique sur Reports Link en Topbar menu");
    }

    @And("je saisie report name {string}")
    public void jeSaisieReportNameReportname(String reportname) throws InterruptedException {
        pimPage.SaisirReportName(reportname);
        System.out.println("je saisie report name: " + reportname);
    }

    // je sélectionne criteria With Field <criteria> <field>
    @And("je sélectionne criteria With Field {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void jeSélectionneCriteriaWithFieldCriteriaField(String criteria, String criteriaField, String criteriaEmpName, String Less, String Greater, String RangeFrom, String RangeTo, String JoinedBeforeDate, String JoinedAfterDate, String JoinedInBetween1, String JoinedInBetween2) throws InterruptedException {
        pimPage.SelectionCriteriaWithField(criteria, criteriaField, criteriaEmpName, Less, Greater, RangeFrom, RangeTo, JoinedBeforeDate, JoinedAfterDate, JoinedInBetween1, JoinedInBetween2);
        System.out.println("je sélectionne criteria: " + criteria + " With Field: " + criteriaField);
    }

    @And("je sélectionne include {string}")
    public void jeSélectionneIncludeInclude(String include) throws InterruptedException {
        pimPage.SelectionInclude(include);
        System.out.println("je sélectionne include: " + include);
    }

    // je sélectionne display Field Group With Field <fieldgroup> <field>
    @And("je sélectionne display Field Group With Field {string} {string}")
    public void jeSélectionneDisplayFieldGroupWithFieldFieldgroupField(String fieldgroup, String field) throws InterruptedException {
        pimPage.SelectDisplayFields(fieldgroup, field);
        System.out.println("je sélectionne display Field Group: " + fieldgroup + " With Field: " + field);
    }

    // je clique sur le bouton + add display field
    @And("je clique sur le bouton + add display field")
    public void jeCliqueSurLeBoutonAddDisplayField() throws InterruptedException {
        pimPage.ClickBtnAddDisplayField();
        System.out.println("je clique sur le bouton + add display field");
    }

    @And("je clique sur checkbox include header")
    public void jeCliqueSurCheckboxIncludeHeader() throws InterruptedException {
        pimPage.CheckIncludeHeader();
        System.out.println("je clique sur checkbox include header");
    }

    @Then("Employee report ajouté avec succès")
    public void employeeReportAjoutéAvecSuccès() throws InterruptedException {
        // attendre time de 8s pour charger la page
        Thread.sleep(8000);
        String url = HelperClass.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("displayPredefinedReport"));
    }

    @And("je clique sur Claim en menu items")
    public void jeCliqueSurClaimEnMenuItems() throws InterruptedException {
        claimPage.ClickClaimLink();
        System.out.println("je clique sur Claim en menu items");
    }

    @And("je clique sur le bouton Assign Claim")
    public void jeCliqueSurLeBoutonAssignClaim() throws InterruptedException {
        claimPage.ClickAssignClaimButton();
        System.out.println("je clique sur le bouton Assign Claim");
    }

    @And("je saisie employee name {string}")
    public void jeSaisieEmployeeNameEmployeeName(String employeeName) throws InterruptedException {
        claimPage.SaisirEmployeeName(employeeName);
        System.out.println("je saisie employee name: " + employeeName);
    }

    @And("je sélectionne Event {string}")
    public void jeSélectionneEventEvent(String event) throws InterruptedException {
        claimPage.SelectEvent(event);
        System.out.println("je sélectionne Event: " + event);
    }

    @And("je sélectionne Currency {string}")
    public void jeSélectionneCurrencyCurrency(String currency) throws InterruptedException {
        claimPage.SelectCurrency(currency);
        System.out.println("je sélectionne Currency: " + currency);
    }

    @And("je saisie Remarks {string}")
    public void jeSaisieRemarksRemark(String remark) throws InterruptedException {
        claimPage.SaisirRemarks(remark);
        System.out.println("je saisie Remarks: " + remark);
    }

    @And("je je clique sur le bouton Create")
    public void jeJeCliqueSurLeBoutonCreate() throws InterruptedException {
        claimPage.ClickCreateButton();
        System.out.println("je je clique sur le bouton Create");
    }

    @Then("Claim Request crée avec succès")
    public void claimRequestCréeAvecSuccès() throws InterruptedException {
        // Attendre un temps de 8s pour charger la page
        Thread.sleep(8000);
        String url = HelperClass.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("id"));
    }

    // Scenarios Add Vacancy
    @And("je clique sur Recruitment en menu items")
    public void jeCliqueSurRecruitmentEnMenuItems() {
        try {
            vacancyPage.ClickRecruitmentLink();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("je clique sur Recruitment en menu items");
    }

    @And("je clique sur le lien Vacancies en navbar")
    public void jeCliqueSurLeLienVacanciesEnNavbar() {
        try {
            vacancyPage.ClickVacanciesLink();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("je clique sur le lien Vacancies en navbar");
    }

    @And("je saisie Vacancy Name {string}")
    public void jeSaisieVacancyNameVacanyname(String vacanyname) {
        try {
            vacancyPage.SaisirVacancyName(vacanyname);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("je saisie Vacancy Name: " + vacanyname);
    }

    @And("je sélectionne Job Title {string}")
    public void jeSélectionneJobTitleJobtitle(String jobtitle) {
        try {
            vacancyPage.SelectionJobTitle(jobtitle);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("je sélectionne Job Title: " + jobtitle);
    }

    @And("je saisie Description {string}")
    public void jeSaisieDescriptionDescription(String description) {
        try {
            vacancyPage.SaisirDescription(description);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("je saisie Description: " + description);
    }

    @And("je saisie Hiring Manager {string}")
    public void jeSaisieHiringManagerManager(String manager) {
        try {
            vacancyPage.SaisirHiringManager(manager);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("je saisie Hiring Manager: " + manager);
    }

    @And("je saisie Number of Positions {string}")
    public void jeSaisieNumberOfPositionsNumber(String number) {
        try {
            // Vérifier si l'entrée est vide
            if (number.trim().isEmpty()) {
                System.out.println("⚠ Number of Positions est vide, aucun envoi de valeur.");
                throw new IllegalArgumentException("❌ Erreur : Le champ 'Number of Positions' est vide !");
            }
            // Si l'entrée est alphanumérique (exemple: "50jk"), afficher un message mais continuer
            if (!number.matches("[0-9a-zA-Z]+")) {  // autoriser les chiffres et lettres (alphanumérique)
                System.out.println("❌ Erreur : 'Number of Positions' ne doit pas contenir de caractères spéciaux ou autres symboles ! Valeur fournie: " + number);
                System.out.println("⚠ Continuer avec l'entrée '" + number + "' même si elle est invalide.");
            }
            // Si l'entrée est numérique (un entier valide), on la convertit et la saisit
            if (number.matches("\\d+")) {
                vacancyPage.SaisirNumberPositions(number);  // Ici on suppose que la méthode attend un nombre
                System.out.println("✅ Je saisis Number of Positions (entier valide) : " + number);
            } else {
                // Sinon, traiter l'entrée comme une chaîne (par exemple "50jk")
                vacancyPage.SaisirNumberPositions(number);
                System.out.println("⚠ Je saisis Number of Positions avec une entrée non entière : " + number);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("⛔ Test interrompu : " + e.getMessage());
            System.out.println("⚠ Le test continue malgré l'erreur.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("Vacancy ajouté avec succès")
    public void vacancyAjoutéAvecSuccès() {
        // Attendre un temps de 7s pour charger la page
        try {
            Thread.sleep(7000);
            WebElement SpanWebElement = vacancyPage.GetEditVacancySpan();
            String span = SpanWebElement.getText();
            Assert.assertTrue(SpanWebElement.isDisplayed());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
