# CloudEagle UI Automation Framework

This is a test automation framework built using **Java + Selenium WebDriver** for automating and validating key workflows on the [CloudEagle Sandbox Platform](https://sandbox20.cloudeagle.info/app/application).  
The framework follows the **Page Object Model (POM)** design pattern and focuses on clean architecture, modular code, and real-world synchronization and assertion strategies.

---

## Objective

Automate two core flows:
1. **Login Functionality**
2. **Dashboard to Applications Page Validation**

> Credentials Used  
> **Username**: support+sandbox20@cloudeagle.ai  
> **Password**: `[x1nkS6]8~f]A#U;`

---

## Tech Stack

| Tool        | Purpose                          |
|-------------|----------------------------------|
| Java        | Programming Language             |
| Selenium    | UI Automation                    |
| TestNG      | Test Execution                   |
| Maven       | Build & Dependency Management    |
| POM         | Design Pattern for Code Modularity |
| ExtentReports | Reporting Framework            |
| Log4j       | Logging                          |

---

## Automated Test Cases

### Test Case 1: Valid Login

- Navigate to login page
- Enter valid credentials
- Assert successful login (e.g., page title or URL check)

### Test Case 2: Dashboard → Applications Count Validation

- Get "Managed Applications" count from Dashboard (e.g. `countFromDashboard`)
- Click the Managed Applications card/link
- On the Applications page, count the number of listed apps (`countFromApplicationPage`)
- **Assertion**:  
  `countFromDashboard == countFromApplicationPage`

---

## Project Structure

├── src
│ ├── main
│ │ └── java
│ │ ├── pages/ # Page classes using POM
│ │ └── utils/ # Waits, driver setup, config
│ └── test
│ └── tests/ # Test cases
├── reports/ # Extent HTML reports
├── logs/ # Execution logs
├── testng.xml # Test suite config
├── pom.xml # Maven dependencies
└── README.md


---

## Run Instructions

### 1. Clone the Repository
  ```bash
git clone https://github.com/your-username/cloudeagle-ui-automation.git
cd cloudeagle-ui-automation
```

### 2. Run Tests via Maven
```bash
mvn clean test
```

## Reports

- Upon execution, an HTML report is generated under reports/ folder.
- Screenshots are captured for failed test steps.
- Logs are saved in the logs/ directory.

## Video demonstration
Watch the full walk-through of the framework, structure, execution, and explanation here:
👉 Watch on YouTube: https://youtu.be/-be0rbJDPJY

## Highlights
- Reusable page and utility classes
- Clean separation of test logic and UI interaction
- Synchronization with explicit waits
- Readable reports and logging
- Easy execution from terminal or CI/CD

## Author
- Name: Sayantan Mukherjee
- GitHub: https://github.com/sayantanviky
- LinkedIn: https://www.linkedin.com/in/sayantan-mukherjee-9975b3b7
