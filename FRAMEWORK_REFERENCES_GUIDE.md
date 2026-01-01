# Framework References & Usage Guide

This document provides a comprehensive overview of all references used in the Java Selenium BDD Framework with explanations on why and when to use each one.

---

## 1. Environment & Development Setup

### 1.1 Java Development Kit (JDK)
**References:**
- https://jdk.java.net/archive/
- https://openjdk.org/install/

**Why & When to Use:**
- **Purpose:** JDK is the foundation of any Java project. It includes the compiler, runtime, and development tools needed to build and run Java applications.
- **When:** Install JDK before setting up any Java project. Choose appropriate version (Java 8, 11, 17, 21 based on project requirements).
- **In This Framework:** Required to compile source code and run automated tests.

### 1.2 Setting Java HOME (Environment Variables)
**References:**
- https://stackoverflow.com/questions/24641536/how-to-set-java-home-in-linux-for-all-users
- https://stackoverflow.com/questions/14702702/how-to-set-java-home-in-mac-permanently

**Why & When to Use:**
- **Purpose:** `JAVA_HOME` environment variable tells your system where the JDK is installed, enabling tools like Maven and IDEs to find Java.
- **When:** Set after JDK installation on Windows, Mac, or Linux to avoid path-related errors.
- **In This Framework:** Required for Maven to compile code and execute tests properly.

### 1.3 Integrated Development Environment (IDE)
**References:**
- https://www.jetbrains.com/idea/download/?section=windows

**Why & When to Use:**
- **Purpose:** IntelliJ IDEA provides code editing, debugging, testing, and project management capabilities.
- **When:** Use for development, debugging tests, running tests locally, and code refactoring.
- **In This Framework:** Develop and debug page objects, step definitions, and runner classes.

---

## 2. Build Tools & Package Management

### 2.1 Maven
**References:**
- https://maven.apache.org/install.html
- https://maven.apache.org/download.cgi

**Why & When to Use:**
- **Purpose:** Maven automates project builds, manages dependencies, runs tests, and packages applications.
- **When:** Use `mvn clean test` to run tests, `mvn compile` to compile code, `mvn package` to create JAR files.
- **In This Framework:** Compile source code, manage all dependencies, run Cucumber tests via runner class.
- **Key Commands:**
  - `mvn clean install` - Clean previous builds and install dependencies
  - `mvn test` - Run all tests
  - `mvn surefire:test` - Run tests with Maven Surefire plugin

### 2.2 JAR File Format
**References:**
- https://en.wikipedia.org/wiki/JAR_(file_format)

**Why & When to Use:**
- **Purpose:** JAR (Java Archive) files package compiled Java code and resources into a single file for distribution and execution.
- **When:** Need to package application or run it without source code access.
- **In This Framework:** Maven creates JAR files in the `target/` directory containing compiled framework code.

---

## 3. Dependency Management

### 3.1 Selenium WebDriver
**References:**
- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
- https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/

**Why & When to Use:**
- **Purpose:** Selenium WebDriver is the core library for automating web browsers and interacting with web elements.
- **When:** Use to locate elements, interact with them (click, type, submit), navigate, and verify web application behavior.
- **In This Framework:** Used in `DriverFactory.java` to initialize browser drivers and in page objects to interact with web elements.

### 3.2 Cucumber TestNG & Cucumber Java
**References:**
- https://mvnrepository.com/artifact/io.cucumber/cucumber-testng
- https://mvnrepository.com/artifact/io.cucumber/cucumber-java

**Why & When to Use:**
- **Purpose:** Cucumber TestNG enables running Cucumber scenarios through TestNG framework with BDD approach. Cucumber Java contains step definition classes and interfaces.
- **When:** Use to write behavior-driven tests in Gherkin language and execute them with TestNG runner.
- **In This Framework:** `MainRunner.java` uses Cucumber with TestNG to execute feature files and generate reports.

### 3.3 Cucumber Picocontainer
**References:**
- https://mvnrepository.com/artifact/io.cucumber/cucumber-picocontainer

**Why & When to Use:**
- **Purpose:** Picocontainer is a lightweight dependency injection framework that manages object creation and sharing across step definitions.
- **When:** Use when you need to share state between step definition classes (e.g., sharing driver instance).
- **In This Framework:** Enables sharing of WebDriver instance and other objects between `Contact_Us_Steps.java` and `Login_Steps.java` without explicit passing.

