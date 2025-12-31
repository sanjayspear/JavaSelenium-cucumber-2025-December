# Setup and Run Guide

Complete step-by-step instructions for cloning and running this Java Selenium Cucumber Framework on your machine.

---

## 📋 Prerequisites Check

Before you start, ensure your system has:

### 1. **Java 21 or 17**

Check if installed:
```bash
java -version
```

**Expected Output:**
```
openjdk version "21.0.1" 2023-10-17
OpenJDK Runtime Environment (build 21.0.1+12-29)
```

**If not installed:**
- Download from: [java.oracle.com](https://www.oracle.com/java/technologies/downloads/)
- Or: [openjdk.java.net](https://openjdk.java.net/)
- Install and follow setup wizard

---

### 2. **Maven 3.6+**

Check if installed:
```bash
mvn -version
```

**Expected Output:**
```
Apache Maven 3.9.5 (57804ffe001d7215b5e7bcb531cf83df38f93546)
Maven home: C:\Program Files\Apache\maven-3.9.5
```

**If not installed:**
1. Download from: [maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
2. Extract to a folder (e.g., `C:\Program Files\Maven`)
3. Add to Windows PATH:
   - Open Environment Variables
   - Add Maven bin folder to PATH
   - Restart terminal

---

### 3. **Git**

Check if installed:
```bash
git --version
```

**Expected Output:**
```
git version 2.42.0.windows.1
```

**If not installed:**
- Download from: [git-scm.com](https://git-scm.com)
- Install with default settings

---

### 4. **Chrome Browser (Latest Version)**

- Download from: [google.com/chrome](https://www.google.com/chrome)
- Install normally

---

## 🚀 Clone the Project (5 minutes)

### Step 1: Open Terminal/Command Prompt

**Windows:**
- Press `Win + R`
- Type `cmd`
- Press Enter

**Mac/Linux:**
- Open Terminal application

---

### Step 2: Navigate to Your Desired Folder

```bash
# Go to Desktop
cd Desktop

# Or go to Documents
cd Documents

# Or any folder you prefer
cd /path/to/your/folder
```

---

### Step 3: Clone the Repository

Replace `<REPO_URL>` with your actual Git repository URL:

```bash
git clone <REPO_URL>
```

**Example:**
```bash
git clone https://github.com/your-company/JavaSelenium-BDD-FW-2025-Dec.git
```

**What happens:**
- Creates a folder named `JavaSelenium-BDD-FW-2025-Dec`
- Downloads all project files
- Takes 1-2 minutes depending on internet speed

---

### Step 4: Navigate to Project Folder

```bash
cd JavaSelenium-BDD-FW-2025-Dec
```

Verify you're in the right folder:
```bash
dir          # Windows
ls           # Mac/Linux
```

You should see: `pom.xml`, `src/`, `README.md`, etc.

---

## ⚙️ Setup Environment (10 minutes)

### Step 1: Install Maven Dependencies

```bash
mvn clean install
```

**What it does:**
- Downloads all required libraries
- Compiles the project
- Runs setup checks

**Expected Output:**
```
[INFO] BUILD SUCCESS
[INFO] Total time: X.XXs
```

**Note:** First time may take 3-5 minutes. Subsequent runs are faster.

---

### Step 2: Download WebDriver

Download ChromeDriver matching your Chrome version:

1. Check your Chrome version:
   - Open Chrome
   - Click ⋮ (menu)
   - Click "Help" → "About Google Chrome"
   - Note the version number

2. Download ChromeDriver:
   - Go to [chromedriver.chromium.org](https://chromedriver.chromium.org)
   - Download matching your Chrome version
   - Extract the `.exe` file

3. Place in project:
   - Copy `chromedriver.exe`
   - Paste in: `src/main/java/driver/drivers/`
   - Folder path should look like:
     ```
     JavaSelenium-BDD-FW-2025-Dec/
     └── src/
         └── main/
             └── java/
                 └── driver/
                     └── drivers/
                         └── chromedriver.exe  ← HERE
     ```

---

### Step 3: Verify Setup

```bash
# Check if WebDriver is in place
dir src\main\java\driver\drivers\    # Windows
ls src/main/java/driver/drivers/     # Mac/Linux
```

You should see: `chromedriver.exe` (or `chromedriver` on Mac/Linux)

---

## ✅ Run Tests (5 minutes)

### Option 1: Run All Tests (Recommended for First Time)

```bash
mvn clean test
```

**What happens:**
1. Clears previous builds
2. Opens browser automatically
3. Runs all test scenarios
4. Generates reports
5. Closes browser

**Expected Output:**
```
[INFO] BUILD SUCCESS
```

**Watch the magic:**
- Chrome browser will open
- Tests will run automatically
- Browser will close
- Results will be printed

---

### Option 2: Run Specific Tests

```bash
# Run Login tests only
mvn clean test -Dcucumber.filter.name="Login"

# Run Contact Us tests only
mvn clean test -Dcucumber.filter.name="Contact"

# Run @smoke tagged tests
mvn clean test -Dcucumber.filter.tags="@smoke"

# Run @regression tagged tests
mvn clean test -Dcucumber.filter.tags="@regression"
```

---

### Option 3: Run with Different Browser

**Chrome (default):**
```bash
mvn clean test -Dbrowser=chrome
```

**Firefox:**
```bash
mvn clean test -Dbrowser=firefox
```

(Make sure Firefox is installed and GeckoDriver is in `drivers/` folder)

---

### Option 4: Dry Run (Check Steps Without Running)

```bash
mvn clean test -Dcucumber.filter.dry-run=true
```

Useful to verify all step definitions are implemented.

---

## 📊 View Test Results (2 minutes)

After tests complete, view the HTML report:

### Step 1: Open Report Folder

```bash
# Navigate to report location
cd target/cucumber
```

### Step 2: Open Report in Browser

**Windows:**
```bash
start index.html
```

**Mac:**
```bash
open index.html
```

**Linux:**
```bash
xdg-open index.html
```

### Step 3: Review Results

You'll see:
- ✅ Passed tests (green)
- ❌ Failed tests (red)
- ⏱️ Time taken
- 📸 Screenshots of failures
- 📝 Step-by-step execution details

---

## 🐛 Troubleshooting

### Error: "Java is not recognized"

**Solution:**
```bash
# Check Java installation
java -version

# If not found:
# 1. Reinstall Java
# 2. Set JAVA_HOME environment variable
# 3. Add Java to PATH
# 4. Restart terminal/IDE
```

---

### Error: "Maven is not recognized"

**Solution:**
```bash
# Check Maven installation
mvn -version

# If not found:
# 1. Reinstall Maven
# 2. Add Maven bin folder to PATH
# 3. Restart terminal/IDE
```

---

### Error: "WebDriver not found" or "chromedriver.exe not found"

**Solution:**
1. Download ChromeDriver again (matching Chrome version)
2. Verify path: `src/main/java/driver/drivers/chromedriver.exe`
3. Check filename is exactly `chromedriver.exe` (Windows)
4. On Mac/Linux, no `.exe` extension

```bash
# Verify it exists
ls src/main/java/driver/drivers/    # Mac/Linux
dir src\main\java\driver\drivers\   # Windows
```

---

### Error: "Step is undefined"

**Solution:**
```bash
# Run dry-run to see undefined steps
mvn clean test -Dcucumber.filter.dry-run=true

# Then check step definitions in:
src/test/java/stepDefinitions/
```

---

### Error: "BUILD FAILURE" with NoSuchElementException

**Solution:**
1. Element locator may be wrong
2. Page may take time to load
3. Try adding wait time in step definition
4. Check if website is accessible

---

### Error: "Port already in use"

**Solution:**
```bash
# Kill any running Java processes
# Windows - Find Java process in Task Manager and end it
# Mac/Linux
lsof -i :8080  # Check if port 8080 is in use
kill -9 <PID>  # Kill the process
```

---

### Error: "Cannot find Chrome browser"

**Solution:**
1. Install Chrome: [google.com/chrome](https://www.google.com/chrome)
2. Ensure Chrome is in default location
3. Or specify Chrome path in `config.properties`

---

## 📝 Quick Command Reference

| Task | Command |
|------|---------|
| Clone project | `git clone <URL>` |
| Install dependencies | `mvn clean install` |
| Run all tests | `mvn clean test` |
| Run specific feature | `mvn clean test -Dcucumber.filter.name="Feature"` |
| Run by tag | `mvn clean test -Dcucumber.filter.tags="@smoke"` |
| Run with Firefox | `mvn clean test -Dbrowser=firefox` |
| Dry run (no execution) | `mvn clean test -Dcucumber.filter.dry-run=true` |
| View Java version | `java -version` |
| View Maven version | `mvn -version` |

---

## ✨ Your First Run Checklist

- [ ] Java installed and working (`java -version`)
- [ ] Maven installed and working (`mvn -version`)
- [ ] Git installed and working (`git --version`)
- [ ] Chrome browser installed
- [ ] Repository cloned successfully
- [ ] Navigated to project folder
- [ ] `mvn clean install` completed successfully
- [ ] ChromeDriver downloaded and placed in `src/main/java/driver/drivers/`
- [ ] ChromeDriver version matches Chrome version
- [ ] First test run completed: `mvn clean test`
- [ ] Report generated in `target/cucumber/index.html`

---

## 🎯 Next Steps After First Run

1. **Read the Quick Start Guide:**
   ```bash
   # Open QUICK_START.md
   ```

2. **Understand the Structure:**
   - Read [README.md](README.md) sections on architecture and components

3. **Write Your First Test:**
   - Follow the "Writing Your First Test" section in QUICK_START.md

4. **Explore Existing Tests:**
   - Check Login.feature
   - Check Contact_Us.feature
   - Understand how they work

5. **Get Help:**
   - Read [README.md](README.md) troubleshooting section
   - Check QUICK_START.md for common mistakes
   - Ask your team lead

---

## 💡 Pro Tips

1. **Use IDE:**
   - Install IntelliJ IDEA or Eclipse
   - Much easier than command line
   - Built-in Maven support

2. **Configure IDE:**
   - Open project in IDE
   - IDE will auto-download dependencies
   - IDE will highlight Gherkin syntax

3. **Use Git Properly:**
   - Create your own branch before making changes
   - Never commit to main/master directly
   - Follow team's Git workflow

4. **Keep Updated:**
   - Pull latest changes regularly:
     ```bash
     git pull origin main
     ```
   - Resolve conflicts if any

5. **Run Tests Before Push:**
   - Always run `mvn clean test` before committing
   - Fix any failures first
   - Don't push broken code

---

## 🔗 Useful Links

- [Java Downloads](https://www.oracle.com/java/technologies/downloads/)
- [Maven Downloads](https://maven.apache.org/download.cgi)
- [Git Downloads](https://git-scm.com)
- [ChromeDriver](https://chromedriver.chromium.org)
- [Selenium Docs](https://www.selenium.dev/documentation/)
- [Cucumber Docs](https://cucumber.io/docs/cucumber/)

---

## 📞 Need Help?

If you encounter issues:

1. **Check this document's troubleshooting section**
2. **Read QUICK_START.md for beginner tips**
3. **Read README.md for detailed information**
4. **Ask your team lead or mentor**
5. **Search for the error message online**

---

## 🎓 Common Git Commands

```bash
# Check project status
git status

# Pull latest changes
git pull origin main

# Create your own branch
git checkout -b feature/my-new-feature

# Add changes
git add .

# Commit with message
git commit -m "Add login tests for forgot password"

# Push to your branch
git push origin feature/my-new-feature

# Switch back to main
git checkout main
```

---

**You're all set! Happy testing! 🚀**

For detailed framework documentation, see [README.md](README.md)  
For beginner-friendly guide, see [QUICK_START.md](QUICK_START.md)

Last Updated: December 31, 2025
