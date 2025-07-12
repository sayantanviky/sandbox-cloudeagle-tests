package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.DashboardPage;
import pageObjects.UserLogin;
import testBase.BaseClass;

//import static pageObjects.BasePage.driver;

public class DashboardTest extends BaseClass {
    UserLogin userLogin;
    DashboardPage dashboardPage;

    @BeforeClass
    public void setup() {
        dashboardPage = new DashboardPage(driver); // driver is initialized from BaseClass
    }


    @Test(priority = 1)
    public void validLoginFlow() {
        userLogin = new UserLogin(driver);
        userLogin.usernameEntryBox(p.getProperty("Username"));
        userLogin.passwordEntryBox(p.getProperty("Password"));
        userLogin.hitSignIn();
    }

    //Test Case#2: Dashboard page: Start a ‘New Procurement Request’ from the dashboard & submit the request.
    @Test(priority = 2)
    public void clickOnDashboardButton() {
        dashboardPage.goToDashboardPage(driver);
    }

    @Test(priority = 3)
    public void checkIfUserIsOnDashboardPage() {
        try {
            Assert.assertTrue(dashboardPage.userIsOnDashboardPage());
        }catch (Exception e){
            Assert.fail();
            logger.info(" User is not on dashboard page");
            logger.debug("Debugg logger starting...");
        }
    }

    //Go to 'Alerts': Pick any alert category such as ‘Contracts coming up for renewal in the next 180 days
    @Test(priority = 4)
    public void scrollToSpecificAlertCategory() {
        logger.info("******* Going to alerts section and choosing alert category of Applications below 70% usage **********");
        dashboardPage.scrollToSpecificAlertCategory();
    }

    //Add automation to test any one of the ‘Actions’ item such as ‘Ignore’
    @Test(priority = 5)
    public void setIgnoreOnAlertItem() {
        logger.info("****** Automating to test action item Ignore *******");
        dashboardPage.clickIgnoreOnActionItem(driver);
    }

    @Test(priority = 6)
    public void confirmIgnoreOnActionItem() {
        dashboardPage.confirmIgnoreOnActionItem();
    }

}