### 3.4 Apache Commons Lang3
**References:**
- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3

**Why & When to Use:**
- **Purpose:** Provides utility classes for common string, number, and collection operations.
- **When:** Use for string manipulation, checking null/empty values, object equality, and other utility operations.
- **In This Framework:** Can be used in step definitions and page objects for data processing and validation.

---

## 4. Browser Drivers & Automation Tools

### 4.1 ChromeDriver
**References:**
- https://developer.chrome.com/docs/chromedriver/downloads

**Why & When to Use:**
- **Purpose:** ChromeDriver is the WebDriver implementation for Google Chrome, enabling automation of Chrome browser.
- **When:** Use when testing on Google Chrome browser or for maximum compatibility with modern web features.
- **In This Framework:** `DriverFactory.java` uses ChromeDriver to initialize Chrome browser instance via `drivers/` folder.

### 4.2 GeckoDriver (Firefox Driver)
**References:**
- https://github.com/mozilla/geckodriver/releases

**Why & When to Use:**
- **Purpose:** GeckoDriver is the WebDriver implementation for Mozilla Firefox browser.
- **When:** Use when testing on Firefox browser for cross-browser compatibility validation.
- **In This Framework:** Can be configured in `DriverFactory.java` to support Firefox browser automation.

### 4.3 Browser Testing Tools
**References:**
- https://www.ranorex.com/selocity/browser-extension/

**Why & When to Use:**
- **Purpose:** Selocity is a browser extension that helps locate web elements using CSS selectors and XPath.
- **When:** Use to inspect elements and find reliable selectors during test script development.
- **In This Framework:** Helpful for identifying element locators to use in page objects.

---

## 5. Testing Practice Resources

### 5.1 WebDriverUniversity
**References:**
- https://www.webdriveruniversity.com/index.html

**Why & When to Use:**
- **Purpose:** WebDriverUniversity provides practice web applications specifically designed for testing Selenium automation.
- **When:** Use as a target application for writing and practicing test automation scripts.
- **In This Framework:** The framework likely targets pages on WebDriverUniversity for Contact Us and Login automation tests.

---

## 6. Gherkin & Cucumber Documentation

### 6.1 Gherkin Reference
**References:**
- https://cucumber.io/docs/gherkin/reference/

**Why & When to Use:**
- **Purpose:** Gherkin is a human-readable syntax for writing behavior-driven test scenarios.
- **When:** Use to understand and write Feature files with Given-When-Then syntax.
- **In This Framework:** `Contact_Us.feature` and `Login.feature` use Gherkin syntax for test scenarios.

### 6.2 Cucumber Expressions
**References:**
- https://github.com/cucumber/cucumber-expressions#readme

**Why & When to Use:**
- **Purpose:** Cucumber Expressions is a simpler alternative to Regex for mapping Gherkin steps to step definition methods.
- **When:** Use in step definitions to define step patterns. Example: `@When("user clicks on {string}")` instead of regex.
- **In This Framework:** Step definition methods use expressions to map Gherkin steps.

### 6.3 Cucumber API & Tags
**References:**
- https://cucumber.io/docs/cucumber/api/#running-cucumber
- https://cucumber.io/docs/cucumber/api/#tags

**Why & When to Use:**
- **Purpose:** Understand how Cucumber runs tests and how to use tags to organize and filter test execution.
- **When:** Use tags like `@smoke`, `@regression`, `@critical` in feature files to run specific test scenarios.
- **In This Framework:** `MainRunner.java` can use tags to selectively run scenarios.

### 6.4 Parallel Execution
**References:**
- https://cucumber.io/docs/guides/parallel-execution/

**Why & When to Use:**
- **Purpose:** Enables running multiple test scenarios in parallel to reduce overall execution time.
- **When:** Use for large test suites to significantly improve CI/CD pipeline speed.
- **In This Framework:** Can be configured in `MainRunner.java` via Cucumber options for parallel test execution.

---

## 7. Java Core Concepts & Best Practices

### 7.1 Access Modifiers
**References:**
- https://stackoverflow.com/questions/215497/what-is-the-difference-between-public-protected-package-private-and-private-in

