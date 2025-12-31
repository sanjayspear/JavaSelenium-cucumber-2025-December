# Java Selenium Cucumber BDD Framework

A robust Behavior-Driven Development (BDD) automation testing framework using Java, Selenium WebDriver, and Cucumber with the Page Object Model (POM) design pattern.

---

## 📋 Table of Contents

1. [Framework Overview](#framework-overview)
2. [Architecture](#architecture)
3. [Prerequisites](#prerequisites)
4. [Project Setup](#project-setup)
5. [Configuration](#configuration)
6. [Running Tests](#running-tests)
7. [Project Structure](#project-structure)
8. [Key Components](#key-components)
9. [Writing Tests](#writing-tests)
10. [Reporting](#reporting)
11. [Troubleshooting](#troubleshooting)

---

## 🎯 Framework Overview

This framework provides:
- **BDD Testing**: Write tests in plain English using Gherkin syntax
- **Page Object Model**: Maintainable and reusable page object classes
- **Thread-Safe Driver Management**: ThreadLocal WebDriver for parallel execution
- **Multiple Browser Support**: Chrome and Firefox support
- **Comprehensive Reporting**: HTML and JSON report generation
- **Hooks Integration**: Pre/post-test setup and teardown
- **Parallel Execution**: Run tests in parallel with TestNG

**Tech Stack:**
- Java 21
- Selenium WebDriver 4.39.0
- Cucumber JVM 7.33.0
- TestNG 7.11.0
- Maven 3.x

---

## 🏗️ Architecture

```
┌─────────────────────────────────────────────────────────┐
│          Feature Files (Gherkin Syntax)                 │
│         (src/test/resources/features/)                  │
└──────────────────┬──────────────────────────────────────┘
                   │
┌──────────────────▼──────────────────────────────────────┐
│         Step Definitions                                │
│    (src/test/java/stepDefinitions/)                     │
└──────────────────┬──────────────────────────────────────┘
                   │
┌──────────────────▼──────────────────────────────────────┐
│    Page Object Classes (Base_PO, Login_PO, etc.)        │
│      (src/main/java/pageObjects/)                       │
└──────────────────┬──────────────────────────────────────┘
                   │
┌──────────────────▼──────────────────────────────────────┐
│      DriverFactory (ThreadLocal Driver)                 │
│      (src/main/java/driver/)                            │
└──────────────────┬──────────────────────────────────────┘
                   │
┌──────────────────▼──────────────────────────────────────┐
│        Selenium WebDriver                               │
│    (Chrome, Firefox, Edge, etc.)                        │
└─────────────────────────────────────────────────────────┘
```

---

## 📦 Prerequisites

Ensure you have the following installed:

| Tool | Version | Download |
|------|---------|----------|
| Java | 21 or 17 | [java.com](https://www.java.com) |
| Maven | 3.6+ | [maven.apache.org](https://maven.apache.org) |
| Git | Latest | [git-scm.com](https://git-scm.com) |
| Chrome Browser | Latest | [google.com/chrome](https://www.google.com/chrome) |
| Firefox Browser | Latest | [mozilla.org/firefox](https://www.mozilla.org/firefox) |

### Verify Installation

```bash
# Check Java version
java -version

# Check Maven version
mvn -version
```

---

## 🚀 Project Setup

### 1. Clone the Repository

```bash
git clone <repository-url>
cd JavaSelenium-BDD-FW-2025-Dec
```

### 2. Install Dependencies

```bash
mvn clean install
```

This will download all required dependencies specified in `pom.xml`.

### 3. Configure WebDriver

The framework expects WebDriver executables in:
```
src/main/java/driver/drivers/
├── chromedriver.exe
└── geckodriver.exe
```

**Steps:**
1. Download [ChromeDriver](https://chromedriver.chromium.org/) matching your Chrome version
2. Download [GeckoDriver](https://github.com/mozilla/geckodriver/releases/) for Firefox
3. Place executables in `src/main/java/driver/drivers/` folder

---

## ⚙️ Configuration

### config.properties

Located at: `src/main/java/properties/config.properties`

```properties
# Browser Configuration
browser=chrome
```

**Supported Browsers:**
- `chrome` - Google Chrome (default)
- `firefox` - Mozilla Firefox

### Global Variables

File: `src/main/java/utils/Global_Vars.java`

Used to store application-wide constants like URLs, timeouts, and test data.

### Runner Configuration

File: `src/test/java/runners/MainRunner.java`

```java
@CucumberOptions(
    features = {"classpath:features"},           // Feature file location
    glue = {"stepDefinitions"},                  // Step definition package
    tags = "@regression",                        // Tags to filter tests
    monochrome = true,                           // Console output formatting
    dryRun = false,                              // Check if steps are defined
    plugin = {
        "pretty",                                // Pretty console output
        "html:target/cucumber",                  // HTML report
        "json:target/cucumber.json"              // JSON report
    }
)
```

---

## ▶️ Running Tests

### 1. Run All Tests


```bash
mvn clean test -Dtest=MainRunner
```

### 2. Run in Headless Mode

Add to `config.properties`:
```properties
browser=chrome
headless=true
```

Then run:
```bash
mvn clean test
```

### 6. Run with Specific Browser

```bash
# Run with Firefox
mvn clean test -Dbrowser=firefox
```

### 7. Dry Run (Check Step Definitions)

```bash
mvn clean test -Dcucumber.filter.dry-run=true
```

### 8. Generate Report Without Running Tests

```bash
mvn clean verify
```

---

## 📁 Project Structure

```
JavaSelenium-BDD-FW-2025-Dec/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── driver/
│   │       │   ├── DriverFactory.java          # WebDriver factory (ThreadLocal)
│   │       │   └── drivers/                    # WebDriver executables
│   │       │       ├── chromedriver.exe
│   │       │       └── geckodriver.exe
│   │       ├── pageObjects/
│   │       │   ├── Base_PO.java                # Base page object class
│   │       │   ├── Login_PO.java               # Login page objects
│   │       │   └── Contact_Us_PO.java          # Contact Us page objects
│   │       ├── properties/
│   │       │   └── config.properties           # Configuration file
│   │       └── utils/
│   │           └── Global_Vars.java            # Global variables & constants
│   │
│   └── test/
│       ├── java/
│       │   ├── runners/
│       │   │   └── MainRunner.java             # Cucumber test runner
│       │   └── stepDefinitions/
│       │       ├── Login_Steps.java            # Login step definitions
│       │       ├── Contact_Us_Steps.java       # Contact Us step definitions
│       │       └── base/
│       │           └── Hooks.java              # Before/After hooks
│       │
│       └── resources/
│           └── features/
│               ├── Login.feature               # Login feature file
│               └── Contact_Us.feature          # Contact Us feature file
│
├── target/                                     # Build output
│   ├── classes/                                # Compiled classes
│   ├── test-classes/                           # Compiled test classes
│   ├── cucumber.json                           # JSON report
│   └── cucumber/                               # HTML report directory
│
├── pom.xml                                     # Maven configuration
└── README.md                                   # This file
```

---

## 🔑 Key Components

### 1. DriverFactory (src/main/java/driver/DriverFactory.java)

Manages WebDriver lifecycle using ThreadLocal pattern for thread-safe parallel execution.

```java
// Get driver instance
WebDriver driver = DriverFactory.getDriver();

// Quit driver
DriverFactory.quitDriver();
```

**Features:**
- ThreadLocal storage for concurrent test execution
- Chrome and Firefox support
- Automatic window maximization
- Configurable page load strategy

### 2. Base_PO (src/main/java/pageObjects/Base_PO.java)

Base class for all page objects containing common locators and methods.

```java
public abstract class Base_PO {
    protected WebDriver driver;
    
    // Common methods for all pages
    protected void click(WebElement element) { ... }
    protected void sendKeys(WebElement element, String text) { ... }
    protected String getText(WebElement element) { ... }
}
```

### 3. Page Objects (Login_PO, Contact_Us_PO)

Encapsulate page-specific locators and methods following the Page Object Model.

```java
public class Login_PO extends Base_PO {
    @FindBy(id = "email")
    private WebElement emailField;
    
    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }
}
```

### 4. Step Definitions

Bridge between Gherkin scenarios and test automation code.

```java
@Given("User is on login page")
public void user_is_on_login_page() {
    // Implementation
}

@When("User enters valid credentials")
public void user_enters_valid_credentials() {
    // Implementation
}

@Then("User should see dashboard")
public void user_should_see_dashboard() {
    // Implementation
}
```

### 5. Hooks (base/Hooks.java)

Setup and teardown operations before/after each test scenario.

```java
@Before
public void setUp() {
    // Initialize WebDriver
}

@After
public void tearDown() {
    // Close WebDriver
}
```

---

## ✍️ Writing Tests

### Creating a Feature File

Create a new file: `src/test/resources/features/MyFeature.feature`

```gherkin
Feature: User Registration
  As a new user
  I want to register on the platform
  So that I can access the application

  @smoke @registration
  Scenario: Successful user registration
    Given User is on registration page
    When User fills registration form with valid data
    And User clicks submit button
    Then User should see success message
    And User should be logged in

  @regression @registration
  Scenario: Registration with existing email
    Given User is on registration page
    When User fills registration form with existing email
    And User clicks submit button
    Then User should see error message
```

### Creating Step Definitions

Create a new file: `src/test/java/stepDefinitions/Registration_Steps.java`

```java
package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Registration_Steps {
    WebDriver driver = DriverFactory.getDriver();
    
    @Given("User is on registration page")
    public void user_is_on_registration_page() {
        driver.get("https://example.com/register");
    }
    
    @When("User fills registration form with valid data")
    public void user_fills_registration_form() {
        // Implementation using page objects
    }
    
    @Then("User should see success message")
    public void user_should_see_success_message() {
        // Assertions
    }
}
```

### Creating Page Objects

Create a new file: `src/main/java/pageObjects/Registration_PO.java`

```java
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration_PO extends Base_PO {
    
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    
    @FindBy(id = "email")
    private WebElement emailField;
    
    @FindBy(id = "registerBtn")
    private WebElement registerButton;
    
    public Registration_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void enterFirstName(String firstName) {
        sendKeys(firstNameField, firstName);
    }
    
    public void clickRegister() {
        click(registerButton);
    }
}
```

---

## 📊 Reporting

### HTML Report

After test execution, open the HTML report:

```
target/cucumber/index.html
```

**View in Browser:**
- Windows: `start target\cucumber\index.html`
- Mac: `open target/cucumber/index.html`
- Linux: `xdg-open target/cucumber/index.html`

### JSON Report

Located at: `target/cucumber.json`

Used for integration with CI/CD pipelines and third-party reporting tools.

### Console Output

Tests run with `monochrome = true` for clean console formatting.

---

## 🐛 Troubleshooting

### Issue: WebDriver Not Found

**Error:** `The path to the driver executable must be set by the webdriver.chrome.driver`

**Solution:**
1. Download WebDriver from [chromedriver.chromium.org](https://chromedriver.chromium.org/)
2. Place in `src/main/java/driver/drivers/`
3. Ensure filename is exactly `chromedriver.exe` (Windows) or `chromedriver` (Mac/Linux)

### Issue: Tests Not Finding Step Definitions

**Error:** `Step 'xxx' is undefined`

**Solution:**
1. Ensure step definition class is in `stepDefinitions` package
2. Verify `glue = {"stepDefinitions"}` in MainRunner
3. Run: `mvn clean test -Dcucumber.filter.dry-run=true`

### Issue: NoClassDefFoundError

**Error:** `java.lang.NoClassDefFoundError`

**Solution:**
```bash
# Clear Maven cache and reinstall
mvn clean install -U
```

### Issue: StaleElementReferenceException

**Error:** `org.openqa.selenium.StaleElementReferenceException`

**Solution:**
- Add implicit/explicit waits in Base_PO
- Refresh element references when needed
- Use proper synchronization between steps

### Issue: Timeout Exceptions

**Error:** `TimeoutException` or `NoSuchElementException`

**Solution:**
1. Increase explicit wait timeout
2. Verify correct locators are used
3. Check if element is actually visible/present on page

### Issue: Maven Build Fails

**Error:** `BUILD FAILURE`

**Solution:**
```bash
# Verify Java installation
java -version

# Verify Maven installation
mvn -version

# Clean and rebuild
mvn clean install -X
```

---

## 📝 Best Practices

1. **Page Object Model**: Keep all locators in page objects, not step definitions
2. **Reusable Methods**: Create utility methods in Base_PO for common actions
3. **Gherkin Syntax**: Write scenarios in business language, not technical jargon
4. **Explicit Waits**: Use explicit waits instead of Thread.sleep()
5. **Error Handling**: Implement proper exception handling in hooks
6. **Tag Management**: Use tags to organize and filter test execution
7. **Data-Driven Tests**: Use scenario outlines for multiple data sets
8. **Screenshots on Failure**: Capture screenshots in @After hook for debugging
9. **Code Comments**: Document complex logic and page interactions
10. **Parallel Execution**: Ensure tests are independent for parallel runs

---

## 🔄 CI/CD Integration

### GitHub Actions Example

Create `.github/workflows/tests.yml`:

```yaml
name: Automation Tests

on: [push, pull_request]

jobs:
  test:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v2
    
    - name: Set up Java
      uses: actions/setup-java@v2
      with:
        java-version: '21'
    
    - name: Run tests
      run: mvn clean test
    
    - name: Upload reports
      if: always()
      uses: actions/upload-artifact@v2
      with:
        name: test-reports
        path: target/cucumber/
```

---

## 📚 Additional Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [Cucumber BDD](https://cucumber.io/docs/cucumber/)
- [TestNG Framework](https://testng.org/doc/documentation-main.html)
- [Maven Guide](https://maven.apache.org/guides/)

---

## ✅ Checklist Before Running Tests

- [ ] Java 21 installed and JAVA_HOME set
- [ ] Maven installed and added to PATH
- [ ] WebDrivers downloaded and placed in `src/main/java/driver/drivers/`
- [ ] `config.properties` configured with correct browser
- [ ] Feature files created in `src/test/resources/features/`
- [ ] Step definitions implemented in `stepDefinitions/` package
- [ ] Page objects created extending Base_PO
- [ ] Hooks.java configured with setup/teardown

---

## 📞 Support & Contribution

For issues, feature requests, or contributions, please contact the development team.

---

**Last Updated:** December 31, 2025  
**Framework Version:** 1.0  
**Java Version:** 21
