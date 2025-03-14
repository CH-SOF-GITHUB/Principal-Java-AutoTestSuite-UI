Feature: Tester les fonctionnalités connexion et ajout employé sur le site OrangeHRM

  Background: tester la connexion avec données valides
    Given je suis sur l'interface login
    When je saisie username "Admin"
    And je saisie password "admin123"
    And je clique sur le bouton Login
    Then connexion avec succès et redirection vers le tableau du board

  @Logout
  Scenario: tester logout
    And je clique sur dropdown AdminName en navbar
    And je clique sur le lien Logout
    Then déconnexion avec succès

  @CreateClaimRequest
  Scenario Outline: tester Submit Claim to Create Claim Request
    And je clique sur Claim en menu items
    And je clique sur le bouton Assign Claim
    And je saisie employee name <employeeName>
    And je sélectionne Event <event>
    And je sélectionne Currency <currency>
    And je saisie Remarks <remark>
    And je je clique sur le bouton Create
    Then Claim Request crée avec succès
    Examples:
      | employeeName            | event                   | currency              | remark                                                                                                                                                                                                                                         |
      # TC01: cas idéal
      | "Tristan  L"            | "Accommodation"         | "Afghanistan Afghani" | "Le lorem ipsum est, en imprimerie, une suite de mots sans signification utilisée à titre provisoire pour calibrer une mise en page, le texte définitif venant remplacer le faux-texte dès qu'il est prêt ou que la mise en page est achevée." |
      # TC02: employee name vide
      | ""                      | "Medical Reimbursement" | "Albanian Lek"        | "Le lorem ipsum est, en imprimerie."                                                                                                                                                                                                           |
      # TC03: event vide
      | "Christopher  Mcmillan" | ""                      | "Algerian Dinar"      | "Le lorem ipsum est, en imprimerie."                                                                                                                                                                                                           |
      # TC04: currency vide
      | "Christopher  Mcmillan" | "Travel Allowance"      | ""                    | "Le lorem ipsum est, en imprimerie."                                                                                                                                                                                                           |
      # TC05: remark vide
      | "Orange  Test"          | "Medical Reimbursement" | ""                    | ""                                                                                                                                                                                                                                             |
      # TC06: employee name invalide
      | "Orange"                | "Medical Reimbursement" | "Angolan New Kwanza"  | "Le lorem ipsum est, en imprimerie."                                                                                                                                                                                                           |
      # TC07: remark invalide taille trés court
      # TC08: remark invalide taille trés long

  @AddReport
  Scenario Outline: tester ajout report avec données valides et invalides
    And je clique sur PIM en menu items
    And je clique sur Reports en Topbar menu
    And je clique sur bouton Add
    And je saisie report name <reportname>
    And je sélectionne criteria With Field <criteria> <criteriaField> <criteriaEmpName> <Less> <Greater> <RangeFrom> <RangeTo> <JoinedBeforeDate> <JoinedAfterDate> <JoinedInBetween1> <JoinedInBetween2>
    And je sélectionne include <include>
    And je sélectionne display Field Group With Field <fieldgroup> <field>
    And je clique sur le bouton + add display field
    And je clique sur checkbox include header
    And je clique sur bouton Save
    Then Employee report ajouté avec succès
    Examples:
      | reportname         | criteria        | criteriaField         | criteriaEmpName  | Less | Greater | RangeFrom | RangeTo | JoinedBeforeDate | JoinedAfterDate | JoinedInBetween1 | JoinedInBetween2 | include                      | fieldgroup        | field                |
      # TC01: cas idéal
      | "Masoud Kousmi"    | "Pay Grade"     | "Grade 1"             | ""               | ""   | ""      | ""        | ""      | ""               | ""              | ""               | ""               | "Past Employees Only"        | "Personal"        | "Employee Id"        |
      # TC02: cas valides
      | "SteveN jobs"      | "Employee Name" | ""                    | "Ranga  Akunuri" | ""   | ""      | ""        | ""      | ""               | ""              | ""               | ""               | "Current and Past Employees" | "Contact Details" | "Address"            |
      # TC03: un ou plusieurs champs vides: criteria vide
      | "Samir Agerbi"     | ""              | ""                    | ""               | ""   | ""      | ""        | ""      | ""               | ""              | ""               | ""               | "Past Employees Only"        | "Dependents"      | "Relationship"       |
      # TC04: un ou plusieurs champs obligatoires vides: include vide => Bug
      | "Kacim Ben yahaya" | "Education"     | "High School Diploma" | ""               | ""   | ""      | ""        | ""      | ""               | ""              | ""               | ""               | ""                           | "Immigration"     | "Eligibility Status" |
      # TC05: Report Name Already exists
      | "Masoud Kousmi"    | "Pay Grade"     | "Grade 3"             | ""               | ""   | ""      | ""        | ""      | ""               | ""              | ""               | ""               | "Current and Past Employees" | "Personal"        | "Employee Last Name" |
      # TC07: Rapport Name vide
      | ""                 | "Employee Name" | ""                    | "Ranga  Akunuri" | ""   | ""      | ""        | ""      | ""               | ""              | ""               | ""               | "Current and Past Employees" | "Contact Details" | "Mobile"             |

  @AddEmployee
  Scenario Outline: tester PIM ajout nouvel employé
    And je clique sur PIM en menu items
    And je clique sur bouton Add
    And je saisie FirstName <empfirstname>
    And je saisie MiddleName <empmiddlename>
    And je saisie LastName <emplastname>
    And je saisie EmployeeId <empid>
    And je coche Create Login Details
    And je saisie un Username <empusername>
    And je sélectionne le Status <empstatus>
    And je saisie un Password <emppwd>
    And je saisie un Confirm Password <empconfirmpwd>
    And je clique sur bouton Save
    Then ajout employé avec succès
    Examples:
      | empfirstname | empmiddlename | emplastname  | empid  | empusername  | empstatus  | emppwd      | empconfirmpwd |
      # TC01: Cas idéal
      | "John"       | "Doe"         | "John Steve" | "4567" | "JohnSTV122" | "Disabled" | "Admin123!" | "Admin123!"   |
      # TC02: First Name vide
      | ""           | "Lahmar"      | "Ben Said"   | "1111" | "CHbEN20"    | "Enabled"  | "Admin123!" | "Admin123!"   |
      # TC03: Middle Name vide
      | "Samir"      | ""            | "Salehhy"    | "234"  | "SamirSLH"   | "Disabled" | "Admin123!" | "Admin123!"   |
      # TC04: Last Name vide
      | "Farouk"     | "Tarek"       | ""           | "560"  | "Farouk@33"  | "Enabled"  | "Admin123!" | "Admin123!"   |
      # TC05: Employee id vide
      | "Ali"        | "Hamza"       | "Khaled"     | ""     | "AliKhaled1" | "Enabled"  | "Admin123!" | "Admin123!"   |
      # TC06: Employee Username vide
      | "Nour"       | "Sami"        | "Mansour"    | "7890" | ""           | "Disabled" | "Admin123!" | "Admin123!"   |
      # TC07: Status vide
      | "Layla"      | "Omar"        | "Hassan"     | "5678" | "LaylaH"     | ""         | "Admin123!" | "Admin123!"   |
      # TC08: Employee password vide
      | "Karim"      | "Ali"         | "Bensalem"   | "9090" | "KarimBen"   | "Enabled"  | ""          | "Admin123!"   |
      # TC09: Confirm Password vide
      | "Amina"      | "Ziad"        | "Chakib"     | "3232" | "AminaC22"   | "Disabled" | "Admin123!" | ""            |
      # TC10: Employee id invalide (caractères spéciaux)
      | "Hicham"     | "Nour"        | "Fares"      | "@@12" | "HichamF"    | "Enabled"  | "Admin123!" | "Admin123!"   |
      # TC11: Username déjà existant
      | "Omar"       | "Ismail"      | "Jabri"      | "8765" | "JohnSTV122" | "Disabled" | "Admin123!" | "Admin123!"   |
      # TC12: Employee password invalide (trop court)
      | "Sami"       | "Mahdi"       | "Nour"       | "7410" | "SamiNour"   | "Enabled"  | "Adm1"      | "Adm1"        |
      # TC13: Confirm Password invalide (ne correspond pas au mot de passe)
      | "Mona"       | "Rayan"       | "Saidi"      | "3021" | "MonaSaid"   | "Disabled" | "Admin123!" | "Admin12"     |
      # TC14: Employee ID déjà existant
      | "Fares"      | "Khaled"      | "Omar"       | "4567" | "FaresK"     | "Enabled"  | "Admin123!" | "Admin123!"   |

  @AddUserAdmin
  Scenario Outline: tester Admin User Management
    And je clique sur Admin en menu item
    And je clique sur le bouton Add
    And je sélectionne User Role <userole>
    And je saisie Employee Name <employeename>
    And je sélectionne Status <status>
    And je saisie Username <name>
    And je saisie Password <pwd>
    And je saisie Confirm Password <confirmpwd>
    And je clique sur le bouton save
    Then Admin ajouté avec succès
    Examples:
      | userole | employeename         | status     | name               | pwd              | confirmpwd       |
      # TC01: cas idéal
      | "ESS"   | "joker john selvam"  | "Enabled"  | "ChakerBSaid"      | "Admin123!"      | "Admin123!"      |
      # TC02: User Role vide
      | ""      | "Thomas Kutty Benny" | "Enabled"  | "Tarek Salami"     | "Admin123!"      | "Admin123!"      |
      # TC03: Status vide
      | "Admin" | "Rosanna Ryan Pagac" | ""         | "Farouk Ben yahya" | "Azerty123!"     | "Azerty123!"     |
      # TC04: Employee Name vide
      | "Admin" | ""                   | "Disabled" | "Sami Tarkei"      | "Azerty123!"     | "Azerty123!"     |
      # TC05: Username vide
      | "ESS"   | "ftyseo  ltzbbp"     | "Disabled" | ""                 | "OrangeRHM12!"   | "OrangeRHM12!"   |
      # TC06: mot de passe vide
      | "Admin" | "Thomas Kutty Benny" | "Enabled"  | "Saleh Taktak"     | ""               | "OrangeRHM12!"   |
      # TC07: confirmation de mot de passe vide
      | "ESS"   | "Rahul  Das"         | "Disabled" | "Raouf Aleyi"      | "OrangeRHM12!"   | ""               |
      # TC08: Employee Name invalide
      | "Admin" | "zer"                | "Enabled"  | "Salma Zaedi"      | "AzertOrange13!" | "AzertOrange13!" |
      # TC09: Username invalide
      | "ESS"   | "Rahul  Das"         | "Disabled" | "ali"              | "AzertOrange13!" | "AzertOrange13!" |
      # TC10: Username déjà existe
      | "ESS"   | "Rahul  Das"         | "Disabled" | "ChakerBSaid"      | "Azert12345!?"   | "Azert12345!?"   |
      # TC11: mot de passe invalide
      | "Admin" | "Peter Mac Anderson" | "Enabled"  | "Nouri Kacemi"     | "admin"          | "Azerty123?!"    |
      # TC12: confirmation de mot de passe invalide
      | "Admin" | "Peter Mac Anderson" | "Enabled"  | "Ismail Trabelsi"  | "Azerty123!"     | "Azert"          |