**Why & When to Use:**
- **Purpose:** Control visibility and accessibility of classes, methods, and variables.
- **When & Usage:**
  - `public` - Accessible everywhere. Use for methods/classes that other classes need to use.
  - `protected` - Accessible in same package and subclasses. Use for base class methods that subclasses should override.
  - `package-private` (no modifier) - Accessible only in same package. Use for internal utility methods.
  - `private` - Accessible only in same class. Use for internal helper methods and variables.
- **In This Framework:**
  - Page objects extend `Base_PO` with protected/private element locators
  - `DriverFactory` has public methods to create drivers
  - `Global_Vars` uses public static constants

### 7.2 Inheritance (extends)
**References:**
- https://www.w3schools.com/java/ref_keyword_extends.asp

**Why & When to Use:**
- **Purpose:** Allow a child class to inherit properties and methods from a parent class, promoting code reuse.
- **When:** Create common functionality in a parent class that multiple child classes need.
- **In This Framework:**
  - `Contact_Us_PO.java` and `Login_PO.java` extend `Base_PO.java`
  - Base page object contains common element location and browser interaction methods
  - Reduces code duplication across page objects

### 7.3 super Keyword
**References:**
- https://www.w3schools.com/java/ref_keyword_super.asp

**Why & When to Use:**
- **Purpose:** Call parent class methods and constructors from child class.
- **When:** Use to initialize parent class or call overridden parent methods.
- **In This Framework:** Used in page objects to call base page object initialization and common methods.

### 7.4 static Keyword
**References:**
- https://www.w3schools.com/java/ref_keyword_static.asp

**Why & When to Use:**
- **Purpose:** Makes variables/methods belong to class rather than instances, accessed without object creation.
- **When & Usage:**
  - `static` methods - Utility methods that don't need object state. Example: `DriverFactory.createDriver()`
  - `static` variables - Shared across all instances. Example: constants in `Global_Vars.java`
- **In This Framework:**
  - `Global_Vars.java` uses static variables for global configuration
  - `DriverFactory` has static methods to manage driver instances
  - Reduces memory usage and provides global access to shared resources

### 7.5 final Keyword
**References:**
- https://www.w3schools.com/java/ref_keyword_final.asp

**Why & When to Use:**
- **Purpose:** Prevent modification, inheritance, or overriding of classes, methods, or variables.
- **When & Usage:**
  - `final` variables - Constants that cannot be changed. Example: `private final WebDriver driver;`
  - `final` methods - Cannot be overridden by child classes
  - `final` classes - Cannot be extended
- **In This Framework:** Used in page objects for immutable element locators and driver instances.

### 7.6 Java Methods & Parameters
**References:**
- https://www.w3schools.com/java/java_methods_param.asp

**Why & When to Use:**
- **Purpose:** Understand method definition, parameters, and return types.
- **When:** Design reusable methods with appropriate parameters and return values.
- **In This Framework:**
  - Step definition methods take Gherkin parameters
  - Page object methods take data for filling forms
  - Examples: `fillLoginForm(String username, String password)` or `clickElement(WebElement element)`

### 7.7 ThreadLocal
**References:**
- https://docs.oracle.com/javase/7/docs/api/java/lang/ThreadLocal.html

**Why & When to Use:**
- **Purpose:** Provides thread-local storage for variables, ensuring each thread has its own isolated instance.
- **When:** Essential for parallel test execution to prevent driver instance conflicts between threads.
- **In This Framework:** `DriverFactory.java` should use ThreadLocal to store WebDriver instances for thread-safe parallel execution:
  ```java
  private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
  ```

### 7.8 PageFactory
**References:**
- https://sqa.stackexchange.com/questions/27583/what-does-pagefactory-initelementsdriver-this-do

**Why & When to Use:**
- **Purpose:** PageFactory is Selenium's helper class for initializing WebElements using annotations (@FindBy).
- **When:** Use to initialize page object elements declaratively instead of manually finding them.
- **In This Framework:** Page objects can use `@FindBy` annotations and `PageFactory.initElements(driver, this)` for element initialization:
  ```java
  @FindBy(id = "username")
  private WebElement usernameField;
  
  public Contact_Us_PO(WebDriver driver) {
      PageFactory.initElements(driver, this);
  }
  ```

### 7.9 Page Object Model (POM)
**References:**
- https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/

**Why & When to Use:**
- **Purpose:** Design pattern that represents web pages as classes with element locators and interaction methods.
- **When:** Use to organize test code, improve maintainability, and reduce duplication.
- **In This Framework:**
  - `Contact_Us_PO.java` - Represents Contact Us page
  - `Login_PO.java` - Represents Login page
  - `Base_PO.java` - Contains common page object functionality
  - Provides single point of change when UI elements change

