# Quick Start Guide - Java Selenium Cucumber Framework

Welcome to the automation testing framework! This guide will help you understand the basics and get started quickly.

---

## 🤔 What is This Framework?

Think of this framework as a tool to automatically test websites and web applications. Instead of manually clicking buttons and checking results, the framework does it for you.

**Simple Example:**
- **Manual Testing:** Open browser → Go to login page → Type username → Type password → Click login → Check if dashboard appears
- **Automated Testing:** Framework does all of this automatically and reports if it passed or failed

---

## 🧩 Key Concepts (Explained Simply)

### 1. **BDD (Behavior-Driven Development)**
Tests are written in plain English that everyone can understand (even non-technical people).

**Example:**
```
Given User is on login page
When User enters email and password
Then User should see the dashboard
```

### 2. **Page Object Model (POM)**
All the buttons, text fields, and other elements of a page are stored in separate files called "Page Objects".

**Why?** If a button moves to a different location, you only need to update one file instead of searching through all tests.

**Example Structure:**
```
LoginPage.java  →  Contains all login page elements
  - Email field location
  - Password field location
  - Login button location
```

### 3. **WebDriver**
The tool that actually controls the browser (like a robot clicking buttons).

### 4. **Selenium**
A library that makes WebDriver work in Java code.

### 5. **Cucumber**
Converts plain English test descriptions into actual tests that the framework can run.

### 6. **Maven**
A tool that manages all the dependencies and builds the project.

---

## ⚡ 5-Minute Setup

