# Complete Setup & Integration Guide
## Java Selenium BDD Framework for Enterprise Projects

This guide provides step-by-step instructions for developers to clone, configure, and integrate this framework into their company projects, regardless of IDE or operating system.

---

## Table of Contents
1. [Pre-Requisites & System Requirements](#1-pre-requisites--system-requirements)
2. [Step-by-Step Setup Guide](#2-step-by-step-setup-guide)
3. [IDE-Specific Configuration](#3-ide-specific-configuration)
4. [OS-Specific Configuration](#4-os-specific-configuration)
5. [Project Configuration](#5-project-configuration)
6. [Running Tests](#6-running-tests)
7. [Common Technical Issues & Solutions](#7-common-technical-issues--solutions)
8. [Best Practices for Enterprise Integration](#8-best-practices-for-enterprise-integration)
9. [Framework Customization Guide](#9-framework-customization-guide)
10. [CI/CD Pipeline Integration](#10-cicd-pipeline-integration)
11. [Team Collaboration Setup](#11-team-collaboration-setup)
12. [Troubleshooting Checklist](#12-troubleshooting-checklist)

---

## 1. Pre-Requisites & System Requirements

### 1.1 Minimum System Requirements

| Requirement | Minimum | Recommended |
|-------------|---------|-------------|
| RAM | 4 GB | 8 GB |
| Disk Space | 2 GB free | 5 GB free |
| CPU Cores | 2 cores | 4+ cores |
| Java Version | Java 8 | Java 11 or 17 |
| Maven Version | 3.6.3 | 3.8.1+ |
| Git | Latest | Latest |

### 1.2 Required Software Components

Before cloning the project, ensure you have:

```
✓ Java Development Kit (JDK)
✓ Maven Build Tool
✓ Git Version Control
✓ IDE (IntelliJ IDEA, Eclipse, or VS Code)
✓ Browser drivers (Chrome, Firefox)
✓ Internet connection (for downloading dependencies)
```

---

## 2. Step-by-Step Setup Guide

### 2.1 Step 1: Verify Java Installation

#### **Windows:**
```bash
java -version
javac -version
```

#### **Mac:**
```bash
java -version
javac -version
```

#### **Linux:**
```bash
java -version
javac -version
```

**Expected Output:**
```
java version "11.0.13" (or higher)
Java(TM) SE Runtime Environment
```

**If Java is Not Installed:**

**Windows:**
- Download JDK from https://jdk.java.net/archive/ or https://www.oracle.com/java/technologies/downloads/
- Run installer and follow wizard
- Verify installation: `java -version`

**Mac:**
```bash
# Using Homebrew (recommended)
brew install openjdk@11
# Or download from https://jdk.java.net/archive/

# Verify installation
java -version
```

**Linux (Ubuntu/Debian):**
```bash
sudo apt update
sudo apt install openjdk-11-jdk
java -version
```

**Linux (CentOS/RHEL):**
```bash
sudo yum install java-11-openjdk
java -version
```

### 2.2 Step 2: Set JAVA_HOME Environment Variable

This is **critical** for Maven to work properly.

#### **Windows:**

1. Find your JDK installation path (typically `C:\Program Files\Java\jdk-11.0.13`)
2. Open Environment Variables:
   - Right-click "This PC" or "My Computer" → Properties
   - Click "Advanced system settings" → "Environment Variables"
3. Click "New" under "System variables"
4. Variable name: `JAVA_HOME`
5. Variable value: `C:\Program Files\Java\jdk-11.0.13` (adjust version)
6. Click OK and restart terminal/IDE

**Verify:**
```bash
echo %JAVA_HOME%
```

#### **Mac:**

```bash
# Find Java installation
/usr/libexec/java_home -v 11

# Example output: /Library/Java/JavaVirtualMachines/jdk-11.0.13.jdk/Contents/Home

# Add to ~/.zprofile or ~/.bash_profile (depending on shell)
nano ~/.zprofile

# Add these lines:
export JAVA_HOME=$(/usr/libexec/java_home -v 11)
export PATH=$JAVA_HOME/bin:$PATH

# Save and exit (Ctrl+X, Y, Enter)

# Reload profile
source ~/.zprofile

# Verify
echo $JAVA_HOME
```

#### **Linux:**

```bash
# Find Java installation path
update-alternatives --list java
# Example: /usr/lib/jvm/java-11-openjdk-amd64/bin/java

# Add to ~/.bashrc or ~/.bash_profile
nano ~/.bashrc

# Add these lines:
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH

# Save and exit (Ctrl+X, Y, Enter)

# Reload profile
source ~/.bashrc

# Verify
echo $JAVA_HOME
```

### 2.3 Step 3: Verify Maven Installation

```bash
mvn -version
```

**Expected Output:**
```
Apache Maven 3.8.1 (or higher)
Maven home: /opt/apache-maven-3.8.1
Java version: 11.0.13
```

**If Maven is Not Installed:**

**Windows:**
1. Download from https://maven.apache.org/download.cgi (binary zip)
2. Extract to `C:\Apache\maven-3.8.1` (or preferred location)
3. Add to Environment Variables:
   - Variable name: `MAVEN_HOME`
   - Variable value: `C:\Apache\maven-3.8.1`
4. Edit PATH variable: Add `%MAVEN_HOME%\bin`
5. Restart terminal and verify: `mvn -version`

**Mac:**
```bash
# Using Homebrew
brew install maven
mvn -version

# Or manually:
# Download from Apache website, extract to /usr/local/
# Add to ~/.zprofile: export PATH=$PATH:/usr/local/maven-3.8.1/bin
```

**Linux:**
```bash
# Ubuntu/Debian
sudo apt install maven
mvn -version

# Or manually:
# Download, extract to /opt/maven/
# Add to ~/.bashrc: export PATH=$PATH:/opt/maven/bin
```

### 2.4 Step 4: Install Git

```bash
git --version
```

**If Not Installed:**

**Windows:** Download from https://git-scm.com/download/win

**Mac:**
```bash
brew install git
```

**Linux:**
```bash
sudo apt install git
```

### 2.5 Step 5: Clone the Project

```bash
# Navigate to desired location
cd /path/to/your/workspace

# Clone repository
git clone <repository-url>

# Navigate to project
cd JavaSelenium-BDD-FW-2025-Dec

# Verify project structure
ls -la
```

### 2.6 Step 6: Download Dependencies

```bash
# Navigate to project root
cd /path/to/JavaSelenium-BDD-FW-2025-Dec

# Download all dependencies (this may take 2-5 minutes)
mvn clean install -DskipTests

# Expected output ends with: BUILD SUCCESS
```

---

## 3. IDE-Specific Configuration

### 3.1 IntelliJ IDEA Setup

#### **Installation & Project Import:**

1. **Download & Install:**
   - Download from https://www.jetbrains.com/idea/download/?section=windows
   - Install and launch IntelliJ

2. **Import Project:**
   - File → Open
   - Navigate to project root folder
   - Click OK
   - When prompted: "Trust Project?" → Click "Trust Project"

3. **Configure JDK in IDE:**
   - File → Project Structure
   - Under "Project Settings" → "Project"
   - SDK: Click "Edit" or "New"
   - Select JDK home path (e.g., `/Library/Java/JavaVirtualMachines/jdk-11.0.13.jdk/Contents/Home`)
   - Click OK

4. **Enable Maven:**
   - View → Tool Windows → Maven
   - Maven toolbar appears on right side
   - Click "Refresh" (or hammer icon) to reload

5. **Mark Directories:**
   - Right-click `src/main/java` → Mark Directory as → Sources Root
   - Right-click `src/test/java` → Mark Directory as → Test Sources Root
   - Right-click `src/test/resources` → Mark Directory as → Test Resources Root

6. **Run Tests:**
   - Right-click `MainRunner.java`
   - Select "Run 'MainRunner'" or "Debug 'MainRunner'"

#### **Useful IntelliJ Plugins for BDD:**
- Gherkin (built-in)
- Cucumber for Java (built-in)
- Maven Integration (built-in)

---

### 3.2 Eclipse Setup

#### **Installation & Project Import:**

1. **Download & Install:**
   - Download from https://www.eclipse.org/downloads/packages/
   - Choose "Eclipse IDE for Java Developers"
   - Extract and launch

2. **Configure JDK:**
   - Windows/Preferences (Mac: Eclipse → Preferences)
   - Java → Installed JREs
   - Click "Add"
   - Directory: Select JDK installation path
   - Finish

3. **Import Project:**
   - File → Import
   - Maven → Existing Maven Projects
   - Browse to project root
   - Click Finish

4. **Configure Build Path:**
   - Right-click project → Build Path → Configure Build Path
   - Source tab: Ensure `src/main/java` and `src/test/java` are listed
   - Libraries tab: JRE System Library should be JDK version

5. **Update Maven Project:**
   - Right-click project → Maven → Update Project (or Alt+F5)
   - Ensure "Force Update of Snapshots/Releases" is checked
   - Click OK (dependencies download automatically)

6. **Run Tests:**
   - Right-click `MainRunner.java`
   - Run As → Java Application
   - Or use Maven: Right-click project → Run As → Maven test

#### **Useful Eclipse Plugins:**
- Install via Help → Eclipse Marketplace:
  - Cucumber Eclipse Plugin
  - TestNG Eclipse Plug-in

---

### 3.3 VS Code Setup

#### **Installation & Project Setup:**

1. **Download & Install:**
   - Download from https://code.visualstudio.com/
   - Install and launch VS Code

2. **Install Required Extensions:**
   - Open Extensions (Ctrl+Shift+X or Cmd+Shift+X)
   - Search and install:
     - "Extension Pack for Java" (Microsoft)
     - "Maven for Java" (Microsoft)
     - "Cucumber (Gherkin) Full Support" (Alexkrun.cucumber-full-support)
     - "TestNG Code Lens" (Ren Qian)

3. **Configure Java Home:**
   - Ctrl+Shift+P (or Cmd+Shift+P on Mac)
   - Type: "Java: Configure Java Runtime"
   - Select appropriate JDK version
   - Or edit `.vscode/settings.json`:
   ```json
   {
     "java.home": "/Library/Java/JavaVirtualMachines/jdk-11.0.13.jdk/Contents/Home",
     "java.configuration.updateBuildConfiguration": "automatic"
   }
   ```

4. **Open Project:**
   - File → Open Folder
   - Select project root
   - Trust the workspace when prompted

5. **Download Dependencies:**
   - Open Terminal (Ctrl+`)
   - Run: `mvn clean install -DskipTests`

6. **Run Tests:**
   - Open `MainRunner.java`
   - Click "Run Test" or "Debug Test" above the class
   - Or use Terminal: `mvn test`

#### **VS Code Workspace Settings (.vscode/settings.json):**

```json
{
  "[java]": {
    "editor.defaultFormatter": "redhat.java",
    "editor.formatOnSave": true
  },
  "java.import.maven.enabled": true,
  "maven.executable.preferMavenWrapper": true,
  "files.exclude": {
    "**/.classpath": true,
    "**/.project": true,
    "**/.settings": true,
    "**/target": false
  }
}
```

---

## 4. OS-Specific Configuration

### 4.1 Windows-Specific Issues & Solutions

#### **Issue 1: Paths with Spaces**
**Problem:** Project path with spaces (e.g., `C:\Users\User Name\...`)
**Solution:**
```bash
# Use quotes in command line
mvn clean install -DskipTests

# Or use short path name (8.3 format) if available
```

#### **Issue 2: Long Path Names**
**Problem:** Windows has 260-character path limit
**Solution:**
```bash
# Enable long paths in Windows 10/11
# Run as Administrator in PowerShell:
New-ItemProperty -Path "HKLM:\SYSTEM\CurrentControlSet\Control\FileSystem" -Name "LongPathsEnabled" -Value 1 -PropertyType DWORD -Force

# Restart computer
```

#### **Issue 3: Environment Variables Not Taking Effect**
**Problem:** Set JAVA_HOME but still getting path errors
**Solution:**
```bash
# Close and reopen all terminals/IDEs after setting env variables
# Verify with: echo %JAVA_HOME%
# If still not working, restart computer
```

#### **Issue 4: ChromeDriver Version Mismatch**
**Problem:** Tests fail with version mismatch error
**Solution:**
```bash
# Check Chrome version: Help → About Google Chrome
# Download matching ChromeDriver from:
# https://chromedriver.chromium.org/downloads

# Place in drivers/ folder with correct name:
# src/main/java/driver/drivers/chromedriver.exe
```

#### **Issue 5: Permission Denied for Driver Files**
**Problem:** Driver executable not executable
**Solution:**
```bash
# In file explorer, right-click chromedriver.exe
# Properties → General → Advanced → "Run this program as an administrator"
```

### 4.2 Mac-Specific Issues & Solutions

#### **Issue 1: "cannot be opened because the developer cannot be verified"**
**Problem:** macOS blocks unsigned driver executables
**Solution:**
```bash
# Navigate to drivers directory
cd src/main/java/driver/drivers/

# Allow execution
xattr -d com.apple.quarantine chromedriver
chmod +x chromedriver

# Or do it via System Preferences:
# Security & Privacy → General → Allow "chromedriver"
```

#### **Issue 2: M1/M2 Chip Compatibility**
**Problem:** Downloaded driver is for Intel, not ARM
**Solution:**
```bash
# Check architecture
arch

# Download appropriate ChromeDriver:
# - "Mac with Intel chip" for Intel-based Macs
# - "Mac with Apple Silicon" for M1/M2 Macs
# https://chromedriver.chromium.org/downloads
```

#### **Issue 3: JAVA_HOME Not Persisting**
**Problem:** Set JAVA_HOME in ~/.zprofile but doesn't persist
**Solution:**
```bash
# Ensure file is source in shell startup
nano ~/.zprofile

# Add at end:
export JAVA_HOME=$(/usr/libexec/java_home -v 11)

# Save and reload
source ~/.zprofile
```

#### **Issue 4: Maven Command Not Found**
**Problem:** `mvn: command not found`
**Solution:**
```bash
# Verify Maven installation
ls -la /usr/local/opt/maven/bin/

# Add to PATH in ~/.zprofile:
export PATH=/usr/local/opt/maven/bin:$PATH

# Or reinstall Maven:
brew install maven
brew link maven
```

### 4.3 Linux-Specific Issues & Solutions

#### **Issue 1: Repository/Credential Errors**
**Problem:** Cannot download dependencies from Maven Central
**Solution:**
```bash
# Check internet connection
ping google.com

# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install -DskipTests

# If still failing, check timezone:
timedatectl set-ntp true
```

#### **Issue 2: Driver Permission Denied**
**Problem:** `Permission denied` when running ChromeDriver
**Solution:**
```bash
# Make driver executable
chmod +x src/main/java/driver/drivers/chromedriver

# Or make all drivers executable
chmod +x src/main/java/driver/drivers/*
```

#### **Issue 3: Chrome/Chromium Not Installed**
**Problem:** Browser not found during test execution
**Solution:**
```bash
# Ubuntu/Debian
sudo apt install chromium-browser
# or
sudo apt install google-chrome-stable

# CentOS/RHEL
sudo yum install chromium

# Fedora
sudo dnf install chromium
```

#### **Issue 4: Display Issues (Headless Servers)**
**Problem:** Running on headless Linux server with no display
**Solution:**
```bash
# Install Xvfb (virtual frame buffer)
sudo apt install xvfb

# Run tests with virtual display
xvfb-run -a mvn test

# Or modify browser options for headless mode:
# In DriverFactory.java:
options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
```

#### **Issue 5: Java Version Conflicts**
**Problem:** Multiple Java versions installed, wrong one is default
**Solution:**
```bash
# List installed Java versions
update-alternatives --list java

# Set preferred version
sudo update-alternatives --config java

# Or explicitly set JAVA_HOME in ~/.bashrc:
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
```

---

## 5. Project Configuration

### 5.1 Understanding config.properties

**Location:** `src/main/resources/properties/config.properties`

**Default Content:**
```properties
# Browser Configuration
browser=chrome
# Options: chrome, firefox, edge

# Base URL
baseURL=https://www.webdriveruniversity.com

# Wait Times (in seconds)
implicitWait=10
explicitWait=15
pageLoadTimeout=20

# Logging
logLevel=INFO
# Options: DEBUG, INFO, WARN, ERROR

# Screenshot on Failure
takeScreenshot=true

# Headless Mode
headlessMode=false
```

### 5.2 Customizing Configuration for Your Project

1. **Identify Your Application URL:**
   ```properties
   baseURL=https://your-company-app.com
   ```

2. **Set Default Browser:**
   ```properties
   browser=chrome
   ```

3. **Adjust Timeouts Based on App Speed:**
   ```properties
   implicitWait=10      # Wait for elements to appear
   explicitWait=15      # Wait for specific conditions
   pageLoadTimeout=20   # Wait for page load
   ```

4. **Enable/Disable Features:**
   ```properties
   takeScreenshot=true      # For debugging
   headlessMode=false       # Set true for CI/CD
   ```

### 5.3 Multi-Environment Configuration

Create separate property files:

```
properties/
├── config.properties           # Base configuration
├── config.dev.properties       # Development
├── config.qa.properties        # QA Environment
├── config.staging.properties   # Staging
└── config.prod.properties      # Production
```

**Load based on environment:**
```bash
# Development
mvn test -Denvironment=dev

# QA
mvn test -Denvironment=qa

# Modify MainRunner.java to load appropriate file
```

### 5.4 Database Configuration (if needed)

Add to pom.xml if you need database testing:
```xml
<!-- MySQL Driver -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.32</version>
</dependency>

<!-- Oracle Database -->
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <version>21.7.0.0</version>
</dependency>
```

---

## 6. Running Tests

### 6.1 Running Tests from IDE

#### **IntelliJ IDEA:**
```bash
# Right-click MainRunner.java → Run 'MainRunner'
# Or press Ctrl+Shift+F10 (Windows/Linux) or Cmd+Shift+R (Mac)

# Right-click feature file → Run 'Feature Name'
# Or right-click scenario → Run 'Scenario'
```

#### **Eclipse:**
```bash
# Right-click MainRunner.java → Run As → Java Application
# Or Alt+Shift+X, J

# Right-click feature file → Run As → Cucumber Feature
```

#### **VS Code:**
```bash
# Click "Run Test" above class name
# Or press Ctrl+F5 (Windows/Linux) or Cmd+F5 (Mac)
```

### 6.2 Running Tests from Command Line

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=MainRunner

# Run with specific tags
mvn test -Dcucumber.filter.tags="@smoke"

# Run with multiple tags (AND logic)
mvn test -Dcucumber.filter.tags="@smoke and @regression"

# Run with multiple tags (OR logic)
mvn test -Dcucumber.filter.tags="@smoke or @critical"

# Run specific feature file
mvn test -Dcucumber.features="src/test/resources/features/Login.feature"

# Run with specific threads (parallel execution)
mvn test -Dthreads=4

# Run with skip compilation
mvn test -o

# Run with output to log file
mvn test > test-execution.log 2>&1
```

### 6.3 Viewing Test Reports

**After test execution:**

```bash
# Cucumber HTML Report
open target/cucumber-html-reports/overview-features.html

# Maven Surefire Report
open target/surefire-reports/index.html

# Or on Linux:
firefox target/cucumber-html-reports/overview-features.html
```

---

## 7. Common Technical Issues & Solutions

### Issue Category 1: Java & Environment Issues

| Issue | Cause | Solution |
|-------|-------|----------|
| `mvn: command not found` | Maven not in PATH | Add Maven to system PATH or reinstall |
| `'java' is not recognized` | Java not in PATH or JAVA_HOME not set | Set JAVA_HOME and add to PATH |
| `JAVA_HOME not set or invalid` | JAVA_HOME environment variable missing | Set JAVA_HOME to JDK installation path |
| `Unsupported class version` | Java version mismatch (compiled with newer version) | Use Java 11+ or recompile with lower version |

**Quick Fix Script:**

**Windows:**
```batch
@echo off
echo Checking Java installation...
java -version
echo.
echo Checking Maven installation...
mvn -version
echo.
echo Checking JAVA_HOME...
echo %JAVA_HOME%
pause
```

**Mac/Linux:**
```bash
#!/bin/bash
echo "Checking Java installation..."
java -version
echo ""
echo "Checking Maven installation..."
mvn -version
echo ""
echo "Checking JAVA_HOME..."
echo $JAVA_HOME
```

### Issue Category 2: Maven & Build Issues

| Issue | Cause | Solution |
|-------|-------|----------|
| `BUILD FAILURE: Missing dependencies` | No internet or corrupted repo | Run `mvn clean install -U` |
| `Plugin not found` | Incorrect plugin version | Check pom.xml and update plugin versions |
| `Cannot find symbol` | Compilation error in source code | Check syntax, compile with `mvn compile` |
| `Tests skipped` | Tests marked as skipped or filtered out | Check tags, run `mvn test -Dcucumber.filter.tags=""` |

**Recovery Commands:**
```bash
# Complete rebuild from scratch
mvn clean

# Install dependencies forcing update
mvn install -U

# Clear local Maven repository cache
rm -rf ~/.m2/repository
mvn clean install -DskipTests

# Check dependencies tree
mvn dependency:tree
```

### Issue Category 3: WebDriver & Browser Issues

| Issue | Cause | Solution |
|-------|-------|----------|
| `SessionNotCreatedException` | Driver version ≠ Browser version | Download matching driver version |
| `WebDriver not found in PATH` | Driver file missing or not executable | Place driver in correct folder, make executable |
| `Chrome/Firefox not installed` | Browser not available on system | Install browser or change browser in config |
| `Port already in use` (ChromeDriver) | Multiple driver instances running | Kill previous processes, increase port numbers |
| `Headless mode issues` | Headless browser doesn't support certain operations | Disable headless or add headless-specific options |

**Quick Fixes:**

**Windows (Kill Chrome processes):**
```batch
taskkill /F /IM chromedriver.exe
taskkill /F /IM chrome.exe
```

**Mac/Linux (Kill Chrome processes):**
```bash
pkill -f chromedriver
pkill -f chrome
```

**Check Chrome Version:**
```bash
# Windows (PowerShell)
(Get-Item "C:\Program Files\Google\Chrome\Application\chrome.exe").VersionInfo.FileVersion

# Mac
/Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --version

# Linux
google-chrome --version
# or
chromium-browser --version
```

### Issue Category 4: Test Execution Issues

| Issue | Cause | Solution |
|-------|-------|----------|
| `No scenarios to run` | Feature files not found or no matching tags | Check feature file path, verify tag syntax |
| `Tests run sequentially instead of parallel` | Parallel execution not configured | Configure thread count in MainRunner or command line |
| `Element not found exceptions` | Incorrect locators or element not loaded | Update selectors, increase wait times |
| `Stale element reference` | Element DOM reference outdated | Refactor locators, re-find element |
| `Tests pass locally but fail in CI/CD` | Environment differences, missing drivers | Configure headless mode, ensure drivers in repo |

**Debugging Commands:**
```bash
# Run with debug output
mvn test -X

# Run single feature file
mvn test -Dcucumber.features="src/test/resources/features/Login.feature"

# Run with detailed logging
mvn test -Dlog4j.configuration=file:log4j.properties

# Run tests with pause for debugging
mvn test -Dmaven.failsafe.debug
```

### Issue Category 5: IDE-Specific Issues

#### **IntelliJ:**
```
Issue: "Cannot find symbol" despite correct code
Solution:
- File → Invalidate Caches → Invalidate and Restart
- Project → Rebuild Project
- Ensure SDK is correctly set (Project Structure)
```

#### **Eclipse:**
```
Issue: "The type TestNG cannot be resolved"
Solution:
- Right-click project → Maven → Update Project (Alt+F5)
- Project → Clean
- If persists: Delete project (not files) and reimport
```

#### **VS Code:**
```
Issue: "Cannot resolve symbol" or "Java extension errors"
Solution:
- Reload Window (Ctrl+Shift+P → Reload Window)
- Delete .classpath and .project files
- Run "Java: Clean Language Server Workspace"
```

---

## 8. Best Practices for Enterprise Integration

### 8.1 Code Organization & Maintenance

**1. Page Object Naming Convention:**
```
LoginPage_PO.java       (not: LoginPageObject.java)
ContactUsPage_PO.java   (not: ContactUs.java)
DashboardPage_PO.java   (not: Dashboard_Page_Object.java)
```

**2. Step Definition Naming:**
```
LoginSteps.java
ContactUsSteps.java
CommonSteps.java (for shared steps)
```

**3. Feature File Organization:**
```
features/
├── auth/
│   ├── Login.feature
│   └── Logout.feature
├── contact/
│   └── ContactUs.feature
└── dashboard/
    └── Dashboard.feature
```

### 8.2 Version Control Best Practices

**1. .gitignore Configuration:**
```
# Maven
target/
*.class
*.jar

# IDE
.idea/
.classpath
.project
.settings/
*.iml
.vscode/

# Drivers (if large)
src/main/java/driver/drivers/*.exe
src/main/java/driver/drivers/*.zip

# Logs and reports
*.log
test-output/
reports/

# OS
.DS_Store
Thumbs.db
```

**2. Git Workflow:**
```bash
# Create feature branch for new tests
git checkout -b feature/new-test-suite

# Make changes and commit
git add .
git commit -m "Add: New login test scenarios"

# Push to origin
git push origin feature/new-test-suite

# Create pull request for review
# After approval, merge to main/develop branch
```

### 8.3 Test Data Management

**1. Create test data directory:**
```
src/test/resources/
├── features/
├── testData/
│   ├── login_testdata.json
│   ├── contact_testdata.csv
│   └── user_credentials.properties
└── config.properties
```

**2. Externalize test data:**
```json
// testData/login_testdata.json
{
  "validUser": {
    "email": "user@example.com",
    "password": "SecurePass123!"
  },
  "invalidUser": {
    "email": "invalid@example.com",
    "password": "WrongPassword"
  }
}
```

**3. Load test data in step definitions:**
```java
@Given("User enters valid login credentials")
public void user_enters_valid_credentials() {
    // Load from JSON/CSV/Properties file
    String testData = FileUtils.readTestData("login_testdata.json");
    // Use test data
}
```

### 8.4 Logging & Reporting

**1. Add Logging (log4j2 or SLF4J):**
```xml
<!-- Add to pom.xml -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.17.1</version>
</dependency>
```

**2. Enable detailed reports:**
```bash
# Run with HTML report generation
mvn test -Dcucumber.publish.quiet=true

# Generate with plugin report
mvn test post-integration-test
```

### 8.5 Code Quality Standards

**1. Add spotbugs for bug detection:**
```xml
<plugin>
    <groupId>com.github.spotbugs</groupId>
    <artifactId>spotbugs-maven-plugin</artifactId>
    <version>4.7.0.1</version>
</plugin>
```

**2. Use CheckStyle for code standards:**
```bash
mvn checkstyle:check
```

**3. Code coverage with JaCoCo:**
```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.7</version>
</plugin>
```

---

## 9. Framework Customization Guide

### 9.1 Adding New Page Objects

**1. Create new page object:**
```java
// src/main/java/pageObjects/ProfilePage_PO.java
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage_PO extends Base_PO {
    
    // Element locators
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    
    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    private WebElement saveButton;
    
    // Constructor
    public ProfilePage_PO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    // Page methods
    public void enterFirstName(String firstName) {
        clearAndType(firstNameField, firstName);
    }
    
    public void clickSaveButton() {
        clickElement(saveButton);
    }
}
```

**2. Add step definitions:**
```java
// src/test/java/stepDefinitions/ProfileSteps.java
package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.ProfilePage_PO;
import org.openqa.selenium.WebDriver;

public class ProfileSteps {
    
    private WebDriver driver;
    private ProfilePage_PO profilePage;
    
    public ProfileSteps(WebDriver driver) {
        this.driver = driver;
        this.profilePage = new ProfilePage_PO(driver);
    }
    
    @When("User enters first name {string}")
    public void user_enters_first_name(String firstName) {
        profilePage.enterFirstName(firstName);
    }
    
    @When("User clicks save button")
    public void user_clicks_save_button() {
        profilePage.clickSaveButton();
    }
}
```

**3. Create feature file:**
```gherkin
# src/test/resources/features/Profile.feature
Feature: User Profile Management
    
    Background:
        Given User is logged in
        And User navigates to profile page
    
    Scenario: Update user profile
        When User enters first name "John"
        And User clicks save button
        Then Profile should be updated successfully
```

### 9.2 Adding New Drivers

**If you need to support Edge or Safari:**

```java
// In DriverFactory.java
public static WebDriver createDriver(String browserName) {
    switch(browserName.toLowerCase()) {
        case "edge":
            return createEdgeDriver();
        case "safari":
            return createSafariDriver();
        default:
            return createChromeDriver();
    }
}

private static WebDriver createEdgeDriver() {
    System.setProperty("webdriver.edge.driver", 
        "path/to/msedgedriver");
    EdgeOptions options = new EdgeOptions();
    options.addArguments("--start-maximized");
    return new EdgeDriver(options);
}
```

### 9.3 Adding Custom Utilities

**Create utility class for common operations:**

```java
// src/main/java/utils/WaitUtils.java
package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitUtils {
    
    public static WebElement waitForElement(WebDriver driver, 
        WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, 
            java.time.Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public static void waitForElementToBeClickable(WebDriver driver, 
        WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, 
            java.time.Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
```

---

## 10. CI/CD Pipeline Integration

### 10.1 GitHub Actions Example

**Create `.github/workflows/tests.yml`:**

```yaml
name: Automated Tests

on:
  push:
    branches: [ main, develop ]
  pull_request:
    branches: [ main, develop ]

jobs:
  test:
    runs-on: ubuntu-latest
    
    strategy:
      matrix:
        java-version: [11, 17]
    
    steps:
    - uses: actions/checkout@v3
    
    - name: Set up JDK
      uses: actions/setup-java@v3
      with:
        java-version: ${{ matrix.java-version }}
    
    - name: Install Chrome
      run: sudo apt-get install -y chromium-browser
    
    - name: Run tests
      run: mvn clean test -Dheadlessmode=true
    
    - name: Upload reports
      if: always()
      uses: actions/upload-artifact@v3
      with:
        name: cucumber-reports
        path: target/cucumber-html-reports/
```

### 10.2 Jenkins Pipeline Example

**Jenkinsfile:**
```groovy
pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/company/selenium-bdd-fw.git'
            }
        }
        
        stage('Setup') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        
        stage('Run Tests') {
            steps {
                sh 'mvn test -Dcucumber.filter.tags="@regression"'
            }
        }
        
        stage('Generate Report') {
            steps {
                publishHTML([
                    reportDir: 'target/cucumber-html-reports',
                    reportFiles: 'overview-features.html',
                    reportName: 'Cucumber Report'
                ])
            }
        }
    }
    
    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
```

### 10.3 GitLab CI Example

**.gitlab-ci.yml:**
```yaml
stages:
  - test

test:
  stage: test
  image: maven:3.8.1-openjdk-11
  script:
    - mvn clean test -Dheadlessmode=true
  artifacts:
    reports:
      junit: target/surefire-reports/*.xml
    paths:
      - target/cucumber-html-reports/
    expire_in: 30 days
  only:
    - merge_requests
    - main
    - develop
```

---

## 11. Team Collaboration Setup

### 11.1 Onboarding New Team Members

**Checklist for new developers:**

```markdown
# New Developer Onboarding Checklist

## System Setup (Day 1)
- [ ] Install JDK 11+
- [ ] Set JAVA_HOME environment variable
- [ ] Install Maven
- [ ] Install Git
- [ ] Install IDE (IntelliJ/Eclipse/VS Code)

## Project Setup (Day 1)
- [ ] Clone repository: `git clone <repo-url>`
- [ ] Download dependencies: `mvn clean install -DskipTests`
- [ ] Configure IDE (import as Maven project)
- [ ] Run verification test: `mvn test`

## Framework Understanding (Day 1-2)
- [ ] Read README.md and QUICK_START.md
- [ ] Review page objects structure
- [ ] Review step definitions
- [ ] Understand feature file syntax
- [ ] Understand Global_Vars and config.properties

## First Contribution (Day 2-3)
- [ ] Create feature branch: `git checkout -b feature/initial-tests`
- [ ] Add first test scenario
- [ ] Add page object for tested page
- [ ] Add step definitions
- [ ] Run locally and verify: `mvn test`
- [ ] Create pull request for review

## Knowledge Transfer (Ongoing)
- [ ] Pair programming with senior tester
- [ ] Code review practice
- [ ] Attend framework sync meetings
- [ ] Document learnings in team wiki
```

### 11.2 Code Review Standards

**Pull Request Template (.github/pull_request_template.md):**

```markdown
## Description
Brief description of changes

## Type of Change
- [ ] New test scenarios
- [ ] New page objects
- [ ] Bug fix
- [ ] Framework improvement
- [ ] Configuration update

## Related Issues
Fixes #(issue number)

## How Has This Been Tested?
- [ ] Ran locally: `mvn test`
- [ ] All tests passed
- [ ] Ran with specific tags: `mvn test -Dcucumber.filter.tags="@tag"`

## Checklist
- [ ] Code follows project conventions
- [ ] New tests added/updated
- [ ] Page objects created/updated
- [ ] Feature files created/updated
- [ ] Configuration updated if needed
- [ ] No hardcoded values (use config.properties)
- [ ] Comments added for complex logic
- [ ] No sensitive data committed

## Screenshots/Evidence
(if applicable)
```

### 11.3 Communication & Documentation

**Maintain up-to-date documentation:**

```
Documentation/
├── Setup_Guide.md           # This file
├── Framework_Architecture.md
├── Page_Object_Guidelines.md
├── Test_Data_Management.md
├── Troubleshooting.md
└── FAQ.md
```

---

## 12. Troubleshooting Checklist

Use this comprehensive checklist when issues arise:

### Pre-Test Execution Checklist
- [ ] Java installed and version verified (`java -version`)
- [ ] JAVA_HOME set correctly (`echo $JAVA_HOME` or `echo %JAVA_HOME%`)
- [ ] Maven installed (`mvn -version`)
- [ ] Git installed (`git --version`)
- [ ] Project cloned successfully
- [ ] Dependencies downloaded (`mvn clean install -DskipTests`)
- [ ] IDE opened and project imported
- [ ] JDK configured in IDE
- [ ] Maven configured in IDE
- [ ] Source directories marked correctly
- [ ] Browser installed (Chrome/Firefox)
- [ ] Browser driver present and executable

### Test Execution Troubleshooting
- [ ] Run `mvn clean compile` - check for compilation errors
- [ ] Run `mvn test` - attempt basic test execution
- [ ] Check feature files exist: `ls src/test/resources/features/`
- [ ] Verify step definitions exist for all Gherkin steps
- [ ] Check page objects for correct element locators
- [ ] Verify config.properties has correct base URL
- [ ] Check ChromeDriver/GeckoDriver version matches browser
- [ ] Make driver executable: `chmod +x src/main/java/driver/drivers/*`
- [ ] Try running single feature: `mvn test -Dcucumber.features="..."`
- [ ] Check logs for detailed error messages

### Environment-Specific Troubleshooting

**If on Windows:**
- [ ] Disable antivirus temporarily during test execution
- [ ] Check for long file paths (>260 chars) - enable long paths
- [ ] Use forward slashes in properties files: `C:/path/to/file`
- [ ] Run IDE as Administrator if permission issues

**If on Mac:**
- [ ] Remove quarantine from driver: `xattr -d com.apple.quarantine chromedriver`
- [ ] Make driver executable: `chmod +x chromedriver`
- [ ] Check M1/M2 chip compatibility for drivers
- [ ] Reload shell profile: `source ~/.zprofile`

**If on Linux:**
- [ ] Make driver executable: `chmod +x chromedriver`
- [ ] For headless servers, use: `xvfb-run -a mvn test`
- [ ] Install required packages: `sudo apt install chromium-browser`
- [ ] Check timezone: `timedatectl` and `timedatectl set-ntp true`

### Network & Repository Troubleshooting
- [ ] Check internet connection
- [ ] Clear Maven cache: `rm -rf ~/.m2/repository`
- [ ] Retry with force update: `mvn clean install -U`
- [ ] Check corporate proxy settings (if applicable)
- [ ] Verify Maven Central availability

### Last Resort Actions
1. **Complete clean rebuild:**
   ```bash
   # Remove everything build-related
   mvn clean
   rm -rf ~/.m2/repository
   
   # Rebuild from scratch
   mvn clean install -DskipTests -U
   ```

2. **Delete IDE cache and reimport:**
   ```
   IntelliJ: Delete .idea/ folder
   Eclipse: Delete .classpath, .project, .settings/
   VS Code: Delete .vscode/ folder
   
   Then reimport project
   ```

3. **Verify with fresh clone (if all else fails):**
   ```bash
   mkdir test-workspace
   cd test-workspace
   git clone <repo-url>
   cd project
   mvn clean install -DskipTests
   mvn test
   ```

---

## Quick Start Commands Reference

```bash
# Initial setup
git clone <repository-url>
cd JavaSelenium-BDD-FW-2025-Dec
mvn clean install -DskipTests

# Running tests
mvn test                                          # All tests
mvn test -Dtest=MainRunner                       # Specific runner
mvn test -Dcucumber.filter.tags="@smoke"         # With tags
mvn test -Dcucumber.features="path/to/file.feature" # Specific feature

# Debugging
mvn compile                                       # Check syntax
mvn test -X                                       # Verbose output
mvn dependency:tree                              # Check dependencies

# Parallel execution
mvn test -Dthreads=4                             # 4 parallel threads

# Clean and rebuild
mvn clean
mvn install -DskipTests
```

---

## Support & Resources

- **Framework References:** See FRAMEWORK_REFERENCES_GUIDE.md
- **Project README:** README.md
- **Quick Start:** QUICK_START.md
- **Feature Documentation:** https://cucumber.io/docs/
- **Selenium Documentation:** https://www.selenium.dev/documentation/
- **Maven Documentation:** https://maven.apache.org/

---

**Last Updated:** January 1, 2026
**Framework Version:** 2025-Dec
**Supported Java Versions:** 8, 11, 17, 21
**Supported IDEs:** IntelliJ IDEA, Eclipse, VS Code
**Supported OS:** Windows, macOS, Linux