---

## 8. Project Structure Overview

```
JavaSelenium-BDD-FW-2025-Dec/
├── src/main/java/
│   ├── driver/
│   │   ├── DriverFactory.java         - Creates and manages browser drivers
│   │   └── drivers/                   - Browser driver executables
│   ├── pageObjects/
│   │   ├── Base_PO.java              - Common page object functionality
│   │   ├── Contact_Us_PO.java        - Contact Us page object
│   │   └── Login_PO.java             - Login page object
│   ├── properties/
│   │   └── config.properties         - Configuration settings
│   └── utils/
│       └── Global_Vars.java          - Global variables and constants
├── src/test/java/
│   ├── runners/
│   │   └── MainRunner.java           - Cucumber test runner
│   └── stepDefinitions/
│       ├── Contact_Us_Steps.java     - Contact Us scenario steps
│       └── Login_Steps.java          - Login scenario steps
├── src/test/resources/features/
│   ├── Contact_Us.feature            - Contact Us test scenarios
│   └── Login.feature                 - Login test scenarios
├── pom.xml                           - Maven configuration and dependencies
└── target/                           - Compiled classes and reports
```

---

## 9. Quick Reference: When to Use Each Reference

| Component | Use Case | Reference |
|-----------|----------|-----------|
| Setting up environment | Initial project setup on new machine | Java HOME setup guides |
| IDE setup | Development and debugging | IntelliJ IDEA download |
| Building project | Compile and run tests | Maven |
| Browser automation | Interact with web elements | Selenium WebDriver |
| Test framework | Execute BDD tests | Cucumber TestNG & Java |
| Dependency injection | Share objects between steps | Picocontainer |
| Writing tests | Create test scenarios | Gherkin Reference |
| Targeting test site | Practice and learn automation | WebDriverUniversity |
| Finding selectors | Identify element locators | Browser extensions, DevTools |
| Browser support | Test on different browsers | ChromeDriver, GeckoDriver |
| Code organization | Structure test code | Page Object Model |
| Thread safety | Parallel test execution | ThreadLocal |
| Element initialization | Declarative element mapping | PageFactory |
| Code quality | Utility functions and best practices | Java concepts & Apache Commons |

---

## 10. Implementation Checklist

Use this checklist when setting up or maintaining the framework:

- [ ] JDK installed and JAVA_HOME set
- [ ] Maven installed and configured
- [ ] IDE (IntelliJ) installed
- [ ] Project dependencies installed (`mvn clean install`)
- [ ] Browser drivers (ChromeDriver, GeckoDriver) in place
- [ ] Page objects follow POM pattern
- [ ] Step definitions use Cucumber expressions
- [ ] DriverFactory uses ThreadLocal for parallel execution
- [ ] Configuration properties properly set
- [ ] Tests run successfully with `mvn test`
- [ ] Feature files use proper Gherkin syntax
- [ ] Tags implemented for selective test execution
- [ ] Cucumber reports generated after test run

---

## 11. Common Maven Commands Reference

```bash
# Clean and install dependencies
mvn clean install

# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=MainRunner

# Run with specific tags
mvn test -Dcucumber.filter.tags="@smoke"

# Generate reports
mvn clean test -Dcucumber.publish.quiet=true

# Skip tests during build
mvn clean install -DskipTests

# View dependency tree
mvn dependency:tree
```

---

## 12. Troubleshooting Reference

| Issue | Likely Cause | Reference |
|-------|-------------|-----------|
| "mvn: command not found" | Maven not installed or PATH not set | Maven installation guide |
| Tests not running | Java or Maven PATH issues | Java HOME setup guides |
| Element not found | Incorrect selector in page object | Browser extensions for selector inspection |
| Driver initialization fails | Driver not in correct path or version mismatch | ChromeDriver/GeckoDriver downloads |
| Tests run sequentially | Parallel execution not configured | Cucumber parallel execution guide |
| State shared between tests | Missing dependency injection | Picocontainer integration |
| ThreadLocal issues | Improper driver cleanup | ThreadLocal documentation |

---

**Last Updated:** January 1, 2026
**Framework:** Java Selenium BDD Framework 2025-Dec