### Step 1: Install Java (5 min)
1. Download Java 21 from [java.com](https://www.java.com)
2. Install it
3. Open Command Prompt and type: `java -version`
   - If you see a version number, you're good!

### Step 2: Install Maven (3 min)
1. Download Maven from [maven.apache.org](https://maven.apache.org/download.cgi)
2. Extract it to a folder
3. Add to Windows PATH (ask your lead if unsure)
4. Open Command Prompt and type: `mvn -version`
   - If you see a version number, you're good!

### Step 3: Download WebDrivers (2 min)
1. Download ChromeDriver from [chromedriver.chromium.org](https://chromedriver.chromium.org/)
   - Make sure the version matches your Chrome browser
2. Save it in: `src/main/java/driver/drivers/`
   - File should be named: `chromedriver.exe`

### Step 4: Run Your First Test (1 min)
1. Open Command Prompt
2. Go to project folder: `cd C:\Users\YourName\Desktop\JavaSelenium-BDD-FW-2025-Dec`
3. Run: `mvn clean test`
4. Watch the browser open and tests run automatically!

---

## 📁 Folder Structure (Simple Explanation)

```
JavaSelenium-BDD-FW-2025-Dec/
│
├── src/main/java/              ← Production Code (What you WRITE)
│   ├── driver/
│   │   ├── DriverFactory.java  ← Manages the browser (DON'T TOUCH)
│   │   └── drivers/            ← Put WebDriver executables here
│   ├── pageObjects/            ← Page element locations (MOST IMPORTANT)
│   │   ├── Base_PO.java        ← Common methods for all pages
│   │   ├── Login_PO.java       ← Login page elements
│   │   └── Contact_Us_PO.java  ← Contact Us page elements
│   ├── properties/
│   │   └── config.properties   ← Browser settings
│   └── utils/
│       └── Global_Vars.java    ← Constants and URLs
│
├── src/test/java/              ← Test Code (WHERE YOU WRITE TESTS)
│   ├── runners/
│   │   └── MainRunner.java     ← Test controller (mostly done)
│   └── stepDefinitions/        ← Test logic (YOU WRITE HERE)
│       ├── Login_Steps.java    ← Login test steps
│       ├── Contact_Us_Steps.java ← Contact Us test steps
│       └── base/
│           └── Hooks.java      ← Setup and cleanup
│
├── src/test/resources/         ← Test Scenarios (YOU WRITE HERE)
│   └── features/
│       ├── Login.feature       ← Login test scenarios
│       └── Contact_Us.feature  ← Contact Us test scenarios
│
├── target/                     ← Results (AUTO-GENERATED)
│   ├── cucumber.json           ← Test report data
│   └── cucumber/               ← Pretty HTML report
│
└── README.md                   ← Full documentation
```

**In Simple Terms:**
- 🔴 **Red folders** = Files that already exist (don't change)
- 🟢 **Green folders** = Where you write your new tests

---

## 🎬 Step-by-Step: How Tests Work

### Step 1: Write the Test in Plain English
**File:** `src/test/resources/features/Login.feature`
```gherkin
Feature: Login Testing

  Scenario: User can login with valid credentials
    Given User is on login page
    When User enters valid email and password
    Then User should be logged in successfully
```

### Step 2: Write the Test Logic
**File:** `src/test/java/stepDefinitions/Login_Steps.java`
```java
public class Login_Steps {
    
    @Given("User is on login page")
    public void user_opens_login_page() {
        driver.get("https://example.com/login");
    }
    
    @When("User enters valid email and password")
    public void user_enters_credentials() {
        loginPage.enterEmail("user@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();
    }
    
    @Then("User should be logged in successfully")
    public void verify_login_success() {
        Assert.assertTrue(dashboardPage.isDashboardVisible());
    }
}
```

### Step 3: Define Page Elements
**File:** `src/main/java/pageObjects/Login_PO.java`
```java
public class Login_PO extends Base_PO {
    
    @FindBy(id = "email")
    private WebElement emailField;
    
    @FindBy(id = "password")
    private WebElement passwordField;
    
    @FindBy(id = "loginBtn")
    private WebElement loginButton;
    
    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }
    
    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }
    
    public void clickLoginButton() {
        click(loginButton);
    }
}
```

### Step 4: Run the Test
```bash
mvn clean test
```

**What happens:**
1. ✅ Browser opens automatically
2. ✅ Navigates to login page
3. ✅ Enters email and password
4. ✅ Clicks login button
5. ✅ Checks if dashboard is visible
6. ✅ Browser closes
7. ✅ Report generated

---

## 💻 Common Commands You'll Use

### Run all tests
```bash
mvn clean test
```

### Run only "smoke" tests
```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
```

### Run only "regression" tests
```bash
mvn clean test -Dcucumber.filter.tags="@regression"
```

### Run with Firefox instead of Chrome
```bash
mvn clean test -Dbrowser=firefox
```

### Just check if all steps are defined (don't run tests)
```bash
mvn clean test -Dcucumber.filter.dry-run=true
```

---

## 🏷️ Understanding Tags

Tags are labels you put on tests to organize them.

**In Feature File:**
```gherkin
@smoke
Scenario: Quick smoke test
  ...

@regression
Scenario: Complete user flow test
  ...

@login @critical
Scenario: Critical login test
  ...
```

**Run specific tags:**
```bash
mvn clean test -Dcucumber.filter.tags="@smoke"        # Run @smoke only
mvn clean test -Dcucumber.filter.tags="@login"        # Run @login only
mvn clean test -Dcucumber.filter.tags="@smoke and @login"  # Run both
```

---

## 📝 Writing Your First Test (Copy & Modify)

### 1. Create Feature File
**New file:** `src/test/resources/features/MyTest.feature`
```gherkin
Feature: My First Test

  @smoke
  Scenario: Test something
    Given I do something
    When I do another thing
    Then I should see a result
```

### 2. Create Step Definitions
**New file:** `src/test/java/stepDefinitions/MyTest_Steps.java`
```java
package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class MyTest_Steps {
    WebDriver driver = DriverFactory.getDriver();
    
    @Given("I do something")
    public void i_do_something() {
        driver.get("https://example.com");
    }
    
    @When("I do another thing")
    public void i_do_another_thing() {
        // Your code here
    }
    
    @Then("I should see a result")
    public void i_should_see_result() {
        // Your assertion here
    }
}
```

### 3. Run it
```bash
mvn clean test -Dcucumber.filter.name="MyTest"
```

---

## 🔍 Understanding Test Reports

After running tests, you get two reports:

### 1. HTML Report (Pretty & Visual)
**Location:** `target/cucumber/index.html`

**Open it:**
- Windows: Double-click the file
- Or: Right-click → Open with Browser

**Shows:**
- ✅ Passed tests (green)
- ❌ Failed tests (red)
- Screenshots of failures
- Time taken for each step

### 2. JSON Report (For Integration)
**Location:** `target/cucumber.json`

**Used for:**
- Sending to external reporting tools
- CI/CD pipelines
- Email reports

---

## ⚠️ Common Beginner Mistakes

### ❌ Mistake 1: Using Thread.sleep()
```java
// DON'T DO THIS
Thread.sleep(5000);  // Wait 5 seconds
```
**Why?** Tests become slow and unreliable.

**Do This Instead:**
```java
// DO THIS
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOf(element));
```

### ❌ Mistake 2: Not using Page Objects
```java
// DON'T DO THIS (scattered everywhere)
WebElement email = driver.findElement(By.id("email"));
email.sendKeys("test@test.com");
```

**Do This Instead:**
```java
// DO THIS (organized in one place)
loginPage.enterEmail("test@test.com");
```

### ❌ Mistake 3: Hard-coded Locators
```java
// DON'T DO THIS
driver.findElement(By.id("some-random-id-12345")).click();
```

**Do This Instead:**
```java
// DO THIS (use descriptive locators)
@FindBy(id = "loginButton")
private WebElement loginButton;
```

### ❌ Mistake 4: Not using Tags
```gherkin
# DON'T DO THIS
Scenario: Login test
Scenario: Another login test
Scenario: Yet another login test
```

**Do This Instead:**
```gherkin
@smoke @login
Scenario: Quick login test

@regression @login
Scenario: Complete login test
```

---

## 🆘 Help! Something Went Wrong

### Problem: "WebDriver not found"
**Solution:**
1. Download ChromeDriver from [chromedriver.chromium.org](https://chromedriver.chromium.org/)
2. Make sure it matches your Chrome version
3. Place it in: `src/main/java/driver/drivers/chromedriver.exe`
4. Restart and try again

### Problem: "Step is undefined"
**Solution:**
1. Copy the step name exactly from the error message
2. Make sure your step definition method matches it
3. Run: `mvn clean test -Dcucumber.filter.dry-run=true`
4. It will tell you which steps are missing

### Problem: "Element not found"
**Solution:**
1. Open website in browser
2. Right-click element → Inspect
3. Find the ID or CSS class
4. Update your Page Object with correct locator
5. Try again

### Problem: Test passes when run alone but fails in batch
**Solution:**
1. Tests are interfering with each other
2. Make sure Hooks.java properly closes the browser after each test
3. Don't share browser instances between tests

### Problem: "BUILD FAILURE"
**Solution:**
```bash
# Clear Maven cache and try again
mvn clean install -U
```

---

## 📚 Learn More

Once you're comfortable, read the [full README.md](README.md) for:
- Advanced configuration options
- Parallel test execution
- CI/CD integration
- Best practices
- Troubleshooting guide

---

## 🎓 Learning Path

### Week 1: Basics
- [ ] Understand the 3 files: Feature, Steps, Page Objects
- [ ] Run existing tests
- [ ] Modify a simple test
- [ ] Read test reports

### Week 2: Write Tests
- [ ] Write your own feature file
- [ ] Create step definitions
- [ ] Create page objects
- [ ] Run and debug

### Week 3: Master It
- [ ] Use tags effectively
- [ ] Understand waits and synchronization
- [ ] Handle test failures
- [ ] Optimize test speed

### Week 4: Advanced
- [ ] Parallel execution
- [ ] CI/CD integration
- [ ] Complex scenarios
- [ ] Mentoring others

---

## 🎯 Quick Checklist Before Writing Tests

- [ ] Java installed (check: `java -version`)
- [ ] Maven installed (check: `mvn -version`)
- [ ] ChromeDriver in `src/main/java/driver/drivers/`
- [ ] Can run `mvn clean test` successfully
- [ ] Understand feature file format
- [ ] Understand step definitions
- [ ] Understand page objects

---

## 💡 Pro Tips

1. **Start Small:** Write one test first, then expand
2. **Use Real Data:** Test with actual URLs and user data
3. **Meaningful Names:** Use clear names for features and scenarios
4. **Keep It DRY:** Don't repeat code, use helper methods
5. **Document Steps:** Add comments explaining complex logic
6. **Version Control:** Commit frequently to Git
7. **Code Reviews:** Have teammates review your tests
8. **Update Locators:** Keep page objects updated when UI changes

---

## 🚀 Ready to Start?

1. Set up your environment (Java, Maven, WebDriver)
2. Run: `mvn clean test`
3. Check the report in: `target/cucumber/index.html`
4. Follow the "Writing Your First Test" section above
5. Ask for help when stuck!

---

## 📞 Quick Reference

| What | Where | Example |
|------|-------|---------|
| Test Scenarios | `.feature` files | `src/test/resources/features/` |
| Test Logic | `*_Steps.java` | `src/test/java/stepDefinitions/` |
| Page Elements | `*_PO.java` | `src/main/java/pageObjects/` |
| Settings | `config.properties` | `src/main/java/properties/` |
| Test Runner | `MainRunner.java` | `src/test/java/runners/` |
| Reports | `target/` folder | `target/cucumber/index.html` |

---

**Remember:** Automation testing is like learning to cook. Start with simple recipes, follow the steps, and soon you'll be creating complex dishes! 🍳

Good luck! 🚀
